package py.com.sigj.gastos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(name = "tipo_ingreso_egreso", uniqueConstraints = {
		@UniqueConstraint(name = "tipoIngresoEgreso_codigo_uk", columnNames = { "codigo" }) })
public class TipoIngresoEgreso extends GenericEntity {
	private static final String SECUENCIA = "tipoIngresoEgreso_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "tipoIngresoEgreso.codigo.notNull")
	@NotBlank(message = "tipoIngresoEgreso.codigo.notBlank")
	@Size(max = 5, message = "tipoIngresoEgreso.codigo.size")
	private String codigo;

	@NotNull(message = "tipoIngresoEgreso.descripcion.notNull")
	@NotBlank(message = "tipoIngresoEgreso.descripcion.notBlank")
	@Size(max = 15, message = "tipoIngresoEgreso.descripcion.size")
	private String descripcion;

	public TipoIngresoEgreso() {
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

	public String getdescripcion() {
		return descripcion;
	}

	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoIngresoEgreso [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

}
