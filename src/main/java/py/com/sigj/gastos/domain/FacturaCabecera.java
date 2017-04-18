package py.com.sigj.gastos.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import py.com.sigj.expediente.domain.Abogado;
import py.com.sigj.expediente.domain.Cliente;
import py.com.sigj.main.GenericEntity;

/**
 *
 * @author ariquelme
 *
 */

@Entity
@Table(name = "factura_cabecera")
public class FacturaCabecera extends GenericEntity {
	private static final String SECUENCIA = "facturaCabecera_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	
	@NotNull(message = "facturaCabecera.telefono.notNull")
	private int telefono;
	
	@NotNull(message = "facturaCabecera.ruc.notNull")
	private String ruc;
	
	@NotNull(message = "facturaCabecera.razon_social.notNull")
	private String razonSocial;
	
	@NotNull(message = "facturaCabecera.direccion.notNull")
	private String direccion;
	
	

	@NotNull(message = "facturaCabecera.fecha_emision.notNull")
	private String fechaEmision;
	
	
	
	
	@NotNull(message = "facturaCabecera.tipo_pago.notNull")
	private String tipoPago;
	
	private int totalIvaCinco;
	private int totalIvaDiez;
	@NotNull(message = "facturaCabecera.monto_total.notNull")
	private int montoTotal;
	
	public FacturaCabecera() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}


	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	
	
	public int getTotalIvaCinco() {
		return totalIvaCinco;
	}

	public void setTotalIvaCinco(int totalIvaCinco) {
		this.totalIvaCinco = totalIvaCinco;
	}

	public int getTotalIvaDiez() {
		return totalIvaDiez;
	}

	public void setTotalIvaDiez(int totalIvaDiez) {
		this.totalIvaDiez = totalIvaDiez;
	}

	public int getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(int montoTotal) {
		this.montoTotal = montoTotal;
	}

	@Override
	public String toString() {
		return "FacturaCabecera [id=" + id + ", telefono=" + telefono + ", ruc=" + ruc + ", razonSocial=" + razonSocial
				+ ", direccion=" + direccion + ", fechaEmision=" + fechaEmision + ", tipoPago=" + tipoPago
				+ ", totalIvaCinco=" + totalIvaCinco + ", totalIvaDiez=" + totalIvaDiez + ", montoTotal=" + montoTotal
				+ "]";
	}

	
	
	

	

	
}
