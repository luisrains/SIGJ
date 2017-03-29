package py.com.sigj.gastos.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

/**
 * Clase que registra los tipos de servicios, los cuales pueden ser: consultas,
 * gestiones varias.
 *
 * @author ariquelme
 */

@Entity
@Table
public class Caja extends GenericEntity {
	private static final String SECUENCIA = "caja_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "caja.codigo.notNull")
	@NotBlank(message = "caja.codigo.notBlank")
	@Size(max = 5, message = "caja.codigo.size")
	private String codigo;

	@NotNull(message = "caja.ingreso.notNull")
	@NotBlank(message = "caja.ingreso.notBlank")
	@Size(max = 100, message = "caja.ingreso.size")
	private String ingreso;
	
	@NotNull(message = "caja.egreso.notNull")
	@NotBlank(message = "caja.egreso.notBlank")
	@Size(max = 100, message = "caja.egreso.size")
	private String egreso;
	
	@NotNull(message = "caja.descripcion.notNull")
	@NotBlank(message = "caja.descripcion.notBlank")
	@Size(max = 100, message = "caja.descripcion.size")
	private String descripcion;	
	
	@NotNull(message = "caja.monto.notNull")
	private int monto;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	public Caja() {
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

	public String getIngreso() {
		return ingreso;
	}

	public void setIngreso(String ingreso) {
		this.ingreso = ingreso;
	}
	
	public String getEgreso() {
		return egreso;
	}

	public void setEgreso(String egreso) {
		this.egreso = egreso;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.egreso = descripcion;
	}
	
	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Caja [id=" + id + ", codigo=" + codigo + ", monto=" + monto + ", fecha=" + fecha + "]";
	}

}
