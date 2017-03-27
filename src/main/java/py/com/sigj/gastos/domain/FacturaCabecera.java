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

/**
 *
 * @author ariquelme
 *
 */

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
	@NotNull(message = "facturaCabecera.fecha.notNull")
	private Date fecha;
	
	@NotNull(message = "facturaCabecera.ruc_ci.notNull")
	private String rucCi;
	
	@NotNull(message = "facturaCabecera.razon_social.notNull")
	private String razonSocial;
	
	@NotNull(message = "facturaCabecera.direccion.notNull")
	private String direccion;
	
	@NotNull(message = "facturaCabecera.timbrado.notNull")
	private int timbrado;

	@NotNull(message = "facturaCabecera.fecha_inicio_vigencia.notNull")
	private Date fechaInicioVigencia;
	
	@NotNull(message = "facturaCabecera.fecha_fin_vigencia.notNull")
	private Date fechaFinVigencia;
	
	@NotNull(message = "facturaCabecera.ruc.notNull")
	private String ruc;
	
	@NotNull(message = "facturaCabecera.nro_factura.notNull")
	private String nroFactura;
	
	
	@NotNull(message = "facturaCabecera.tipo_pago.notNull")
	
	private String tipoPago;
	
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

	public int getTimbrado() {
		return timbrado;
	}

	public void setTimbrado(int timbrado) {
		this.timbrado = timbrado;
	}

	public Date getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(Date fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public Date getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	public void setFechaFinVigencia(Date fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(String nroFactura) {
		this.nroFactura = nroFactura;
	}


	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getRucCi() {
		return rucCi;
	}

	public void setRucCi(String rucCi) {
		this.rucCi = rucCi;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "FacturaCabecera [id=" + id + ", cliente=" + cliente + ", caja=" + caja + ", abogado=" + abogado
				+ ", fecha=" + fecha + ", rucCi=" + rucCi + ", razonSocial=" + razonSocial + ", direccion=" + direccion
				+ ", timbrado=" + timbrado + ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaFinVigencia="
				+ fechaFinVigencia + ", ruc=" + ruc + ", nroFactura=" + nroFactura + ", tipoPago=" + tipoPago + "]";
	}

	

	

	
}
