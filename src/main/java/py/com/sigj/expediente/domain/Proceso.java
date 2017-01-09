package py.com.sigj.expediente.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

/**
 * Clase que registra los procesos que existen de acuerdo al tipo de materia que
 * se registran en el sistema.
 * 
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "proceso_codigo_uk", columnNames = { "codigo" }) })
public class Proceso extends GenericEntity {
	private static final String SECUENCIA = "proceso_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "proceso.codigo.notNull")
	@NotBlank(message = "proceso.codigo.notBlank")
	@Size(max = 5, message = "proceso.codigo.size")
	private String codigo;

	@NotNull(message = "proceso.descripcion.notNull")
	@NotBlank(message = "proceso.descripcion.notBlank")
	@Size(max = 20, message = "proceso.descripcion.size")
	private String Descripcion;

	@ManyToOne
	@NotNull(message = "proceso.materia.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "proceso_materia_fk"))
	private Materia materia;

	public Proceso() {

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
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Proceso [id=" + id + ", codigo=" + codigo + ", Descripcion=" + Descripcion + ", materia=" + materia
				+ "]";
	}

}
