package py.com.sigj.expediente.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

@Entity
public class Expediente extends GenericEntity {

	private static final String SECUENCIA = "expediente_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "cliente.domicilioLaboral.notNull")
	@NotBlank(message = "cliente.domicilioLaboral.notBlank")
	@Size(max = 100, message = "cliente.domicilioLaboral.size")
	private String caratula;

	@NotNull(message = "cliente.domicilioProcesal.notNull")
	@NotBlank(message = "cliente.domicilioProcesal.notBlank")
	@Size(max = 100, message = "cliente.domicilioProcesal.size")
	private String nroExpediente;

	@NotNull(message = "rol.codigo.notNull")
	@NotBlank(message = "rol.codigo.notBlank")
	@Size(max = 20, message = "rol.codigo.size")
	private String anho;

	@NotNull(message = "cliente.domicilioActual.notNull")
	private int monto;

	@NotNull(message = "rol.codigo.notNull")
	@NotBlank(message = "rol.codigo.notBlank")
	@Size(max = 20, message = "rol.codigo.size")
	private String moneda;

	@NotNull(message = "cliente.domicilioLaboral.notNull")
	@NotBlank(message = "cliente.domicilioLaboral.notBlank")
	@Size(max = 100, message = "cliente.domicilioLaboral.size")
	private String objetoCausa;

	@NotNull(message = "cliente.domicilioProcesal.notNull")
	@NotBlank(message = "cliente.domicilioProcesal.notBlank")
	@Size(max = 100, message = "cliente.domicilioProcesal.size")
	private String nroLiquidación;

	@Temporal(TemporalType.DATE)
	private Date fechaSelloCargo;

	// tabla dependencia , tabla que depende y fk
	@ManyToOne
	@NotNull(message = "expediente.estadoInterno.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_estadoInterno_fk"))
	private EstadoInterno estadoInterno;

	@ManyToOne
	@NotNull(message = "expediente.estadoExterno.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_estadoExterno_fk"))
	private EstadoExterno estadoExterno;

	@ManyToOne
	@NotNull(message = "expediente.tipoDemanda.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_tipoDemanda_fk"))
	private TipoDemanda tipoDemanda;

	@ManyToOne
	@NotNull(message = "expediente.despacho.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_despacho_fk"))
	private Despacho despacho;

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

	public String getObjetoCausa() {
		return objetoCausa;
	}

	public void setObjetoCausa(String objetoCausa) {
		this.objetoCausa = objetoCausa;
	}

	public String getNroLiquidación() {
		return nroLiquidación;
	}

	public void setNroLiquidación(String nroLiquidación) {
		this.nroLiquidación = nroLiquidación;
	}

	public Date getFechaSelloCargo() {
		return fechaSelloCargo;
	}

	public void setFechaSelloCargo(Date fechaSelloCargo) {
		this.fechaSelloCargo = fechaSelloCargo;
	}

	public EstadoInterno getEstadoInterno() {
		return estadoInterno;
	}

	public void setEstadoInterno(EstadoInterno estadoInterno) {
		this.estadoInterno = estadoInterno;
	}

	public EstadoExterno getEstadoExterno() {
		return estadoExterno;
	}

	public void setEstadoExterno(EstadoExterno estadoExterno) {
		this.estadoExterno = estadoExterno;
	}

	public TipoDemanda getTipoDemanda() {
		return tipoDemanda;
	}

	public void setTipoDemanda(TipoDemanda tipoDemanda) {
		this.tipoDemanda = tipoDemanda;
	}

	public Despacho getDespacho() {
		return despacho;
	}

	public void setDespacho(Despacho despacho) {
		this.despacho = despacho;
	}

	@Override
	public String toString() {
		return "Expediente [id=" + id + ", caratula=" + caratula + ", nroExpediente=" + nroExpediente + ", anho=" + anho
				+ ", monto=" + monto + ", moneda=" + moneda + ", objetoCausa=" + objetoCausa + ", nroLiquidación="
				+ nroLiquidación + ", fechaSelloCargo=" + fechaSelloCargo + ", estadoInterno=" + estadoInterno
				+ ", estadoExterno=" + estadoExterno + ", tipoDemanda=" + tipoDemanda + ", despacho=" + despacho + "]";
	}

}