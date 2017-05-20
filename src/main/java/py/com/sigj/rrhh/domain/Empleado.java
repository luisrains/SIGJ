package py.com.sigj.rrhh.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import py.com.sigj.expediente.domain.Persona;
import py.com.sigj.main.GenericEntity;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "empleado_persona_uk", columnNames = { "persona_id" }) })
public class Empleado extends GenericEntity {
	private static final String SECUENCIA = "empleado_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "empleado.salario.notNull")
	private int salario;

	/* tablas dependencias */
	@ManyToOne
	@NotNull(message = "empleado.persona.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "empleado_persona_fk"))
	private Persona persona;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "empleado.fechaIngreso.notNull")
	private Date fechaIngreso;

	public Empleado() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", salario=" + salario + ", persona=" + persona + ", fechaIngreso=" + fechaIngreso
				+ "]";
	}

}
