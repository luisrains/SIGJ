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
import javax.validation.constraints.NotNull;

import py.com.sigj.main.GenericEntity;

/**
 * Clase en el que se registrarán los tipos de materias que existen en el poder.
 * judicial Ej: Civil y Comercial, Justicia Letrada,Laboral,Penal.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "materia_proceso")
public class MateriaProceso extends GenericEntity {
	private static final String SECUENCIA = "materiaProceso_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "materiaProceso.materia.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "materiaProceso_materia_fk"))
	private Materia materia;

	@ManyToOne
	@NotNull(message = "materiaProceso.proceso.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "materiaProceso_proceso_fk"))
	private Proceso proceso;

	public MateriaProceso() {
		super();
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Proceso getProceso() {
		return proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	@Override
	public String toString() {
		return "MateriaProceso [id=" + id + ", materia=" + materia + ", proceso=" + proceso + "]";
	}

}
