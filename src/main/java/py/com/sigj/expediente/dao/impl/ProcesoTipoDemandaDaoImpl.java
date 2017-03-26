package py.com.sigj.expediente.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.ProcesoTipoDemandaDao;
import py.com.sigj.expediente.domain.ProcesoTipoDemanda;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class ProcesoTipoDemandaDaoImpl extends DaoImpl<ProcesoTipoDemanda> implements ProcesoTipoDemandaDao {

	@Override
	public String getCamposFiltrables() {
		return "";
	}

	@Override
	public Long getListWhere(Long idProceso, Long idTipoDemanda) throws NoResultException {
		logger.info("Obteniendo id de ProcesoTipoDemanda ");
		try {

			String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
			sql = sql.replace("#ENTITY#", "ProcesoTipoDemanda");
			Query query = null;
			// Usuario no envió ningún filtro
			sql = sql + " WHERE proceso_id = ?1 AND tipodemanda_id  = ?2";
			query = entityManager.createQuery(sql);
			query.setParameter(1, idProceso);
			query.setParameter(2, idTipoDemanda);

			ProcesoTipoDemanda ptd = (ProcesoTipoDemanda) query.getSingleResult();
			logger.info("proceso tipo demanda resultante: {}", ptd);
			return ptd.getId();
		} catch (NoResultException e) {
			return null;
		}
	}
}
