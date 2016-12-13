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

//convención para los constrains, nombreTabla + _ + nombreCampo +UK (unit)
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "persona_cedula_uk", columnNames = { "cedula" }) })
public class Persona extends GenericEntity {
	private static final String SECUENCIA = "persona_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	// convencion para el mensaje de not nul, para luego usar en la i18n
	// entidad.nombreCampo.nombredenotnull
	@NotNull(message = "persona.cedula.notNull")
	@NotBlank(message = "persona.cedula.notBlank")
	@Size(max = 18, message = "persona.cedula.size")
	private String cedula;

	@NotNull(message = "persona.nombre.notNull")
	@NotBlank(message = "persona.nombre.notBlank")
	@Size(max = 60, message = "persona.nombre.size")
	private String nombre;

	@NotNull(message = "persona.apellido.notNull")
	@NotBlank(message = "persona.apellido.notBlank")
	@Size(max = 60, message = "persona.apellido.size")
	private String apellido;

	@Size(max = 100, message = "persona.direccion.size")
	private String direccion;

	public Persona() {
	}

	public Persona(Long id, String cedula, String nombre, String apellido) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

}
