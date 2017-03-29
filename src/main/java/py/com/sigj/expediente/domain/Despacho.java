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

/**
 * Clase que registra todos los despachos que se encuentran activos en el
 * palacio de justicia.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
public class Despacho extends GenericEntity {
	private static final String SECUENCIA = "despacho_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "despacho.descripcion.notNull")
	@NotBlank(message = "despacho.descripcion.notBlank")
	@Size(max = 100, message = "despacho.descripcion.size")
	private String descripcion;

	@NotNull(message = "despacho.juez.notNull")
	@NotBlank(message = "despacho.juez.notBlank")
	@Size(max = 60, message = "despacho.juez.size")
	private String juez;

	// @ManyToOne
	// @NotNull(message = "despacho.materia.notNull")
	// @JoinColumn(foreignKey = @ForeignKey(name = "despacho_materia_fk"))
	// private Materia materia;

	public Despacho() {

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

	public String getJuez() {
		return juez;
	}

	public void setJuez(String juez) {
		this.juez = juez;
	}

	// public Materia getMateria() {
	// return materia;
	// }
	//
	// public void setMateria(Materia materia) {
	// this.materia = materia;
	// }
	//
	// @Override
	// public String toString() {
	// return "Despacho [id=" + id + ", Descripcion=" + descripcion + ", Juez="
	// + juez + ", materia=" + materia + "]";
	// }

}
