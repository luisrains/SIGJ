package py.com.sigj.expediente.controllers.form;

import java.util.ArrayList;
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

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.MateriaListController;
import py.com.sigj.expediente.dao.DespachoDao;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.dao.ProcesoDao;
import py.com.sigj.expediente.domain.Despacho;
import py.com.sigj.expediente.domain.Materia;
import py.com.sigj.expediente.domain.Proceso;

@Controller
@Scope("request")
@RequestMapping("materia")
public class MateriaFormController extends FormController<Materia> {

	@Autowired
	private MateriaDao materiaDao;

	@Autowired
	private MateriaListController materiaList;

	@Autowired
	private ProcesoDao procesoDao;

	@Autowired
	private DespachoDao despachoDao;

	@Override
	public String getTemplatePath() {
		return "expediente/materia_index";
	}

	@Override
	public String getNombreObjeto() {
		return "materia";
	}

	@Override
	public Materia getNuevaInstancia() {
		return new Materia();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", materiaList.getColumnas());
		map.addAttribute("columnasStr", materiaList.getColumnasStr(null));
		map.addAttribute("procesoList", procesoDao.getList(0, 20, null));
		map.addAttribute("despachoList", despachoDao.getList(0, 20, null));
		logger.info("procesoList", procesoDao.getList(0, 20, null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Materia> getDao() {
		return materiaDao;
	}

	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Materia obj,
			@RequestParam(value = "selec_proceso", required = false) List<String> selecProceso,
			BindingResult bindingResult,
			@RequestParam(value = "selec_despacho", required = false) List<String> selecDespacho,
			@RequestParam(required = false) String accion,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, selecProceso, selecDespacho, obj, bindingResult);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO PROCESO {}", obj);
			return editar_listado(map, selecProceso, selecDespacho, obj, bindingResult);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @RequestParam("selec_proceso") List<String> selecProceso,
			@RequestParam(value = "selec_despacho", required = false) List<String> selecDespacho, @Valid Materia obj,
			BindingResult bindingResult) {
		try {
			List<Proceso> listProceso = new ArrayList<Proceso>();
			List<Despacho> listDespacho = new ArrayList<Despacho>();
			if (obj.getId() == null && selecProceso != null) {
				for (String idLong : selecProceso) {
					Long idFormat = Long.parseLong(idLong);
					listProceso.add(procesoDao.find(idFormat));
				}
			}
			if (obj.getId() == null && selecDespacho != null) {
				for (String idLong : selecDespacho) {
					Long idFormat = Long.parseLong(idLong);
					listDespacho.add(despachoDao.find(idFormat));
				}
			}

			obj.setListaProceso(listProceso);
			obj.setListaDespacho(listDespacho);
			getDao().createOrUpdate(obj);

			map.addAttribute("msgExito", msg.get("Registro agregado"));
			logger.info("Se crea la materia -> {}", obj);

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
	public String editar_listado(ModelMap map, @RequestParam("selec_proceso") List<String> selecProceso,
			@RequestParam(value = "selec_despacho", required = false) List<String> selecDespacho, @Valid Materia obj,
			BindingResult bindingResult) {
		try {
			List<Proceso> listProceso = new ArrayList<Proceso>();
			List<Despacho> listDespacho = new ArrayList<Despacho>();
			logger.info("ID DE OBJ {}", obj);
			if (obj != null && selecProceso != null) {
				for (String idLong : selecProceso) {
					Long idFormat = Long.parseLong(idLong);
					listProceso.add(procesoDao.find(idFormat));
				}
			}
			if (obj != null && selecDespacho != null) {
				for (String idLong : selecDespacho) {
					Long idFormat = Long.parseLong(idLong);
					listDespacho.add(despachoDao.find(idFormat));
				}
			}
			obj.setListaProceso(listProceso);
			obj.setListaDespacho(listDespacho);
			getDao().createOrUpdate(obj);
			logger.info("procesoTipoDemanda Actualizado {}", obj);
			map.addAttribute("msgExito", msg.get("Registro Actualizado"));

		} catch (Exception ex) {
			// TODO: tener en cuenta si es nuevo o edit
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), obj);
		}

		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	public String eliminar_listado(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		List<Proceso> listProceso = new ArrayList<Proceso>();
		List<Despacho> listDespacho = new ArrayList<Despacho>();
		Materia m = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				m = getDao().find(id_objeto);
				m.setListaProceso(listProceso);
				m.setListaDespacho(listDespacho);
				materiaDao.destroy(m);

				logger.info("Materia eliminada {}", m);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (Exception ex) {

			m.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), m);
		}

		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

}