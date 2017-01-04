package py.com.sigj.dao;

import py.com.sigj.security.Usuario;

public interface UsuarioDao extends Dao<Usuario> {
	/**
	 * @param password
	 *            la contraseñade usuario sin encriptar
	 * @return null si no existe el usuario
	 * @return Usuario
	 *
	 */
	Usuario buscar(String codigo);
}
