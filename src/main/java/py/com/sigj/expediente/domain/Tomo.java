package py.com.sigj.expediente.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "tomo_expdientePadre_uk", columnNames = { "expedientePadre_id" }) })
public class Tomo extends GenericEntity {
	private static final String SECUENCIA = "tomo_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "tomo.codigo.notNull")
	private Expediente ExpedientePadre;

	public Tomo() {

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Expediente getExpedientePadre() {
		return ExpedientePadre;
	}

	public void setExpedientePadre(Expediente expedientePadre) {
		ExpedientePadre = expedientePadre;
	}

	@Override
	public String toString() {
		return "Tomo [id=" + id + expedientePadre=" + expedientePadre + "]";
	}

}
