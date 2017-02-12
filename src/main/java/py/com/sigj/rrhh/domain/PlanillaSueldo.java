package py.com.sigj.rrhh.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import py.com.sigj.main.GenericEntity;

@Entity
@Table(name = "planilla_sueldo")
public class PlanillaSueldo extends GenericEntity {
	private static final String SECUENCIA = "planillaSueldo_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "planillaSalario.mes.notNull")
	private String mes;

	@NotNull(message = "planillaSalario.anho.notNull")
	private String anho;

	public PlanillaSueldo() {
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

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnho() {
		return anho;
	}

	public void setAnho(String anho) {
		this.anho = anho;
	}

	@Override
	public String toString() {
		return "PlanillaSueldo [id=" + id + ", mes=" + mes + ", anho=" + anho + "]";
	}

}
