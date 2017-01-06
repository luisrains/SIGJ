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
import javax.validation.constraints.NotNull;

import py.com.sigj.main.GenericEntity;

@Entity
@Table
public class MovimientoEmpleado extends GenericEntity {
	private static final String SECUENCIA = "movimientoEmpleado_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "movimientoEmpleado.ingreso.notNull")
	private int ingreso;

	@NotNull(message = "movimientoEmpleado.egreso.notNull")
	private int egreso;

	@NotNull(message = "movimientoEmpleado.fecha.notNull")
	private Date fecha;

	@ManyToOne
	@NotNull(message = "MovimientoEmpleado.empleado.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "movimientoEmpleado_empleado_fk"))
	private Empleado empleado;

	public MovimientoEmpleado() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public int getIngreso() {
		return ingreso;
	}

	public void setIngreso(int ingreso) {
		this.ingreso = ingreso;
	}

	public int getEgreso() {
		return egreso;
	}

	public void setEgreso(int egreso) {
		this.egreso = egreso;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "MovimientoEmpleado [id=" + id + ", ingreso=" + ingreso + ", egreso=" + egreso + ", fecha=" + fecha
				+ ", empleado=" + empleado + "]";
	}

}
