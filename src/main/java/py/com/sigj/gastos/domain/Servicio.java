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
 * Clase que registra los tipos de servicios, los cuales pueden ser: consultas,
 * gestiones varias.
 * 
 * @author ariquelme
 *
 */

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "servicio_codigo_uk", columnNames = { "codigo" }) })
public class Servicio extends GenericEntity {
	private static final String SECUENCIA = "servicio_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "servicio.codigo.notNull")
	@NotBlank(message = "servicio.codigo.notBlank")
	@Size(max = 5, message = "servicio.codigo.size")
	private String codigo;

	@NotNull(message = "servicio.tipoServicio.notNull")
	@NotBlank(message = "servicio.tipoServicio.notBlank")
	@Size(max = 100, message = "servicio.tipoServicio.size")
	private String tipoServicio;

	@NotNull(message = "servicio.costo.notNull")
	private String costo;

	public Servicio() {
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

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", codigo=" + codigo + ", tipoServicio=" + tipoServicio + ", costo=" + costo
				+ "]";
	}

	
	

}
