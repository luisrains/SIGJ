package py.com.sigj.domain;

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

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "rol_permiso_uk", columnNames = { "rol_id", "permiso_id" }) })
public class RolPermiso extends GenericEntity {
	private static final String SECUENCIA = "rolPermiso_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "rolPermiso.rol.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "rolPermiso_rol_fk"))
	private Rol rol;

	@ManyToOne
	@NotNull(message = "rolPermiso.permiso.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "rolPermiso_permiso_fk"))
	private Permiso permiso;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public RolPermiso() {

	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

}
