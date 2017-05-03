package py.com.sigj.controllers.form;

import java.util.ArrayList;
import java.util.List;

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

import py.com.sigj.controllers.list.RolListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.dao.PermisoDao;
import py.com.sigj.dao.RolDao;

import py.com.sigj.security.Permiso;
import py.com.sigj.security.Rol;

@Controller
@Scope("request")
@RequestMapping("rol")
public class RolFormController extends FormController<Rol> {

	@Autowired
	RolDao rolDao;
	
	@Autowired
	private RolListController rolList;
	
	@Autowired
	PermisoDao permisoDao;
	
	@Override
	public String getTemplatePath() {
		
		return "seguridad/rol_index";
	}

	@Override
	public String getNombreObjeto() {
		
		return "rol";
	}

	@Override
	public Rol getNuevaInstancia() {
		
		return new Rol();
	}

	@Override
	public Dao<Rol> getDao() {
		
		return rolDao;
	}
	
	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", rolList.getColumnas());
		map.addAttribute("columnasStr", rolList.getColumnasStr(null));
		map.addAttribute("permisoList", permisoDao.getList(0, 100, null));
	}
	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Rol obj,
			@RequestParam(value = "permiso", required = false) List<String> permiso, BindingResult bindingResult,
			@RequestParam(required = false) String accion,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, permiso, obj, bindingResult);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO PROCESO {}", obj);
			return editar_listado(map, permiso, obj, bindingResult);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	@RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	public String eliminar_listado(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		List<Permiso> list = new ArrayList<Permiso>();
		Rol rol = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				rol = getDao().find(id_objeto);
				rol.setListPermiso(list);
				getDao().destroy(rol);

				logger.info("Rol eliminado {}", rol);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (UnexpectedRollbackException ex) {
			rol.setId(null);
			map.addAttribute("error", "No puede borrar un rol ya que un permiso hace referencia a él.");
			map.addAttribute(getNombreObjeto(), rol);
		}
		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @RequestParam("selec") List<String> permiso, @Valid Rol obj,
			BindingResult bindingResult) {
		try {
			List<Permiso> list = new ArrayList<Permiso>();
			if (obj.getId() == null && permiso != null) {
				for (String idLong : permiso) {
					Long idFormat = Long.parseLong(idLong);
					list.add(permisoDao.find(idFormat));
				}
			}
			obj.setListPermiso(list);
			getDao().createOrUpdate(obj);

			map.addAttribute("msgExito", msg.get("Registro agregado"));
			logger.info("Se crea un nuevo Rol -> {}", obj);
		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
		}
		map.addAttribute(getNombreObjeto(), obj);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "editar_listado", method = RequestMethod.POST)
	public String editar_listado(ModelMap map, @RequestParam("selec") List<String> permiso, @Valid Rol obj,
			BindingResult bindingResult) {
		try {
			List<Permiso> list = new ArrayList<Permiso>();
			logger.info("ID DE OBJ {}", obj);
			if (obj != null && permiso != null) {
				for (String idLong : permiso) {
					Long idFormat = Long.parseLong(idLong);
					list.add(permisoDao.find(idFormat));
				}
			}
			obj.setListPermiso(list);
			getDao().createOrUpdate(obj);
			logger.info("Rol Actualizado {}", obj);
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
