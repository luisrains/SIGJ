package py.com.sigj.expediente.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

/**
 * Clase que registra los procesos que existen de acuerdo al tipo de materia que
 * se registran en el sistema.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "proceso_codigo_uk", columnNames = { "codigo" }) })
public class Proceso extends GenericEntity {
	private static final String SECUENCIA = "proceso_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "proceso.codigo.notNull")
	@NotBlank(message = "proceso.codigo.notBlank")
	@Size(max = 5, message = "proceso.codigo.size")
	private String codigo;

	@NotNull(message = "proceso.descripcion.notNull")
	@NotBlank(message = "proceso.descripcion.notBlank")
	@Size(max = 20, message = "proceso.descripcion.size")
	private String descripcion;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH })
	@JoinTable(name = "proceso_tipo_demanda", joinColumns = @JoinColumn(name = "proceso_id"), inverseJoinColumns = @JoinColumn(name = "tipodemanda_id"))
	private List<TipoDemanda> listTipoDemanda;

	public Proceso() {

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<TipoDemanda> getListTipoDemanda() {
		return listTipoDemanda;
	}

	public void setListTipoDemanda(List<TipoDemanda> tipoDemanda) {
		this.listTipoDemanda = tipoDemanda;
	}

	@Override
	public String toString() {
		return "Proceso [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", tipoDemanda="
				+ listTipoDemanda + "]";
	}

	// @Override
	// public List<TipoDemanda> getListaObject() {
	// return getTipoDemanda();
	// }
	//
	// @Override
	// public <TipoDemanda> void setListaObject(List<TipoDemanda> obj) {
	// setTipoDemanda((List<py.com.sigj.expediente.domain.TipoDemanda>) obj);
	//
	// }

}
