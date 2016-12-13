package py.com.owl.owlapp.dao;

import java.util.List;

import py.com.owl.owlapp.domain.Permiso;
import py.com.owl.owlapp.domain.Rol;

public interface PermisoDao extends Dao<Permiso> {
	List<Permiso> ListByRol(Rol rol);
}
