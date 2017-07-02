package py.com.sigj.util;

import py.com.sigj.expediente.domain.Expediente;

public class ExpedienteActuacionBean {

	private Expediente expediente;
	private int diaVencimiento;
	transient String renderDocumento;
	
	
	
	public ExpedienteActuacionBean() {
		super();
		
	}
	public Expediente getExpediente() {
		return expediente;
	}
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}
	
	public int getDiaVencimiento() {
		return diaVencimiento;
	}
	public void setDiaVencimiento(int diaVencimiento) {
		this.diaVencimiento = diaVencimiento;
	}
		
	public String getRenderDocumento() {
		return renderDocumento;
	}
	public void setRenderDocumento(String renderDocumento) {
		this.renderDocumento = renderDocumento;
	}
	@Override
	public String toString() {
		return "ExpedienteActuacionBean [expediente=" + expediente + ", diaVencimiento="
				+ diaVencimiento + "]";
	}
	
	
}
