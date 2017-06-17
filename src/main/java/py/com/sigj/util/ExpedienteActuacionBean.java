package py.com.sigj.util;

import py.com.sigj.expediente.domain.Expediente;
import py.com.sigj.expediente.domain.MovimientoActuacion;

public class ExpedienteActuacionBean {

	private Expediente expediente;
	private MovimientoActuacion actuacion;
	private int diaVencimiento;
	
	
	
	
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
	
	public int getDiaVencimiento() {
		return diaVencimiento;
	}
	public void setDiaVencimiento(int diaVencimiento) {
		this.diaVencimiento = diaVencimiento;
	}
	@Override
	public String toString() {
		return "ExpedienteActuacionBean [expediente=" + expediente + ", actuacion=" + actuacion + ", diaVencimiento="
				+ diaVencimiento + "]";
	}
	
	
}
