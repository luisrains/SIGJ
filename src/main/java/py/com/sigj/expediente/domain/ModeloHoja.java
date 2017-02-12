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
 * Clase que registra el modelo de hoja a ser mostrado cuando se quiera cargar una actuacion.
 * 
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "modelo_hoja")
public class ModeloHoja extends GenericEntity {
	private static final String SECUENCIA = "modeloHoja_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "modeloHoja.nombre.notNull")
	@NotBlank(message = "modeloHoja.nombre.notBlank")
	@Size(max = 100, message = "modeloHoja.nombre.size")
	private String descripcion;

	public ModeloHoja() {

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

	@Override
	public String toString() {
		return "ModeloHoja [id=" + id + ", descripcion=" + descripcion + "]";
	}

	
}
