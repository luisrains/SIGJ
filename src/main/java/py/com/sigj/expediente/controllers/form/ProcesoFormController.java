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
import py.com.sigj.expediente.controllers.list.ProcesoListController;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.dao.ProcesoDao;
import py.com.sigj.expediente.dao.TipoDemandaDao;
import py.com.sigj.expediente.domain.Proceso;
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
		map.addAttribute("columnas", procesoList.getColumnas());
		map.addAttribute("columnasStr", procesoList.getColumnasStr(null));
		map.addAttribute("tipoDemandaList", tipoDemandaDao.getList(0, 20, null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Proceso> getDao() {
		return procesoDao;
	}

	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Proceso obj,
			@RequestParam(value = "selec", required = false) List<String> selec, BindingResult bindingResult,
			@RequestParam(required = false) String accion,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, selec, obj, bindingResult);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO PROCESO {}", obj);
			return editar_listado(map, selec, obj, bindingResult);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	@RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	public String eliminar_listado(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		List<TipoDemanda> list = new ArrayList<TipoDemanda>();
		Proceso p = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				p = getDao().find(id_objeto);
				p.setListTipoDemanda(list);
				getDao().destroy(p);

				logger.info("Proceso eliminado {}", p);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (Exception ex) {
			p.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), p);
		}
		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @RequestParam("selec") List<String> selec, @Valid Proceso obj,
			BindingResult bindingResult) {
		try {
			List<TipoDemanda> list = new ArrayList<TipoDemanda>();
			if (obj.getId() == null) {
				for (String idLong : selec) {
					Long idFormat = Long.parseLong(idLong);
					list.add(tipoDemandaDao.find(idFormat));
				}
				obj.setListTipoDemanda(list);
				getDao().createOrUpdate(obj);

				map.addAttribute("msgExito", msg.get("Registro agregado"));
				logger.info("Se crea un nuevo Proceso -> {}", obj);
			}
		} catch (Exception ex) {
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
			List<TipoDemanda> list = new ArrayList<TipoDemanda>();
			logger.info("ID DE OBJ {}", obj);
			if (obj != null && selec != null) {
				for (String idLong : selec) {
					Long idFormat = Long.parseLong(idLong);
					list.add(tipoDemandaDao.find(idFormat));
				}
			}
			obj.setListTipoDemanda(list);
			getDao().createOrUpdate(obj);
			logger.info("Proceso Actualizado {}", obj);
			map.addAttribute("msgExito", msg.get("Registro Actualizado"));

		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), obj);
		}
		agregarValoresAdicionales(map);
		return getTemplatePath();
	}

	// @Override
	// public Dao<Proceso> getDaoList() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public TipoDemanda getInstanciaList() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
