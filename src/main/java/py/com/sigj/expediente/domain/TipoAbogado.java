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
@Table(uniqueConstraints = { @UniqueConstraint(name = "tipoAbogado_codigo_uk", columnNames = { "codigo" }) })
public class TipoAbogado extends GenericEntity {
	private static final String SECUENCIA = "tipoAbogado_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "tipoAbogado.codigo.notNull")
	@NotBlank(message = "tipoAbogado.codigo.notBlank")
	@Size(max = 5, message = "tipoAbogado.codigo.size")
	private String codigo;

	@NotNull(message = "tipoAbogado.descripcion.notNull")
	@NotBlank(message = "tipoAbogado.descripcion.notBlank")
	@Size(max = 15, message = "tipoAbogado.descripcion.size")
	private String descripcion;

	public TipoAbogado() {

	}

	public TipoAbogado(Long id, String codigo, String descripcion) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
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

	public String getdescripcion() {
		return descripcion;
	}

	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "tipoAbogado [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

}
