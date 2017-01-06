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

import py.com.sigj.main.GenericEntity;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "planilla_empleado_uk", columnNames = { "planillaSalario_id", "empleado_id" }) })
public class PlanillaEmpleado extends GenericEntity {
	private static final String SECUENCIA = "planillaEmpleado_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "planillaEmpleado.planillaSalario.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "PlanillaEmpleado_planillaSalario_fk"))
	private PlanillaSalario planillaSalario;

	@ManyToOne
	@NotNull(message = "planillaEmpleado.permiso.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "PlanillaEmpleado_empleado_fk"))
	private Empleado empleado;

	public PlanillaEmpleado() {

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public PlanillaSalario getPlanillaSalario() {
		return planillaSalario;
	}

	public void setPlanillaSalario(PlanillaSalario planillaSalario) {
		this.planillaSalario = planillaSalario;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "PlanillaEmpleado [id=" + id + ", planillaSalario=" + planillaSalario + ", empleado=" + empleado + "]";
	}

}
