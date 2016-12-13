package py.com.sigj.controllers;

import java.util.List;

import py.com.sigj.validation.ErrorCampo;

public class Respuesta<T> {

	private boolean exito;
	private T dato;
	private String mensajeExito;
	private String mensajeError;
	private List<ErrorCampo> errores;

	public List<ErrorCampo> getErrores() {
		return errores;
	}

	public void setErrores(List<ErrorCampo> errores) {
		this.errores = errores;
	}

	public boolean isExito() {
		return exito;
	}

	public void setExito(boolean exito) {
		this.exito = exito;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public String getMensajeExito() {
		return mensajeExito;
	}

	public void setMensajeExito(String mensajeExito) {
		this.mensajeExito = mensajeExito;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

}
