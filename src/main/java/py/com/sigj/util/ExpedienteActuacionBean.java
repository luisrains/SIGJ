package py.com.sigj.util;

import py.com.sigj.expediente.domain.Expediente;
import py.com.sigj.expediente.domain.MovimientoActuacion;

public class ExpedienteActuacionBean {

	private Expediente expediente;
	private MovimientoActuacion actuacion;
	
	
	
	
	public ExpedienteActuacionBean() {
		super();
		
	}
	public Expediente getExpediente() {
		return expediente;
	}
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}
	public MovimientoActuacion getActuacion() {
		return actuacion;
	}
	public void setActuacion(MovimientoActuacion actuacion) {
		this.actuacion = actuacion;
	}
	@Override
	public String toString() {
		return "ExpedienteActuacionBean [expediente=" + expediente + ", actuacion=" + actuacion + "]";
	}
	
	
}
