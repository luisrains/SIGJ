package py.com.sigj.rrhh.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import py.com.sigj.expediente.domain.Expediente;
import py.com.sigj.main.GenericEntity;

/**
 * Clase intermedia entre el expediente y el o los cliente asociados.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "movimiento_expediente")
public class MovimientoExpediente extends GenericEntity {
	private static final String SECUENCIA = "movimientoExpediente_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "movimientoExpediente.movimiento.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "movimientoExpediente_movimiento_fk"))
	private Movimiento movimiento;

	@ManyToOne
	@NotNull(message = "movimientoExpediente.expediente.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "movimientoExpediente_expediente_fk"))
	private Expediente expediente;

	public MovimientoExpediente() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	@Override
	public String toString() {
		return "MovimientoExpediente [id=" + id + ", movimiento=" + movimiento + ", expediente=" + expediente + "]";
	}

	

}
