package py.com.sigj.dao;

import java.util.List;

import py.com.sigj.domain.Permiso;
import py.com.sigj.domain.Rol;

public interface PermisoDao extends Dao<Permiso> {
	List<Permiso> ListByRol(Rol rol);
}
