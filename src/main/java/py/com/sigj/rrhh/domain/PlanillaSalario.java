package py.com.sigj.rrhh.domain;

import java.util.Date;

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

@Entity
@Table(name="planilla_salario", uniqueConstraints = { @UniqueConstraint(name = "planilla_salario_codigo_uk", columnNames = { "codigo" }) })
public class PlanillaSalario extends GenericEntity {
	private static final String SECUENCIA = "planillaSalario_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "planillaSalario.codigo.notNull")
	@NotBlank(message = "planillaSalario.codigo.notBlank")
	@Size(max = 20, message = "planillaSalario.codigo.size")
	private String codigo;

	@NotNull(message = "planillaSalario.fecha.notNull")
	private Date fecha;

	public PlanillaSalario() {
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "PlanillaSalario [id=" + id + ", codigo=" + codigo + ", fecha=" + fecha + "]";
	}

}
