package py.com.sigj.expediente.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

/**
 * Clase que registra todas las expediente_documentoes relacionadas a un expediente.
 * cronológicas
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "expediente_documento")
public class ExpedienteDocumento extends GenericEntity {
	private static final String SECUENCIA = "expediente_documento_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_documento_expediente_fk"))
	private Expediente expediente;
	
	@Column(name="fecha_presentacion")
	private Date fechaPresentacion;
	
//	@ManyToOne
//	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_tipodocumento_fk"))
//	private TipoDocumento tipoDocumento;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "expediente_documento_fk"))
	private Documento documento;
	

//	@Lob
//	@Basic(fetch = FetchType.LAZY, optional = true)
//	private byte[] documento;// documento
	
	@NotNull(message = "expediente_documento.titulo.notNull")
	@NotBlank(message = "expediente_documento.titulo.notBlank")
	@Size(max = 50, message = "expediente_documento.titulo.size")
	private String titulo;
	
	public ExpedienteDocumento() {
		super();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public Date getFechaPresentacion() {
		return fechaPresentacion;
	}

	public void setFechaPresentacion(Date fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "ExpedienteDocumento [id=" + id + ", expediente=" + expediente + ", fechaPresentacion="
				+ fechaPresentacion + ", documento=" + documento + ", titulo=" + titulo + "]";
	}
	
	

//	public byte[] getDocumento() {
//		return documento;
//	}
//
//	public void setDocumento(byte[] documento) {
//		this.documento = documento;
//	}
//
//	public TipoDocumento getTipoDocumento() {
//		return tipoDocumento;
//	}
//
//	public void setTipoDocumento(TipoDocumento tipoDocumento) {
//		this.tipoDocumento = tipoDocumento;
//	}
//
//	@Override
//	public String toString() {
//		return "ExpedienteDocumento [id=" + id + ", expediente=" + expediente + ", fechaPresentacion="
//				+ fechaPresentacion + ", tipoDocumento=" + tipoDocumento + ", titulo=" + titulo + "]";
//	}

		
	
}
