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
@Table(uniqueConstraints = { @UniqueConstraint(name = "materia_codigo_uk", columnNames = { "codigo" }) })
public class Materia extends GenericEntity {
	private static final String SECUENCIA = "materia_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "tomo.codigo.notNull")
	@NotBlank(message = "tomo.codigo.notBlank")
	@Size(max = 5, message = "tomo.codigo.size")
	private String codigo;

	@NotNull(message = "tomo.descripcion.notNull")
	@NotBlank(message = "tomo.descripcion.notBlank")
	@Size(max = 20, message = "tomo.descripcion.size")
	private String Descripcion;

	public Materia() {

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", codigo=" + codigo + ", Descripcion=" + Descripcion + "]";
	}

}
