package py.com.sigj.expediente.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

/**
 * Clase que registra la clasificación de demandas existentes.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "tipo_demanda")
public class TipoDemanda extends GenericEntity {
	private static final String SECUENCIA = "tipoDemanda_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "tipoDemanda.descripcion.notNull")
	@NotBlank(message = "tipoDemanda.descripcion.notBlank")
	@Size(max = 100, message = "tipoDemanda.descripcion.size")
	private String Descripcion;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinTable(name = "despacho_expediente", joinColumns = @JoinColumn(name = "despacho_id"), inverseJoinColumns = @JoinColumn(name = "expediente_id"))
	private List<Expediente> listExpediente;

	public TipoDemanda() {

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public List<Expediente> getListExpediente() {
		return listExpediente;
	}

	public void setListExpediente(List<Expediente> listExpediente) {
		this.listExpediente = listExpediente;
	}

	@Override
	public String toString() {
		return "TipoDemanda [id=" + id + ", Descripcion=" + Descripcion + ", listExpediente=" + listExpediente + "]";
	}

}
