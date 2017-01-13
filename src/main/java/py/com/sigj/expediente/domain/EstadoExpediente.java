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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import py.com.sigj.main.GenericEntity;

/**
 * Clase que relaciona el estado de un expediente, según las actuaciones.
 * cronológicas
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "estado_expediente")
// , uniqueConstraints = {
// @UniqueConstraint(name = "estado_expediente_uk", columnNames = {
// "estadoexternointerno_id",
// "expediente_id" }) })
public class EstadoExpediente extends GenericEntity {
	private static final String SECUENCIA = "estadoExpediente_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "estadoExpediente.tomo.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "estadoExpediente_estado_fk"))
	private EstadoExternoInterno estado;

	@ManyToOne
	@NotNull(message = "estadoExpediente.expediente.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "estadoExpediente_expediente_fk"))
	private Expediente expediente;

	@Temporal(TemporalType.DATE)
	private Date fechaEstado;

	public EstadoExpediente() {

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public EstadoExternoInterno getEstado() {
		return estado;
	}

	public void setEstado(EstadoExternoInterno estado) {
		this.estado = estado;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Date getFechaEstado() {
		return fechaEstado;
	}

	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	@Override
	public String toString() {
		return "EstadoExpediente [id=" + id + ", estado=" + estado + ", expediente=" + expediente + ", fechaEstado="
				+ fechaEstado + "]";
	}

}
