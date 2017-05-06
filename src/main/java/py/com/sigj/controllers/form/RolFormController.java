package py.com.sigj.controllers.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import py.com.sigj.dao.RolPermisoDao;
import py.com.sigj.security.Permiso;
import py.com.sigj.security.Rol;
import py.com.sigj.security.RolPermiso;

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
	
	@Autowired
	RolPermisoDao rolPermisoDao;
	
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
			@RequestParam(required = false) String accion,HttpServletRequest request,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		
	
		if (StringUtils.equals(accion, "save")) {
			
			return guardar_listado(map, permiso, obj, bindingResult,request);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO PROCESO {}", obj);
			return editar_listado(map, permiso, obj, bindingResult,request);
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
				List<RolPermiso> rp = rolPermisoDao.eliminarPorRol(rol.getId());
				for(RolPermiso rpp : rp){
					rolPermisoDao.destroy(rpp);
				}
				
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
			BindingResult bindingResult, HttpServletRequest request) {
		
		try {
			HttpSession session = request.getSession();
			
			
			
			if (obj.getId() == null && permiso != null) {
				List<Permiso> listPermiso = new ArrayList<Permiso>();
				for(String s : permiso){
					Long idFormat = Long.parseLong(s);
					listPermiso.add(permisoDao.find(idFormat));
				}
				obj.setListPermiso(listPermiso);
				getDao().createOrUpdate(obj);
				Rol rol_aux = rolDao.buscarRol(obj.getCodigo());
				for (String idLong : permiso) {
					RolPermiso rp = new RolPermiso();
					rp.setRol(rol_aux);
					Long idFormat = Long.parseLong(idLong);
					rp.setPermiso(permisoDao.find(idFormat));
					
					rolPermisoDao.create(rp);
				}
			}
			
			
			
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
			BindingResult bindingResult,HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			List<Permiso> list = new ArrayList<Permiso>();
			logger.info("ID DE OBJ {}", obj);
			if (obj != null && permiso != null) {
				list = permisoDao.ListByRol(obj);
				for (Permiso p : list) {
					RolPermiso rp = new RolPermiso();
					rp =rolPermisoDao.eliminarPorPermiso(obj.getId(), p.getId());
					rolPermisoDao.destroy(rp);
				}
				for (String idLong : permiso) {
					RolPermiso rp = new RolPermiso();
					rp.setRol(obj);
					Long idFormat = Long.parseLong(idLong);
					rp.setPermiso(permisoDao.find(idFormat));
					
					rolPermisoDao.create(rp);
				}
			}
			List<Permiso> listPermiso = new ArrayList<Permiso>();
			for(String s : permiso){
				Long idFormat = Long.parseLong(s);
				listPermiso.add(permisoDao.find(idFormat));
			}
			obj.setListPermiso(listPermiso);
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
