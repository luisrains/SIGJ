package py.com.sigj.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.RolPermisoDao;
import py.com.sigj.security.RolPermiso;

@Repository
@Scope("session")
public class RolPermisoDaoImpl extends DaoImpl<RolPermiso> implements RolPermisoDao {

	@Override
	public String getCamposFiltrables() {
		return null;
	}

	@Override
	public RolPermiso eliminarPorPermiso(Long id_rol, Long id_permiso) {
		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", "RolPermiso");
		Query query = null;
		// Usuario no envió ningún filtro

	
			
			sql = sql + " WHERE rol_id=?1 AND permiso_id=?2";
			
			query = entityManager.createQuery(sql);
			query.setParameter(1,id_rol);
			query.setParameter(2, id_permiso);
			RolPermiso rp = (RolPermiso) query.getSingleResult();
		return rp;
	}
	@Override
	public List<RolPermiso> eliminarPorRol(Long id_rol) {
		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", "RolPermiso");
		Query query = null;
		// Usuario no envió ningún filtro

	
			
			sql = sql + " WHERE rol_id=?1";
			
			query = entityManager.createQuery(sql);
			query.setParameter(1,id_rol);
			int aux = query.getMaxResults();
		List<RolPermiso> rp = query.getResultList();
		return rp;
	}
	

}
