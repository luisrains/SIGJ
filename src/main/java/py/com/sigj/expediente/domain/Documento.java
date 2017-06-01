package py.com.sigj.expediente.domain;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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

	@Lob
	@Basic(fetch = FetchType.LAZY, optional = true)
	private byte[] documento;// documento

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

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Documento [id=" + id + ", documento=" + Arrays.toString(documento) + "]";
	}

	

}
