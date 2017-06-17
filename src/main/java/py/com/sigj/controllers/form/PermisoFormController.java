package py.com.sigj.controllers.form;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import py.com.sigj.controllers.list.PermisoListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.dao.PermisoDao;
import py.com.sigj.gastos.domain.IngresoEgreso;
import py.com.sigj.security.Permiso;


@Controller
@Scope("request")
@RequestMapping("permiso")
public class PermisoFormController extends FormController<Permiso>{

	@Autowired
	PermisoDao permisoDao;
	
	@Autowired
	private PermisoListController permisoList;
	
	@Override
	public String getTemplatePath() {
		
		return "seguridad/permiso_index";
	}

	@Override
	public String getNombreObjeto() {
		
		return "permiso";
	}

	@Override
	public Permiso getNuevaInstancia() {
		
		return new Permiso();
	}

	@Override
	public Dao<Permiso> getDao() {
		
		return permisoDao;
	}
	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", permisoList.getColumnas());
		map.addAttribute("columnasStr", permisoList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}
	
	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Permiso obj, BindingResult bindingResult,
			@RequestParam(required = false) String accion,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, obj, bindingResult);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO Permiso {}", obj);
			return editar_listado(map, obj, bindingResult);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	
	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @Valid Permiso obj, BindingResult bindingResult) {
		try {
			if (obj.getId() == null) {
				getDao().createOrUpdate(obj);

				map.addAttribute("msgExito", msg.get("Registro agregado"));
				logger.info("Se crea un nuevo Permiso -> {}", obj);
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
	public String editar_listado(ModelMap map, @Valid Permiso obj, BindingResult bindingResult) {
		try {
			if (obj != null) {
				getDao().createOrUpdate(obj);
				logger.info("Permiso Actualizado {}", obj);
				map.addAttribute("msgExito", msg.get("Registro Actualizado"));
			}
		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), obj);
		}
		agregarValoresAdicionales(map);
		return getTemplatePath();
	}

	@RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	public String eliminar_listado(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		
		Permiso permiso = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				permiso = getDao().find(id_objeto);
				
				getDao().destroy(permiso);

				logger.info("Permiso eliminado  {}", permiso);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (UnexpectedRollbackException ex) {
			permiso.setId(null);
			map.addAttribute("error", "No puede borrar el Objeto");
			map.addAttribute(getNombreObjeto(), permiso);
		}
		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}
}
