package py.com.sigj.expediente.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.ProcesoDao;
import py.com.sigj.expediente.domain.Proceso;
import py.com.sigj.expediente.domain.ProcesoTipoDemanda;
import py.com.sigj.expediente.domain.TipoDemanda;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class ProcesoDaoImpl extends DaoImpl<Proceso> implements ProcesoDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||descripcion";
	}

	@Override
	public List<TipoDemanda> getListaTipoDemanda(Long id) throws Exception {
		logger.info("Obteniendo lista de tipo demanda");
		try {

			String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
			sql = sql.replace("#ENTITY#", "ProcesoTipoDemanda");
			Query query = null;
			// Usuario no envió ningún filtro

			sql = sql + " WHERE proceso_id = ?1";
			query = entityManager.createQuery(sql);
			query.setParameter(1, id);

			List<ProcesoTipoDemanda> list = query.getResultList();
			List<TipoDemanda> tipoD = new ArrayList<TipoDemanda>();
			for (ProcesoTipoDemanda procesoTipoDemanda : list) {
				tipoD.add(procesoTipoDemanda.getTipoDemanda());
			}
			logger.info("Proceso Tipo Demandas: {}", list);
			return tipoD;
		} catch (Exception e) {
			logger.info("error {}", e);
			throw new Exception("Ocurrió un error");
		}
	}

}
