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
@Table(name = "cliente_factura")
public class ClienteFactura extends GenericEntity {
	private static final String SECUENCIA = "clienteFactura_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "clienteFactura.factura.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "clienteFactura_factura_fk"))
	private FacturaCabecera factura;

	@ManyToOne
	@NotNull(message = "clienteFactura.cliente.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "clienteFactura_cliente_fk"))
	private Cliente cliente;

	public ClienteFactura() {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "ClienteFactura [id=" + id + ", factura=" + factura + ", cliente=" + cliente + "]";
	}

}
