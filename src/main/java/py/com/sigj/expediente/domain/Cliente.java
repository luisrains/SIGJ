package py.com.sigj.expediente.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

/**
 * Clase que registra datos de los clientes, de acuerdo a una persona que será
 * importada.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "cliente_persona_uk", columnNames = { "persona_id" }) })
public class Cliente extends GenericEntity {

	private static final String SECUENCIA = "cliente_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "cliente.domicilioLaboral.notNull")
	@NotBlank(message = "cliente.domicilioLaboral.notBlank")
	@Size(max = 1000, message = "cliente.domicilioLaboral.size")
	private String domicilioLaboral;

	@NotNull(message = "cliente.domicilioProcesal.notNull")
	@NotBlank(message = "cliente.domicilioProcesal.notBlank")
	@Size(max = 1000, message = "cliente.domicilioProcesal.size")
	private String domicilioProcesal;

	@NotNull(message = "cliente.domicilioActual.notNull")
	@NotBlank(message = "cliente.domicilioActual.notBlank")
	@Size(max = 1000, message = "cliente.domicilioActual.size")
	private String domicilioActual;

	// tabla dependencia , tabla que depende y fk
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "cliente_persona_fk"))
	private Persona persona;

	

	public Cliente() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getDomicilioLaboral() {
		return domicilioLaboral;
	}

	public void setDomicilioLaboral(String domicilioLaboral) {
		this.domicilioLaboral = domicilioLaboral;
	}

	public String getDomicilioProcesal() {
		return domicilioProcesal;
	}

	public void setDomicilioProcesal(String domicilioProcesal) {
		this.domicilioProcesal = domicilioProcesal;
	}

	public String getDomicilioActual() {
		return domicilioActual;
	}

	public void setDomicilioActual(String domicilioActual) {
		this.domicilioActual = domicilioActual;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", domicilioLaboral=" + domicilioLaboral + ", domicilioProcesal="
				+ domicilioProcesal + ", domicilioActual=" + domicilioActual + ", persona=" + persona + "]";
	}

	

	

}