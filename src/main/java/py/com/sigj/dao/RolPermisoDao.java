package py.com.sigj.dao;


import java.util.List;

import py.com.sigj.security.RolPermiso;

public interface RolPermisoDao extends Dao<RolPermiso> {

	public RolPermiso eliminarPorPermiso(Long id_rol, Long id_permiso);
	public List<RolPermiso> eliminarPorRol(Long id_rol);
}
