package py.com.sigj.expediente.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

/**
 * Clase que registra el documento en formato pdf, jpg o png.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "documento")
public class Documento extends GenericEntity {
	private static final String SECUENCIA = "documento_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "documento.descripcion.notNull")
	@NotBlank(message = "documento.descripcion.notBlank")
	@Size(max = 60, message = "documento.descripcion.size")
	private String descripcion;

	@NotNull(message = "documento.linkPdf.notNull")
	@NotBlank(message = "documento.linkPdf.notBlank")
	@Size(max = 60, message = "documento.linkPdf.size")
	private String linkPdf;

	public Documento() {

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLinkPdf() {
		return linkPdf;
	}

	public void setLinkPdf(String linkPdf) {
		this.linkPdf = linkPdf;
	}

	@Override
	public String toString() {
		return "Documento [id=" + id + ", descripcion=" + descripcion + ", linkPdf=" + linkPdf + "]";
	}

}
