package py.com.sigj.gastos.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import py.com.sigj.expediente.domain.Abogado;
import py.com.sigj.expediente.domain.Cliente;
import py.com.sigj.main.GenericEntity;

@Entity
@Table(name = "factura_cabecera")
public class FacturaCabecera extends GenericEntity {
	private static final String SECUENCIA = "facturaCabecera_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "facturaCabecera.cliente.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "facturaCabecera_cliente_fk"))
	private Cliente cliente;

	@ManyToOne
	@NotNull(message = "facturaCabecera.caja.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "facturaCabecera_caja_fk"))
	private Caja caja;

	@ManyToOne
	@NotNull(message = "facturaCabecera.abogado.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "facturaCabecera_abogado_fk"))
	private Abogado abogado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	public FacturaCabecera() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public Abogado getAbogado() {
		return abogado;
	}

	public void setAbogado(Abogado abogado) {
		this.abogado = abogado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "FacturaCabecera [id=" + id + ", cliente=" + cliente + ", caja=" + caja + ", abogado=" + abogado
				+ ", fecha=" + fecha + "]";
	}

}
