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
@Table(name = "movimiento")
public class Movimiento extends GenericEntity {
	private static final String SECUENCIA = "movimiento_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "movimiento.ingreso.notNull")
	private int ingreso;

	@NotNull(message = "movimiento.egreso.notNull")
	private int egreso;

	@NotNull(message = "movimiento.fecha.notNull")
	private Date fecha;
	
	@NotNull(message = "movimiento.descripcion.notNull")
	private String descripcion;

	@ManyToOne
	@NotNull(message = "movimiento.empleado.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "movimiento_empleado_fk"))
	private Empleado empleado;

	public Movimiento() {
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

	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "MovimientoEmpleado [id=" + id + ", ingreso=" + ingreso + ", egreso=" + egreso + ", fecha=" + fecha
				+ ", descripcion=" + descripcion + ", empleado=" + empleado + "]";
	}

	

}
