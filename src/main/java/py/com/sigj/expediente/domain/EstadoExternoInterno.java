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

/**
 * Clase que relaciona un posible estado con su correspondiente expediente.
 * 
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "estado_externo_interno", uniqueConstraints = {
		@UniqueConstraint(name = "estadoExternoInternoInterno_codigo_uk", columnNames = { "codigo" }) })
public class EstadoExternoInterno extends GenericEntity {
	private static final String SECUENCIA = "estadoExternoInternoInterno_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "estadoExternoInterno.codigo.notNull")
	@NotBlank(message = "estadoExternoInterno.codigo.notBlank")
	@Size(max = 5, message = "estadoExternoInterno.codigo.size")
	private String codigo;

	@NotNull(message = "estadoExternoInterno.descripcion.notNull")
	@NotBlank(message = "estadoExternoInterno.descripcion.notBlank")
	@Size(max = 100, message = "estadoExternoInterno.descripcion.size")
	private String descripcion;

	@NotNull(message = "estadoExternoInterno.tipoEstado.notNull")
	private char tipoEstado;

	public EstadoExternoInterno() {
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

	public char getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(char tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	@Override
	public String toString() {
		return "EstadoExternoInternoInterno [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion
				+ ", tipoEstado=" + tipoEstado + "]";
	}

}
