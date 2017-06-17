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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

/**
 * Clase intermedia entre el expediente y el o los cliente asociados.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "expediente_cliente", uniqueConstraints = {
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

	@NotNull(message = "expedienteCliente.tipo.notNull")
	@NotBlank(message = "expedienteCliente.tipo.notBlank")
	@Size(max = 3, message = "expedienteCliente.tipo.size")
	private String TipoCliente;

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

	public String getTipoCliente() {
		return TipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		TipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "ExpedienteCliente [id=" + id + ", expediente=" + expediente + ", cliente=" + cliente + ", TipoCliente="
				+ TipoCliente + "]";
	}

}
