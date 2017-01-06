package py.com.sigj.gastos.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import py.com.sigj.main.GenericEntity;

@Entity
@Table(name = "factura_detalle", uniqueConstraints = {
		@UniqueConstraint(name = "factura_detalle_uk", columnNames = { "facturacabecera_id", "servicio_id" }) })
public class FacturaDetalle extends GenericEntity {
	private static final String SECUENCIA = "facturaDetalle_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "facturaDetalle.facturaCabecera.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "facturaDetalle_facturaCabecera_fk"))
	private FacturaCabecera facturaCabecera;

	@ManyToOne
	@NotNull(message = "facturaDetalle.servicio.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "facturaDetalle_servicio_fk"))
	private Servicio servicio;

	public FacturaDetalle() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public FacturaCabecera getFacturaCabecera() {
		return facturaCabecera;
	}

	public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
		this.facturaCabecera = facturaCabecera;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}
