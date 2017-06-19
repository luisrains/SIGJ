package py.com.sigj.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.RolDao;
import py.com.sigj.security.Rol;
import py.com.sigj.security.Usuario;

@Repository
@Scope("session")
public class RolDaoImpl extends DaoImpl<Rol> implements RolDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||descripcion";
	}

	@Override
	public Rol buscarRol(String codigo) {
		
		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", "Rol");
		Query query = null;
		// Usuario no envió ningún filtro

	
			
			sql = sql + " WHERE codigo=?1";
			
			query = entityManager.createQuery(sql);
			query.setParameter(1,codigo);
			int aux = query.getMaxResults();
		Rol rp = (Rol) query.getSingleResult();
		return rp;
	}

	@Override
	public List<Rol> ListByUser(Usuario user) {
		if (user == null) {
			return new ArrayList<>();
		}
		logger.info("Obteniendo roles del usuario: {}", user);
		List<Rol> listRol = new ArrayList<>();
		/*
		 * String sql = "SELECT object(Permiso) " + "FROM Permiso AS Permiso " +
		 * "WHERE id IN (SELECT permiso_id FROM RolPermiso WHERE rol_id = ?1)";
		 */
		String sql = "SELECT object(Rol) " + "FROM Rol AS Rol WHERE rol_id = ?1";

		Query query = null;
		query = entityManager.createQuery(sql);
		query.setParameter(1, user.getRol().getId());

		@SuppressWarnings("unchecked")
		List<Rol> rolList = query.getResultList();
		for (Rol rol : rolList) {
			listRol.add(rol);
		}

		logger.info("Cantidad de roles obtenidos: {}", listRol.size());
		return listRol;
	}

}
