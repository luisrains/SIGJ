package py.com.sigj.controllers.form;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.com.sigj.controllers.PersistController;
import py.com.sigj.controllers.Respuesta;
import py.com.sigj.dao.Dao;
import py.com.sigj.main.GenericEntity;
import py.com.sigj.main.Message;
import py.com.sigj.main.SesionUsuario;
import py.com.sigj.security.Usuario;

public abstract class FormController<T extends GenericEntity> extends PersistController<T> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected Message msg;

	@Autowired
	private SesionUsuario sesionUsuario;

	@RequestMapping
	public String index(ModelMap map) {

		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();// "cliente/cliente_index";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String guardar(ModelMap map, @Valid T obj, BindingResult bindingResult) {
		logger.info("parametros {}", obj);
		Respuesta<T> resp = createOrUpdate(obj, bindingResult);

		if (resp.isExito()) {
			map.addAttribute("msgExito", resp.getMensajeExito());
		} else {
			map.addAttribute("error", resp.getMensajeError());
			map.addAttribute("errorList", resp.getErrores());
		}

		map.addAttribute(getNombreObjeto(), resp.getDato());
		agregarValoresAdicionales(map);
		return getTemplatePath();
	}

	@RequestMapping("edit/{id}") // "cliente/edit/{id}"
	public String edit(ModelMap map, @PathVariable Long id) {
		Respuesta<T> resp = find(id);
		if (resp.isExito()) {
			map.addAttribute(getNombreObjeto(), resp.getDato());
		} else {
			map.addAttribute(getNombreObjeto(), getNuevaInstancia());
			map.addAttribute("error", resp.getMensajeError());
		}

		agregarValoresAdicionales(map);
		return getTemplatePath();
		// return "cliente/cliente_index";
	}

	@RequestMapping("delete/{id}") // "cliente/edit/{id}"
	public String delete(ModelMap map, @PathVariable Long id) {
		Respuesta<T> resp = destroy(id);
		if (resp.isExito()) {
			map.addAttribute(getNombreObjeto(), resp.getMensajeExito());
			map.addAttribute("msgExito", resp.getMensajeExito());
		} else {
			map.addAttribute("error", resp.getMensajeError());
			map.addAttribute("errorList", resp.getErrores());
		}

		map.addAttribute(getNombreObjeto(), resp.getDato());
		agregarValoresAdicionales(map);
		return getTemplatePath();
	}

	public abstract String getTemplatePath();

	public abstract String getNombreObjeto();

	public abstract T getNuevaInstancia();

	@Override
	public abstract Dao<T> getDao();

	/**
	 * Cuando ocurre una excepción, el error que se muestra es muy genérico. Se
	 * debe recorrer el stack de error y verificar si no fue error de constraint
	 * (valores duplicados, etc.)
	 */
	private String getErrorFromException(final Exception exception) {
		Throwable th = exception;
		while (th != null) {
			if (th.getClass().equals(org.hibernate.exception.ConstraintViolationException.class)) {
				ConstraintViolationException cve = (ConstraintViolationException) th;
				return msg.get(cve.getConstraintName());
			}
			th = th.getCause();
		}
		return exception.getMessage();
	}

	public void agregarValoresAdicionales(ModelMap map) {

	}

	@ModelAttribute("currentUserName")
	public String currentUserName() {
		if (sesionUsuario.isLogger()) {
			Usuario u = sesionUsuario.getUsuario();
			return u.getNombre() + "(" + u.getCodigo() + ")";
		}
		return "Anónimo";
	}

}
