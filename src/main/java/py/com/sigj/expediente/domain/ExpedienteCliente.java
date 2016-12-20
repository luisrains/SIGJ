package py.com.sigj.expediente.domain;

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

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "expediente_cliente_uk", columnNames = { "expediente_id", "cliente_id" }) })
public class ExpedienteCliente extends GenericEntity {
	private static final String SECUENCIA = "expedienteCliente_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "expedienteCliente.expediente.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expedienteCliente_expediente_fk"))
	private Expediente expediente;

	@ManyToOne
	@NotNull(message = "expedienteCliente.cliente.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expedienteCliente_cliente_fk"))
	private Cliente cliente;

	public ExpedienteCliente() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "expedienteCliente [id=" + id + ", cliente=" + cliente + ", expediente=" + expediente + "]";
	}

}
