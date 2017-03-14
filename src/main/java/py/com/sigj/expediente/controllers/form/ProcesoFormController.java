package py.com.sigj.expediente.controllers.form;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.ProcesoListController;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.dao.ProcesoDao;
import py.com.sigj.expediente.dao.ProcesoTipoDemandaDao;
import py.com.sigj.expediente.dao.TipoDemandaDao;
import py.com.sigj.expediente.domain.Proceso;
import py.com.sigj.expediente.domain.ProcesoTipoDemanda;
import py.com.sigj.expediente.domain.TipoDemanda;

@Controller
@Scope("request")
@RequestMapping("proceso")
public class ProcesoFormController extends FormController<Proceso> {

	@Autowired
	private ProcesoDao procesoDao;

	@Autowired
	private MateriaDao materiaDao;

	@Autowired
	private TipoDemandaDao tipoDemandaDao;

	@Autowired
	private ProcesoTipoDemandaDao procesoTipoDemandaDao;

	@Autowired
	private ProcesoListController procesoList;

	@Override
	public String getTemplatePath() {
		return "expediente/proceso_index";
	}

	@Override
	public String getNombreObjeto() {
		return "proceso";
	}

	@Override
	public Proceso getNuevaInstancia() {
		return new Proceso();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("materiaList", materiaDao.getList(0, 20, null));
		map.addAttribute("tipoDemandaList", tipoDemandaDao.getList(0, 20, null));
		logger.info("tipo demanda", tipoDemandaDao.getList(0, 20, null));
		map.addAttribute("columnas", procesoList.getColumnas());
		map.addAttribute("columnasStr", procesoList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Proceso> getDao() {
		return procesoDao;
	}

	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Proceso obj, @RequestParam("selec") List<String> selec,
			BindingResult bindingResult, @RequestParam(required = false) String accion,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, selec, obj, bindingResult);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO PROCESO {}", obj);
			return editar_listado(map, selec, obj, bindingResult);
		} else if (id_objeto != null) {
			return eliminar_listado(map, selec, id_objeto, bindingResult);

		}
		return getTemplatePath();

	}

	private String eliminar_listado(ModelMap map, List<String> selec, Long id_objeto, BindingResult bindingResult) {

		try {
			Proceso obj = getDao().find(id_objeto);
			if (obj == null) {
				map.addAttribute("error", "No se encontró registros con el id " + id_objeto);
			} else {
				getDao().destroy(obj);
				obj = getNuevaInstancia();
				map.addAttribute(getNombreObjeto(), obj);
				map.addAttribute("msgExito", msg.get("Registro eliminado"));
				logger.info("registro eliminado");
			}
		} catch (Exception ex) {
			map.addAttribute("error", "Error al eliminar registro. " + ex.getMessage());

		}
		agregarValoresAdicionales(map);
		logger.info("registro retorna {}", getTemplatePath());
		return getTemplatePath();
	}

	/*
	 * falta llamar al controler de procesoTipoDemanda para poder mandarle un
	 * proceso y un tipo de demanda y asi cargar la tabla intermedia
	 */
	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @RequestParam("selec") List<String> selec, @Valid Proceso obj,
			BindingResult bindingResult) {
		try {

			if (obj.getId() == null) {
				getDao().create(obj);
				for (String idLong : selec) {
					Long idFormat = Long.parseLong(idLong);
					// creamos un tipoDemanda con el proceso y el tipo
					// de
					// demanda seleccionado
					ProcesoTipoDemanda porcesoTipoDemanda = new ProcesoTipoDemanda();
					// porcesoTipoDemanda.setProceso(obj);
					// buscamos el tipoDemanda
					TipoDemanda tipoDemanda = tipoDemandaDao.find(idFormat);
					porcesoTipoDemanda.setTipoDemanda(tipoDemanda);
					procesoTipoDemandaDao.create(porcesoTipoDemanda);
					logger.info("procesoTipoDemanda Creado {}", porcesoTipoDemanda);
				}

				map.addAttribute("msgExito", msg.get("Registro agregado"));
			}

		} catch (Exception ex) {
			// TODO: tener en cuenta si es nuevo o edit
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));

		}

		map.addAttribute(getNombreObjeto(), obj);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "editar_listado", method = RequestMethod.POST)
	public String editar_listado(ModelMap map, @RequestParam("selec") List<String> selec, @Valid Proceso obj,
			BindingResult bindingResult) {
		try {
			logger.info("ID DE OBJ {}", obj);
			if (obj != null) {
				getDao().edit(obj);
				for (String idLong : selec) {
					Long idFormat = Long.parseLong(idLong);
					// creamos un tipoDemanda con el proceso y el tipo
					// de
					// demanda seleccionado
					ProcesoTipoDemanda procesoTipoDemanda = new ProcesoTipoDemanda();
					// procesoTipoDemanda.setProceso(obj);
					// buscamos el tipoDemanda
					TipoDemanda tipoDemanda = tipoDemandaDao.find(idFormat);
					procesoTipoDemanda.setTipoDemanda(tipoDemanda);
					// Llamamos a al dao de procesoTipoDemanda para obtener una
					// lista de acuerdo al proceso y tipo demanda
					Long idProcesoTipoDemanda = procesoTipoDemandaDao.getListWhere(obj.getId(), idFormat);
					if (idProcesoTipoDemanda == null) {
						procesoTipoDemandaDao.create(procesoTipoDemanda);
						logger.info("Se creo un nuevo Proceso Tipo Demanda {}", procesoTipoDemanda);
					} else {
						procesoTipoDemanda.setId(idProcesoTipoDemanda);
						// Dao.edit
						procesoTipoDemandaDao.edit(procesoTipoDemanda);
						logger.info("procesoTipoDemanda Actualizado {}", procesoTipoDemanda);
					}

				}
				map.addAttribute("msgExito", msg.get("Registro agregado"));
			} else {
				getDao().edit(obj);
				map.addAttribute("msgExito", msg.get("Registro Actualizado"));
			}

		} catch (Exception ex) {
			// TODO: tener en cuenta si es nuevo o edit
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));

		}

		map.addAttribute(getNombreObjeto(), obj);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "/obtener_listado", method = RequestMethod.GET)
	public @ResponseBody List<TipoDemanda> getListaTipoDemanda(
			@RequestParam(value = "demanda_id", required = true) Long id) {
		List<TipoDemanda> tipoDemandaList = null;
		try {

			tipoDemandaList = procesoDao.getListaTipoDemanda(id);

		} catch (Exception ex) {
			logger.info("error {}", ex);

		}
		return tipoDemandaList;
	}

}
