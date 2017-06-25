package py.com.sigj.expediente.domain;

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
 * Clase en el que se registrarán los tipos de documentos que existen en el poder.
 * judicial Ej: Civil y Comercial, Justicia Letrada,Laboral,Penal.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "tipo_documento",uniqueConstraints = { @UniqueConstraint(name = "tipo_documento_codigo_uk", columnNames = { "codigo" }) })
public class TipoDocumento extends GenericEntity {
	private static final String SECUENCIA = "tipo_documento_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "tipo_documento.codigo.notNull")
	@NotBlank(message = "tipo_documento.codigo.notBlank")
	@Size(max = 5, message = "tipo_documento.codigo.size")
	private String codigo;

	@NotNull(message = "tipo_documento.descripcion.notNull")
	@NotBlank(message = "tipo_documento.descripcion.notBlank")
	@Size(max = 20, message = "tipo_documento.descripcion.size")
	private String descripcion;



	public TipoDocumento() {

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoDocumento [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

	
	

}
