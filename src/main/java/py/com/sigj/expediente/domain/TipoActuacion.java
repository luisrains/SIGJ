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

	@NotNull(message = "tipoActuacion.descripcion.notNull")
	@NotBlank(message = "tipoActuacion.descripcion.notBlank")
	@Size(max = 60, message = "tipoActuacion.descripcion.size")
	private String descripcion;

	@NotNull(message = "tipo_actuacion.abreviatura.notNull")
	@NotBlank(message = "tipo_actuacion.abreviatura.notBlank")
	@Size(max = 10, message = "tipo_actuacion.abreviatura.size")
	private String abreviatura;

	//	@NotNull(message = "tipoActuacion.modeloHoja.notNull")
//	@NotBlank(message = "tipoActuacion.modeloHoja.notBlank")
//	@Size(max = 60, message = "tipoActuacion.modeloHoja.size")
//	private String modeloHoja;
	
	@NotNull(message = "tipoActuacion.plazo.notNull")
	private int plazo;
	

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	@Override
	public String toString() {
		return "TipoActuacion [id=" + id + ", descripcion=" + descripcion + ", abreviatura=" + abreviatura + ", plazo="
				+ plazo + "]";
	}

}
