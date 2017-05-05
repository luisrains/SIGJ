package py.com.sigj.dao;


import py.com.sigj.security.RolPermiso;

public interface RolPermisoDao extends Dao<RolPermiso> {

	public RolPermiso eliminarPorPermiso(Long id_rol, Long id_permiso);
	public RolPermiso eliminarPorRol(Long id_rol);
}
