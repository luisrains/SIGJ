package py.com.sigj.gastos.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import py.com.sigj.main.GenericEntity;

/**
 *
 * @author ariquelme
 *
 */

@Entity
@Table(name = "factura_detalle", uniqueConstraints = {
		@UniqueConstraint(name = "factura_detalle_uk", columnNames = { "facturacabecera_id", "servicio_id" }) })
public class FacturaDetalle extends GenericEntity {
	private static final String SECUENCIA = "facturaDetalle_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "facturaDetalle.facturaCabecera.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "facturaDetalle_facturaCabecera_fk"))
	private FacturaCabecera facturaCabecera;

	@ManyToOne
	@NotNull(message = "facturaDetalle.servicio.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "facturaDetalle_servicio_fk"))
	private Servicio servicio;
	
	
	private int ivaCinco;
	private int ivaDiez;
	@NotNull(message = "facturaDetalle.monto.notNull")
	private int monto;
	
	
	
	@NotNull(message = "facturaDetalle.nro.notNull")
	private int nro;

	public FacturaDetalle() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public FacturaCabecera getFacturaCabecera() {
		return facturaCabecera;
	}

	public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
		this.facturaCabecera = facturaCabecera;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public int getIvaCinco() {
		return ivaCinco;
	}

	public void setIvaCinco(int ivaCinco) {
		this.ivaCinco = ivaCinco;
	}

	public int getIvaDiez() {
		return ivaDiez;
	}

	public void setIvaDiez(int ivaDiez) {
		this.ivaDiez = ivaDiez;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	
	
	
	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [id=" + id + ", facturaCabecera=" + facturaCabecera + ", servicio=" + servicio
				+ ", ivaCinco=" + ivaCinco + ", ivaDiez=" + ivaDiez + ", monto=" + monto + ", nro=" + nro + "]";
	}

	

	
	
	

}
