package py.com.sigj.domain;

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

/*
 * Para el sabado, deben hacer una vista para registrar
 * Iva(id, codigo, porcentaje, baseImpositiva) -> (0, 'Iva 10', 10, 11).
 * Porcentaje y baseImpositiva son Float.
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "iva_codigo_uk", columnNames = { "codigo" }) })
public class Iva extends GenericEntity {

	private static final String SECUENCIA = "iva_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "iva.codigo.notNull")
	@NotBlank(message = "iva.codigo.notBlank")
	@Size(max = 5, message = "iva.codigo.size")
	private String codigo;

	@NotNull(message = "iva.porcentaje.notNull")
	private Float porcentaje;

	private Float BaseImpositiva;

	public Iva() {

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

	public Float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Float getBaseImpositiva() {
		return BaseImpositiva;
	}

	public void setBaseImpositiva(Float baseImpositiva) {
		BaseImpositiva = baseImpositiva;
	}

	@Override
	public String toString() {
		return "Iva [id=" + id + ", codigo=" + codigo + ", porcentaje=" + porcentaje + ", BaseImpositiva="
				+ BaseImpositiva + "]";
	}

}