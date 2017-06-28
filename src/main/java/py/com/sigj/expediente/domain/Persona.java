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

/**
 * Clase que registra todos los datos de todas las personas tengan relacion con
 * el sistema.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "persona_cedula_ruc_uk", columnNames = { "cedula_ruc" }) })
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
	@Size(max = 10, message = "persona.cedula.size")
	private String cedula_ruc;

	@NotNull(message = "persona.nombre.notNull")
	@NotBlank(message = "persona.nombre.notBlank")
	@Size(max = 60, message = "persona.nombre.size")
	private String nombre_razonSocial;

	@Size(max = 60, message = "persona.apellido.size")
	private String apellido;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	
	private int edad;

	@Size(max = 15, message = "persona.estadoCivil.size")
	private String estadoCivil;

	private String sexo;

	@Size(max = 100, message = "persona.correo_electronico.size")
	private String correoElectronico;

	@Size(max = 15, message = "persona.telefono.size")
	private String telefono;

	@NotNull(message = "persona.tipo_persona.notNull")
	private char tipoPersona;

	@NotNull(message = "persona.disponible.notNull") // Si o No
	private String disponible;
	
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	
	
	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", cedula_ruc=" + cedula_ruc + ", nombre_razonSocial=" + nombre_razonSocial
				+ ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad
				+ ", estadoCivil=" + estadoCivil + ", sexo=" + sexo + ", correoElectronico=" + correoElectronico
				+ ", telefono=" + telefono + ", tipoPersona=" + tipoPersona + ", disponible=" + disponible + "]";
	}

}
