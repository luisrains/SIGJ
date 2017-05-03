package py.com.sigj.security;

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

import py.com.sigj.expediente.domain.TipoDemanda;
import py.com.sigj.main.GenericEntity;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "rol_codigo_uk", columnNames = { "codigo" }) })
public class Rol extends GenericEntity {
	private static final String SECUENCIA = "rol_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "rol.codigo.notNull")
	@NotBlank(message = "rol.codigo.notBlank")
	@Size(max = 20, message = "rol.codigo.size")
	private String codigo;

	@NotNull(message = "rol.descripcion.notNull")
	@NotBlank(message = "rol.descripcion.notBlank")
	@Size(max = 100, message = "rol.descripcion.size")
	private String descripcion;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH })
	@JoinTable(name = "rol_permiso", joinColumns = @JoinColumn(name = "rol_id"), inverseJoinColumns = @JoinColumn(name = "permiso_id"))
	private List<Permiso> listPermiso;

	public Rol() {
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

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	
	
	public List<Permiso> getListPermiso() {
		return listPermiso;
	}

	public void setListPermiso(List<Permiso> listPermiso) {
		this.listPermiso = listPermiso;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", listPermiso=" + listPermiso
				+ "]";
	}

	
}
