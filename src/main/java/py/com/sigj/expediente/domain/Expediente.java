package py.com.sigj.expediente.domain;

import java.util.Date;

import javax.persistence.Column;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

/**
 * Clase que mapea un expediente en papel a digital.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name="expediente", uniqueConstraints = { @UniqueConstraint(name = "expediente_nroExpediente_uk", columnNames = { "nroExpediente" }) })
public class Expediente extends GenericEntity {

	private static final String SECUENCIA = "expediente_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "expediente.caratula.notNull")
	@NotBlank(message = "expediente.caratula.notBlank")
	@Size(max = 800, message = "expediente.caratula.size")
	private String caratula;

	@NotNull(message = "expediente.nroExpediente.notNull")
	@NotBlank(message = "expediente.nroExpediente.notBlank")
	@Size(max = 100, message = "expediente.nroExpediente.size")
	private String nroExpediente;

	@NotNull(message = "expediente.anho.notNull")
	@NotBlank(message = "expediente.anho.notBlank")
	@Size(max = 20, message = "expediente.anho.size")
	private String anho;
	
	private int monto;

	private String moneda;

	//datos de las actuaciones
	@Column(name="fecha_actuacion") 
	 private Date fechaUltimaActuacion;
	

	@Size(max = 150, message = "expediente.ultimaActuacion.size")
	private String tipoUltimaActuacion;
	
	//fin de las actuaciones
	 
	
	@NotNull(message = "expediente.folio.notNull")
	@NotBlank(message = "expediente.folio.notBlank")
	@Size(max = 20, message = "expediente.folio.size")
	private String folio;

	@Size(max = 100, message = "expediente.nroLiquidacion.size")
	private String nroLiquidacion;

	@Temporal(TemporalType.DATE)
	private Date fechaSelloCargo;

	// El expediente está en un despacho por vez,
	// podriamos tener un despachoAnterior y despachoActual
	@ManyToOne
	@NotNull(message = "expediente.despacho.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_despacho_fk"))
	private Despacho despachoActual;
	
	@ManyToOne
	@NotNull(message = "expediente.estado.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_estadoInterno_fk"))
	private EstadoExternoInterno estadoInterno;
	
	@ManyToOne
	@NotNull(message = "expediente.estado.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_estadoExterno_fk"))
	private EstadoExternoInterno estadoExterno;

	public Expediente() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	public String getNroExpediente() {
		return nroExpediente;
	}

	public void setNroExpediente(String nroExpediente) {
		this.nroExpediente = nroExpediente;
	}

	public String getAnho() {
		return anho;
	}

	public void setAnho(String anho) {
		this.anho = anho;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getNroLiquidacion() {
		return nroLiquidacion;
	}

	public void setNroLiquidacion(String nroLiquidacion) {
		this.nroLiquidacion = nroLiquidacion;
	}

	public Date getFechaSelloCargo() {
		return fechaSelloCargo;
	}

	public void setFechaSelloCargo(Date fechaSelloCargo) {
		this.fechaSelloCargo = fechaSelloCargo;
	}

	public Despacho getDespachoActual() {
		return despachoActual;
	}

	public void setDespachoActual(Despacho despachoActual) {
		this.despachoActual = despachoActual;
	}

	public EstadoExternoInterno getEstadoInterno() {
		return estadoInterno;
	}

	public void setEstadoInterno(EstadoExternoInterno estadoInterno) {
		this.estadoInterno = estadoInterno;
	}

	public EstadoExternoInterno getEstadoExterno() {
		return estadoExterno;
	}

	public void setEstadoExterno(EstadoExternoInterno estadoExterno) {
		this.estadoExterno = estadoExterno;
	}

	public Date getFechaUltimaActuacion() {
		return fechaUltimaActuacion;
	}

	public void setFechaUltimaActuacion(Date fechaUltimaActuacion) {
		this.fechaUltimaActuacion = fechaUltimaActuacion;
	}

	public String getTipoUltimaActuacion() {
		return tipoUltimaActuacion;
	}

	public void setTipoUltimaActuacion(String tipoUltimaActuacion) {
		this.tipoUltimaActuacion = tipoUltimaActuacion;
	}

	@Override
	public String toString() {
		return "Expediente [id=" + id + ", caratula=" + caratula + ", nroExpediente=" + nroExpediente + ", anho=" + anho
				+ ", monto=" + monto + ", moneda=" + moneda + ", fechaUltimaActuacion=" + fechaUltimaActuacion
				+ ", tipoUltimaActuacion=" + tipoUltimaActuacion + ", folio=" + folio + ", nroLiquidacion="
				+ nroLiquidacion + ", fechaSelloCargo=" + fechaSelloCargo + ", despachoActual=" + despachoActual
				+ ", estadoInterno=" + estadoInterno + ", estadoExterno=" + estadoExterno + "]";
	}

	
	
}