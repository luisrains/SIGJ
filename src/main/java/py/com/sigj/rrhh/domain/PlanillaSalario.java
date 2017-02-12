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
import javax.validation.constraints.NotNull;

import py.com.sigj.main.GenericEntity;

@Entity
@Table(name = "planilla_salario")
public class PlanillaSalario extends GenericEntity {
	private static final String SECUENCIA = "planillaSalario_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	private int montoCobro; // este valor es el que define el total a cobrar por
							// el empleado

	private int ingresoTotal;

	private int egresoTotal;

	@ManyToOne
	@NotNull(message = "planillaSalario.empleado.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "planillaSalario_empleado_fk"))
	private Empleado empleado;

	@ManyToOne
	@NotNull(message = "planillaSalario.planillaSueldo.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "planillaSalario_planillaSueldo_fk"))
	private PlanillaSueldo planillaSueldo;

	public PlanillaSalario() {
		super();

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public int getMontoCobro() {
		return montoCobro;
	}

	public void setMontoCobro(int montoCobro) {
		this.montoCobro = montoCobro;
	}

	public int getIngresoTotal() {
		return ingresoTotal;
	}

	public void setIngresoTotal(int ingresoTotal) {
		this.ingresoTotal = ingresoTotal;
	}

	public int getEgresoTotal() {
		return egresoTotal;
	}

	public void setEgresoTotal(int egresoTotal) {
		this.egresoTotal = egresoTotal;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public PlanillaSueldo getPlanillaSueldo() {
		return planillaSueldo;
	}

	public void setPlanillaSueldo(PlanillaSueldo planillaSueldo) {
		this.planillaSueldo = planillaSueldo;
	}

	@Override
	public String toString() {
		return "PlanillaSalario [id=" + id + ", montoCobro=" + montoCobro + ", ingresoTotal=" + ingresoTotal
				+ ", egresoTotal=" + egresoTotal + ", empleado=" + empleado + ", planillaSueldo=" + planillaSueldo
				+ "]";
	}

}
