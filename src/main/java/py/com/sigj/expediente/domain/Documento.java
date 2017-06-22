package py.com.sigj.expediente.domain;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "documento_tipodocumento_fk"))
	private TipoDocumento tipoDocumento;
	
	
	
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

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Override
	public String toString() {
		return "Documento [id=" + id + ", tipoDocumento=" + tipoDocumento + ", documento=" + Arrays.toString(documento)
				+ "]";
	}

	

	

}
