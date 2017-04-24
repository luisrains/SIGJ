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

import py.com.sigj.controllers.list.UsuarioListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.dao.RolDao;
import py.com.sigj.dao.UsuarioDao;

import py.com.sigj.security.Usuario;

@Controller
@Scope("request")
@RequestMapping("usuario")
public class UsuarioFormController extends FormController<Usuario> {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private RolDao rolDao;
	@Autowired
	private UsuarioListController usuarioList;

	@Override
	public String getTemplatePath() {
		return "usuario/usuario_index";
	}

	@Override
	public String getNombreObjeto() {
		return "usuario";
	}

	@Override
	public Usuario getNuevaInstancia() {
		return new Usuario();
	}

	@Override
	public Dao<Usuario> getDao() {
		return usuarioDao;
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		
		map.addAttribute("rolList", rolDao.getList(0, 20, null));
		map.addAttribute("columnas", usuarioList.getColumnas());
		map.addAttribute("columnasStr", usuarioList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}
	
	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Usuario obj, BindingResult bindingResult,
			@RequestParam(required = false) String accion,
			@RequestParam(required = true) String rol,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		
		if (StringUtils.equals(accion, "save")) {
			rol = rol.substring(0, 1);
			return guardar_listado(map,rol,obj, bindingResult);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO Usuario {}", obj);
			return editar_listado(map,rol,obj, bindingResult);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map,@RequestParam(required = true) String rol, @Valid Usuario obj,
			 BindingResult bindingResult) {
		try {
			if (obj.getId() == null && rol != null) {
				Long idFormat = Long.parseLong(rol);
				obj.setRol(rolDao.find(idFormat));
				
				getDao().createOrUpdate(obj);
				 
				map.addAttribute("msgExito", msg.get("Registro agregado"));
				logger.info("Se crea un nuevo Usuario -> {}", obj);
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
	public String editar_listado(ModelMap map,@RequestParam(required = true) String rol,@Valid Usuario obj, BindingResult bindingResult) {
		try {
			if (obj.getId() != null && rol != null) {
				Long idFormat = Long.parseLong(rol);
				obj.setRol(rolDao.find(idFormat));
				
				getDao().createOrUpdate(obj);
				logger.info("Usuario Actualizado {}", obj);
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
		
		Usuario usuario = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				usuario = getDao().find(id_objeto);
				
				getDao().destroy(usuario);

				logger.info("Usuario eliminado  {}", usuario);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (UnexpectedRollbackException ex) {
			usuario.setId(null);
			map.addAttribute("error", "No puede borrar el Objeto");
			map.addAttribute(getNombreObjeto(), usuario);
		}
		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}
}
