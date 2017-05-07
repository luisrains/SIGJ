package py.com.sigj.expediente.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class Expediente extends GenericEntity {

	private static final String SECUENCIA = "expediente_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "expediente.caratula.notNull")
	@NotBlank(message = "expediente.caratula.notBlank")
	@Size(max = 100, message = "expediente.caratula.size")
	private String caratula;

	@NotNull(message = "expediente.nroExpediente.notNull")
	@NotBlank(message = "expediente.nroExpediente.notBlank")
	@Size(max = 100, message = "expediente.nroExpediente.size")
	private String nroExpediente;

	@NotNull(message = "expediente.anho.notNull")
	@NotBlank(message = "expediente.anho.notBlank")
	@Size(max = 20, message = "expediente.anho.size")
	private String anho;

	@NotNull(message = "expediente.monto.notNull")
	private int monto;

	@NotNull(message = "expediente.moneda.notNull")
	@NotBlank(message = "expediente.moneda.notBlank")
	@Size(max = 20, message = "expediente.moneda.size")
	private String moneda;

	@NotNull(message = "expediente.folio.notNull")
	@NotBlank(message = "expediente.folio.notBlank")
	@Size(max = 20, message = "expediente.folio.size")
	private String folio;

	@Size(max = 100, message = "expediente.nroLiquidacion.size")
	private String nroLiquidación;

	@Temporal(TemporalType.DATE)
	private Date fechaSelloCargo;

	// materia,proceso, tipo demanda

	@ManyToOne
	@NotNull(message = "expediente.tipoDemanda.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_tipodemanda_fk"))
	private TipoDemanda tipoDemanda;

	@ManyToOne
	@NotNull(message = "expediente.despacho.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_despacho_fk"))
	private Despacho despacho;

	@ManyToOne
	@NotNull(message = "expediente.estadoExternoInterno.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_estadoExternoInterno_fk"))
	private EstadoExternoInterno estadoExternoInterno;

	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinTable(name = "expediente_abogado", joinColumns = @JoinColumn(name = "expediente_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "abogado_id", referencedColumnName = "id"))
	private Set<Abogado> listaAbogadoApoderado;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinTable(name = "expediente_abogados", joinColumns = @JoinColumn(name = "expediente_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "abogado_id", referencedColumnName = "id"))
	private Set<Abogado> listaAbogadoContraparte;
	// @ManyToOne
	// @NotNull(message = "expediente.estadoExterno.notNull")
	// @JoinColumn(foreignKey = @ForeignKey(name =
	// "expediente_estadoExterno_fk"))
	// private EstadoExternoInterno estadoExterno;
	//
	// @ManyToOne
	// @NotNull(message = "expediente.tipoDemanda.notNull")
	// @JoinColumn(foreignKey = @ForeignKey(name = "expediente_tipoDemanda_fk"))
	// private TipoDemanda tipoDemanda;
	//
	// @ManyToOne
	// @NotNull(message = "expediente.despacho.notNull")
	// @JoinColumn(foreignKey = @ForeignKey(name = "expediente_despacho_fk"))
	// private Despacho despacho;

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

	// public EstadoExternoInterno getEstadoExterno() {
	// return estadoExterno;
	// }
	//
	// public void setEstadoExterno(EstadoExternoInterno estadoExterno) {
	// this.estadoExterno = estadoExterno;
	// }
	//
	// public TipoDemanda getTipoDemanda() {
	// return tipoDemanda;
	// }
	//
	// public void setTipoDemanda(TipoDemanda tipoDemanda) {
	// this.tipoDemanda = tipoDemanda;
	// }
	//
	// public Despacho getDespacho() {
	// return despacho;
	// }
	//
	// public void setDespacho(Despacho despacho) {
	// this.despacho = despacho;
	// }
	//
	// @Override
	// public String toString() {
	// return "Expediente [id=" + id + ", caratula=" + caratula + ",
	// nroExpediente=" + nroExpediente + ", anho=" + anho
	// + ", monto=" + monto + ", moneda=" + moneda + ", objetoCausa=" +
	// objetoCausa + ", nroLiquidación="
	// + nroLiquidación + ", fechaSelloCargo=" + fechaSelloCargo + ",
	// estadoExterno=" + estadoExterno
	// + ", tipoDemanda=" + tipoDemanda + ", despacho=" + despacho + "]";
	// }

}