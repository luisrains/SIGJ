package py.com.sigj.expediente.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

/**
 * Clase que registra los tipos de actuaciones que existen en un proceso.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "tipo_actuacion")
public class TipoActuacion extends GenericEntity {
	private static final String SECUENCIA = "tipoActuacion_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "tipoActuacion.nombre.notNull")
	@NotBlank(message = "tipoActuacion.nombre.notBlank")
	@Size(max = 60, message = "tipoActuacion.nombre.size")
	private String nombre;

	@NotNull(message = "tipoActuacion.modeloHoja.notNull")
	@NotBlank(message = "tipoActuacion.modeloHoja.notBlank")
	@Size(max = 60, message = "tipoActuacion.modeloHoja.size")
	private String modeloHoja;

	public TipoActuacion() {

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModeloHoja() {
		return modeloHoja;
	}

	public void setModeloHoja(String modeloHoja) {
		this.modeloHoja = modeloHoja;
	}

	@Override
	public String toString() {
		return "TipoActuacion [id=" + id + ", nombre=" + nombre + ", modeloHoja=" + modeloHoja + "]";
	}

}
