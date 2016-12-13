package py.com.owl.owlapp.domain;

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
@Table(uniqueConstraints = { @UniqueConstraint(name = "tipo_cliente_codigo_uk", columnNames = { "codigo" }) })
public class TipoCliente extends GenericEntity {
	private static final String SECUENCIA = "cliente_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "tipoCliente.codigo.notNull")
	@NotBlank(message = "tipoCliente.codigo.notBlank")
	@Size(max = 5, message = "tipoCliente.codigo.size")
	private String codigo;

	@NotNull(message = "tipoCliente.nombre.notNull")
	@NotBlank(message = "tipoCliente.nombre.notBlank")
	@Size(max = 100, message = "tipoCliente.nombre.size")
	private String nombre;

	public TipoCliente() {

	}

	public TipoCliente(Long id, String codigo, String nombre) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoCliente [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}
