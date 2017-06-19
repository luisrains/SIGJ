package py.com.sigj.dao;

import java.util.List;

import py.com.sigj.security.Rol;
import py.com.sigj.security.Usuario;

public interface RolDao extends Dao<Rol> {
	public List<Rol> ListByUser(Usuario user);
	public Rol buscarRol(String codigo);
}
