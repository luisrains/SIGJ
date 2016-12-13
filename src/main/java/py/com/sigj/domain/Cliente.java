package py.com.owl.owlapp.domain;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "cliente_codigo_uk", columnNames = { "codigo" }) })
public class Cliente extends GenericEntity {

	private static final String SECUENCIA = "client_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "cliente.codigo.notNull")
	@NotBlank(message = "cliente.codigo.notBlank")
	@Size(max = 5, message = "cliente.codigo.size")
	private String codigo;

	@NotNull(message = "cliente.razon.notNull")
	@NotBlank(message = "cliente.razon.notBlank")
	@Size(max = 100, message = "cliente.razon.size")
	private String razonSocial;

	@Size(max = 100, message = "cliente.ruc.size")
	private String ruc;

	// tabla dependencia , tabla que depende y fk
	@ManyToOne
	@NotNull(message = "cliente.tipoCliente.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "cliente_tipocliente_fk"))
	private TipoCliente tipoCliente;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	public Cliente(Long id, String codigo, String razonSocial, String ruc, TipoCliente tipoCliente) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.tipoCliente = tipoCliente;
	}

	public Cliente() {

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getStr() {
		return codigo + " - " + razonSocial;

	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", codigo=" + codigo + ", razonSocial=" + razonSocial + ", ruc=" + ruc
				+ ", tipoCliente=" + tipoCliente + "]";
	}

}