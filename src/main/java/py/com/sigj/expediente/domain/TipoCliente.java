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

import py.com.sigj.main.GenericEntity;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "tipoCliente_codigo_uk", columnNames = { "codigo" }) })
public class TipoCliente extends GenericEntity {
	private static final String SECUENCIA = "tipoCliente_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "tipoCliente.codigo.notNull")
	@NotBlank(message = "tipoCliente.codigo.notBlank")
	@Size(max = 2, message = "tipoCliente.codigo.size")
	private String codigo;

	@NotNull(message = "tipoCliente.nombre.notNull")
	@NotBlank(message = "tipoCliente.nombre.notBlank")
	@Size(max = 100, message = "tipoCliente.nombre.size")
	private String descripcion;

	public TipoCliente() {

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
		return "TipoCliente [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

}
