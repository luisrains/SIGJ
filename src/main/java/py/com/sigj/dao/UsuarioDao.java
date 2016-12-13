package py.com.owl.owlapp.dao;

import py.com.owl.owlapp.domain.Usuario;

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
