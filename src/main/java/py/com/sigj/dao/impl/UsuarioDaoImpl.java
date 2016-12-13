package py.com.sigj.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.com.sigj.dao.UsuarioDao;
import py.com.sigj.domain.Usuario;
import py.com.sigj.util.Util;

@Repository
@Scope("session")
public class UsuarioDaoImpl extends DaoImpl<Usuario> implements UsuarioDao {

	@Override
	public String getCamposFiltrables() {
		// TODO Auto-generated method stub
		return "nombre||apellido||codigo";
	}

	@Transactional
	@Override
	public void create(Usuario usuario) {
		String passMD5 = Util.md5(usuario.getPassword());
		usuario.setPassword(passMD5);
		super.create(usuario);

	}

	@Transactional
	@Override
	public void edit(Usuario usuario) {
		Usuario oldUsurario = find(usuario.getId());
		usuario.setPassword(oldUsurario.getPassword());
		super.edit(usuario);

	}

	@Override
	public Usuario buscar(String codigo) {

		String sql = "SELECT object(U) FROM Usuario AS U WHERE codigo = ?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, codigo);
		// query.setParameter(2, password);

		try {
			Usuario usuario = (Usuario) query.getSingleResult();
			logger.info("Se encontro el usuario {}'", codigo);
			return usuario;
		} catch (NoResultException e) {
			logger.info("No se encontro el usuario {}", codigo);
			return null;
		}

	}

}
