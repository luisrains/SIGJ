package py.com.sigj.expediente.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

@Entity
public class TipoDemanda extends GenericEntity {
	private static final String SECUENCIA = "tipoDemanda_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "tipoDemanda.descripcion.notNull")
	@NotBlank(message = "tipoDemanda.descripcion.notBlank")
	@Size(max = 20, message = "tipoDemanda.descripcion.size")
	private String Descripcion;

	public TipoDemanda() {

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoDemanda [id=" + id + ", Descripcion=" + Descripcion + "]";
	}

}
