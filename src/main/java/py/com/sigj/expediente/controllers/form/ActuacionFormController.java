package py.com.sigj.expediente.controllers.form;

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
import py.com.sigj.expediente.controllers.list.ActuacionListController;
import py.com.sigj.expediente.dao.ActuacionDao;
import py.com.sigj.expediente.domain.Actuacion;

@Controller
@Scope("request")
@RequestMapping("actuacion")
public class ActuacionFormController extends FormController<Actuacion> {

	@Autowired
	private ActuacionDao actuacionDao;

	@Autowired
	private ActuacionListController actuacionList;

	@Override
	public String getTemplatePath() {
		return "expediente/actuacion_index";
	}

	@Override
	public String getNombreObjeto() {
		return "actuacion";
	}

	@Override
	public Actuacion getNuevaInstancia() {
		return new Actuacion();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("actuacionList", actuacionDao.getList(0, 20, null));
		map.addAttribute("columnas", actuacionList.getColumnas());
		map.addAttribute("columnasStr", actuacionList.getColumnasStr(null));

		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Actuacion> getDao() {
		return actuacionDao;
	}

	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Actuacion obj, BindingResult bindingResult,
			@RequestParam(required = false) String accion,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, obj, bindingResult);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO ACTUACION {}", obj);
			return editar_listado(map, obj, bindingResult);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @Valid Actuacion obj, BindingResult bindingResult) {
		try {
			if (obj.getId() == null) {
				getDao().createOrUpdate(obj);
			}

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
	public String editar_listado(ModelMap map, @Valid Actuacion obj, BindingResult bindingResult) {
		try {
			logger.info("ID DE OBJ {}", obj);
			if (obj != null) {
				getDao().createOrUpdate(obj);
			}

			logger.info("Actuación Actualizada {}", obj);
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
		Actuacion actuacion = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				actuacion = getDao().find(id_objeto);

				getDao().destroy(actuacion);

				logger.info("Actuacion eliminada {}", actuacion);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (Exception ex) {

			actuacion.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), actuacion);
		}

		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}
}
