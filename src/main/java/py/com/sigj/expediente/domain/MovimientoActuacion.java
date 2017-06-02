package py.com.sigj.expediente.domain;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import py.com.sigj.main.GenericEntity;

/**
 * Clase que registra todas las movimiento_actuaciones relacionadas a un expediente.
 * cronológicas
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "movimiento_actuacion")
public class MovimientoActuacion extends GenericEntity {
	private static final String SECUENCIA = "movimiento_movimiento_actuacion_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "movimiento_actuacion.observacion.notNull")
	@NotBlank(message = "movimiento_actuacion.observacion.notBlank")
	@Size(max = 100, message = "movimiento_actuacion.observacion.size")
	private String observacion;
	
	@Column
	private Date fechaPresentacion;
	
	@Temporal(TemporalType.DATE)
	private Date fechaVencimiento;

	@ManyToOne
	@NotNull(message = "movimiento_actuacion.tipo_actuacion.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "movimiento_actuacion_tipo_actuacion_fk"))
	private TipoActuacion tipoActuacion;

	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "movimiento_actuacion_expediente_fk"))
	private Expediente expediente;
	
	@JsonIgnore
	@Lob
	@Basic(fetch = FetchType.LAZY, optional = true)
	private byte[] documento;// documento

	
	public MovimientoActuacion() {
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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public Date getFechaPresentacion() {
		return fechaPresentacion;
	}

	public void setFechaPresentacion(Date fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public TipoActuacion getTipoActuacion() {
		return tipoActuacion;
	}

	public void setTipoActuacion(TipoActuacion tipo_actuacion) {
		this.tipoActuacion = tipo_actuacion;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "MovimientoActuacion [id=" + id + ", observacion=" + observacion + ", fechaPresentacion="
				+ fechaPresentacion + ", fechaVencimiento=" + fechaVencimiento + ", tipoActuacion=" + tipoActuacion
				+ ", expediente=" + expediente + ", documento=" + Arrays.toString(documento) + "]";
	}

}
