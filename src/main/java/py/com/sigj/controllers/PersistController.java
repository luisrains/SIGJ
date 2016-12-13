package py.com.owl.owlapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import py.com.owl.owlapp.dao.Dao;
import py.com.owl.owlapp.domain.GenericEntity;
import py.com.owl.owlapp.main.Message;
import py.com.owl.owlapp.validation.ErrorCampo;

public abstract class PersistController<T extends GenericEntity> {
	@Autowired
	protected Message msg;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Respuesta<T> find(@PathVariable Long id) {
		Respuesta<T> resp = new Respuesta<>();

		try {
			T obj = getDao().find(id);
			if (obj == null) {
				throw new Exception("No se encontró usuario");
			}
			resp.setDato(obj);
			resp.setExito(true);
		} catch (Exception ex) {
			resp.setExito(false);
			resp.setMensajeError(ex.getMessage());

		}
		return resp;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Respuesta<T> createOrUpdate(@Valid T obj, BindingResult bindingResult) {
		Respuesta<T> resp = new Respuesta<>();

		try {
			if (bindingResult.hasErrors()) {
				resp.setExito(false);
				resp.setMensajeError(msg.get("errores_validacion"));
				List<FieldError> errores = bindingResult.getFieldErrors();
				List<ErrorCampo> erList = new ArrayList<>();
				for (FieldError fe : errores) {
					ErrorCampo ec = new ErrorCampo();
					ec.setField(fe.getField());
					ec.setRejectedValue(fe.getRejectedValue());
					ec.setDefaultMessage(fe.getDefaultMessage());
					ec.setObjectName(fe.getObjectName());
					erList.add(ec);
				}
				resp.setErrores(erList);
			} else {
				if (obj.getId() == null) {
					getDao().create(obj);
					resp.setMensajeExito(msg.get("registro_agregado"));

				} else {
					getDao().edit(obj);
					resp.setMensajeExito(msg.get("registro_agregado"));
				}
				resp.setExito(true);
			}
			resp.setDato(obj);
		} catch (Exception ex) {
			resp.setExito(false);
			resp.setMensajeError(ex.getMessage());
		}
		return resp;
	}

	public abstract Dao<T> getDao();
}
