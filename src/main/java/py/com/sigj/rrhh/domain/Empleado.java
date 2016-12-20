package py.com.sigj.rrhh.domain;

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

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "empleado_codigo_uk", columnNames = { "codigo" }) })
public class Empleado extends GenericEntity {
	private static final String SECUENCIA = "empleado_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "empleado.codigo.notNull")
	@NotBlank(message = "empleado.codigo.notBlank")
	@Size(max = 20, message = "empleado.codigo.size")
	private String codigo;

	@NotNull(message = "empleado.salario.notNull")
	private int salario;

	/* tablas dependencias */
	@ManyToOne
	@NotNull(message = "empleado.persona.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "empleado_persona_fk"))
	private PersonaFisica persona;
	@ManyToOne
	@NotNull(message = "empleado.planillaSalario.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "empleado_planillaSalario_fk"))
	private PlanillaSalario planillaSalario;

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public PersonaFisica getPersona() {
		return persona;
	}

	public void setPersona(PersonaFisica persona) {
		this.persona = persona;
	}

	public PlanillaSalario getPlanillaSalario() {
		return planillaSalario;
	}

	public void setPlanillaSalario(PlanillaSalario planillaSalario) {
		this.planillaSalario = planillaSalario;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", codigo=" + codigo + ", salario=" + salario + "]";
	}

}
