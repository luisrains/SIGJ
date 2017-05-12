package py.com.sigj.security;

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

import py.com.sigj.main.GenericEntity;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "permiso_codigo_uk", columnNames = { "codigo" }) })
public class Permiso extends GenericEntity {
	private static final String SECUENCIA = "permiso_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "permiso.codigo.notNull")
	@NotBlank(message = "permiso.codigo.notBlank")
	@Size(max = 20, message = "permiso.codigo.size")
	private String codigo;

	@NotNull(message = "permiso.descripcion.notNull")
	@NotBlank(message = "permiso.descripcion.notBlank")
	@Size(max = 100, message = "permiso.descripcion.size")
	private String descripcion;

	public Permiso() {
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
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Permiso [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

	

}
