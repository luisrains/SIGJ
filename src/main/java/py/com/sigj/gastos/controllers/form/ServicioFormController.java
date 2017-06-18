package py.com.sigj.gastos.controllers.form;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.controllers.list.ServicioListController;
import py.com.sigj.gastos.dao.ServicioDao;
import py.com.sigj.gastos.domain.Servicio;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("request")
@RequestMapping("servicio")
public class ServicioFormController extends FormController<Servicio> {

	@Autowired
	private ServicioDao servicioDao;

	@Autowired
	private ServicioListController servicioList;

	@Override
	public String getTemplatePath() {
		return "gastos/servicio_index";
	}

	@Override
	public String getNombreObjeto() {
		return "servicio";
	}

	@Override
	public Servicio getNuevaInstancia() {
		return new Servicio();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", servicioList.getColumnas());
		map.addAttribute("columnasStr", servicioList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Servicio> getDao() {
		return servicioDao;
	}

	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Servicio obj, @RequestParam(required = false) String accion,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, obj);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO CAJA {}", obj);
			return editar_listado(map, obj);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);
		}
		return getTemplatePath();

	}

	@RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	public String eliminar_listado(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		Servicio servicio = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				servicio = getDao().find(id_objeto);
				getDao().destroy(servicio);

				logger.info("Servicio eliminada {}", servicio);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (Exception ex) {
			servicio.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), servicio);
		}
		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @Valid Servicio obj) {
		try {

			if (obj.getId() == null) {
				obj.setCosto(obj.getCosto().replaceAll("\\.", ""));
				getDao().createOrUpdate(obj);
				map.addAttribute("msgExito", msg.get("Registro agregado"));
				logger.info("Se crea una nueva Servicio -> {}", obj);
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
	public String editar_listado(ModelMap map, @Valid Servicio obj) {
		try {
			logger.info("ID DE OBJ {}", obj);
			obj.setCosto(obj.getCosto().replaceAll("\\.", ""));
			getDao().createOrUpdate(obj);
			logger.info("Servicio Actualizada {}", obj);
			map.addAttribute("msgExito", msg.get("Registro Actualizado"));

		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), obj);
		}
		agregarValoresAdicionales(map);
		return getTemplatePath();
	}
}
