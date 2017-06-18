package py.com.sigj.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.RolDao;
import py.com.sigj.security.Rol;
import py.com.sigj.security.RolPermiso;

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

}
