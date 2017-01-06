package py.com.sigj.gastos.domain;

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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

@Entity
@Table(name = "ingreso_egreso")
public class IngresoEgreso extends GenericEntity {
	private static final String SECUENCIA = "ingresoEgreso_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "ingresoEgreso.caja.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "ingresoEgreso_cliente_fk"))
	private Caja caja;

	@ManyToOne
	@NotNull(message = "ingresoEgreso.tipoIngresoEgreso.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "ingresoEgreso_tipoIngresoEgreso_fk"))
	private TipoIngresoEgreso tipoIngresoEgreso;

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

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public TipoIngresoEgreso getTipoIngresoEgreso() {
		return tipoIngresoEgreso;
	}

	public void setTipoIngresoEgreso(TipoIngresoEgreso tipoIngresoEgreso) {
		this.tipoIngresoEgreso = tipoIngresoEgreso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "IngresoEgreso [id=" + id + ", caja=" + caja + ", tipoIngresoEgreso=" + tipoIngresoEgreso
				+ ", descripcion=" + descripcion + "]";
	}

}
