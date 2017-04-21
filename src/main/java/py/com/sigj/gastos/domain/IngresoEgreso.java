package py.com.sigj.gastos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

/**
 *
 * @author ariquelme
 *
 */

@Entity
@Table(name = "ingreso_egreso")
public class IngresoEgreso extends GenericEntity {
	private static final String SECUENCIA = "ingresoEgreso_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;
	
	@NotNull(message = "ingreso_egreso.monto.notNull")
	private int monto;

	@NotNull(message = "ingresoEgreso.tipo.notNull")
	@NotBlank(message = "ingresoEgreso.tipo.notBlank")
	@Size(max = 15, message = "ingresoEgreso.tipo.size")
	private String tipo;
	

	@NotNull(message = "ingresoEgreso.descripcion.notNull")
	@NotBlank(message = "ingresoEgreso.descripcion.notBlank")
	@Size(max = 15, message = "ingresoEgreso.descripcion.size")
	private String descripcion;
	

	public IngresoEgreso() {
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "IngresoEgreso [id=" + id + ", monto=" + monto + ", tipo=" + tipo + ", descripcion=" + descripcion + "]";
	}	

}
