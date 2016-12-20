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
		@UniqueConstraint(name = "tomo_expediente_uk", columnNames = { "tomo_id", "expediente_id" }) })
public class TomoExpediente extends GenericEntity {
	private static final String SECUENCIA = "tomoExpediente_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "tomoExpediente.tomo.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "tomoExpediente_tomo_fk"))
	private Tomo tomo;

	@ManyToOne
	@NotNull(message = "tomoExpediente.expediente.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "tomoExpediente_expediente_fk"))
	private Expediente expediente;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public TomoExpediente() {

	}

	public Tomo getTomo() {
		return tomo;
	}

	public void setTomo(Tomo tomo) {
		this.tomo = tomo;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	@Override
	public String toString() {
		return "TomoExpediente [id=" + id + ", tomo=" + tomo + ", expediente=" + expediente + "]";
	}

}
