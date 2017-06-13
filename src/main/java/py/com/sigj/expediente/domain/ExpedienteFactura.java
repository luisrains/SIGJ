package py.com.sigj.expediente.domain;

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

import py.com.sigj.gastos.domain.FacturaCabecera;
import py.com.sigj.main.GenericEntity;

/**
 * Clase intermedia entre el expediente y el o los cliente asociados.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "expediente_factura")
public class ExpedienteFactura extends GenericEntity {
	private static final String SECUENCIA = "expedienteFactura_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "expedienteFactura.factura.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expedienteFactura_factura_fk"))
	private FacturaCabecera factura;

	@ManyToOne
	@NotNull(message = "expedienteFactura.expediente.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "expedienteFactura_expediente_fk"))
	private Expediente expediente;

	public ExpedienteFactura() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	

	public FacturaCabecera getFactura() {
		return factura;
	}

	public void setFactura(FacturaCabecera factura) {
		this.factura = factura;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	@Override
	public String toString() {
		return "ExpedienteFactura [id=" + id + ", factura=" + factura + ", expediente=" + expediente + "]";
	}

	

}
