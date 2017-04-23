package py.com.sigj.expediente.domain;

import java.util.Set;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import py.com.sigj.main.GenericEntity;

/**
 * Clase en el que se registrarán los tipos de materias que existen en el poder.
 * judicial Ej: Civil y Comercial, Justicia Letrada,Laboral,Penal.
 *
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "materia_codigo_uk", columnNames = { "codigo" }) })
public class Materia extends GenericEntity {
	private static final String SECUENCIA = "materia_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "materia.codigo.notNull")
	@NotBlank(message = "materia.codigo.notBlank")
	@Size(max = 5, message = "materia.codigo.size")
	private String codigo;

	@NotNull(message = "materia.descripcion.notNull")
	@NotBlank(message = "materia.descripcion.notBlank")
	@Size(max = 20, message = "materia.descripcion.size")
	private String descripcion;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinTable(name = "materia_proceso", joinColumns = @JoinColumn(name = "materia_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "proceso_id", referencedColumnName = "id"))
	private Set<Proceso> listaProceso;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinTable(name = "materia_despacho", joinColumns = @JoinColumn(name = "materia_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "despacho_id", referencedColumnName = "id"))
	private Set<Despacho> listaDespacho;

	public Materia() {

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

	public Set<Proceso> getListaProceso() {
		return listaProceso;
	}

	public void setListaProceso(Set<Proceso> listaProceso) {
		this.listaProceso = listaProceso;
	}

	public Set<Despacho> getListaDespacho() {
		return listaDespacho;
	}

	public void setListaDespacho(Set<Despacho> listaDespacho) {
		this.listaDespacho = listaDespacho;
	}

	// falta la lista de tipo demanda en proceso, y la lista de expedientes en
	// despacho
	@Override
	public String toString() {
		String result = String.format("Materia[id=%d, codigo='%s', descripcion='%s',", id, codigo, descripcion);
		result += String.format("Proceso[");
		for (Proceso proceso : listaProceso) {
			result += String.format("{id=%d, codigo='%s', descripcion='%s'}", proceso.getId(), proceso.getCodigo(),
					proceso.getDescripcion());
			break;
		}
		result += String.format("],");
		result += String.format("Despacho[");
		for (Despacho despacho : listaDespacho) {
			result += String.format("{id=%d, descripcion='%s', juez='%s'}", despacho.getId(), despacho.getDescripcion(),
					despacho.getJuez());
			break;
		}
		result += String.format("]");
		return result + "]";
	}

}
