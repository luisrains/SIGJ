package py.com.sigj.expediente.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

//convención para los constrains, nombreTabla + _ + nombreCampo +UK (unit)
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "persona_cedula_ruc_uk", columnNames = { "cedula_ruc" }) })
public class Persona extends GenericEntity {
	private static final String SECUENCIA = "personaFisica_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	// convencion para el mensaje de not nul, para luego usar en la i18n
	// entidad.nombreCampo.nombredenotnull
	@NotNull(message = "persona.cedula.notNull")
	@NotBlank(message = "persona.cedula.notBlank")
	@Size(max = 10, message = "persona.cedula.size")
	private String cedula_ruc;

	@NotNull(message = "persona.nombre.notNull")
	@NotBlank(message = "persona.nombre.notBlank")
	@Size(max = 60, message = "persona.nombre.size")
	private String nombre_razonSocial;

	@NotNull(message = "persona.apellido.notNull")
	@NotBlank(message = "persona.apellido.notBlank")
	@Size(max = 60, message = "persona.apellido.size")
	private String apellido;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@NotNull(message = "persona.edad.notNull")
	private int edad;

	@NotNull(message = "persona.sexo.notNull")
	@NotBlank(message = "persona.sexo.notBlank")
	@Size(max = 10, message = "persona.sexo.size")
	private String sexo;

	@NotNull(message = "persona.estadoCivil.notNull")
	@NotBlank(message = "persona.estadoCivil.notBlank")
	@Size(max = 15, message = "persona.estadoCivil.size")
	private String estadoCivil;

	@NotNull(message = "persona.estadoCivil.notNull")
	@NotBlank(message = "persona.estadoCivil.notBlank")
	@Size(max = 100, message = "persona.estadoCivil.size")
	private String ocupacion;

	@NotNull(message = "persona.estadoCivil.notNull")
	@NotBlank(message = "persona.estadoCivil.notBlank")
	@Size(max = 100, message = "persona.estadoCivil.size")
	private String correoElectronico;

	@NotNull(message = "persona.telefono.notNull")
	@NotBlank(message = "persona.telefono.notBlank")
	@Size(max = 15, message = "persona.telefono.size")
	private String telefono;

	@NotNull(message = "persona.cedula.notNull")
	private char tipoPersona;

	public Persona() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula_ruc() {
		return cedula_ruc;
	}

	public void setCedula_ruc(String cedula_ruc) {
		this.cedula_ruc = cedula_ruc;
	}

	public String getNombre_razonSocial() {
		return nombre_razonSocial;
	}

	public void setNombre_razonSocial(String nombre_razonSocial) {
		this.nombre_razonSocial = nombre_razonSocial;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public char getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(char tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

}
