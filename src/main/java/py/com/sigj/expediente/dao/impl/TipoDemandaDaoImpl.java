package py.com.sigj.expediente.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.TipoDemandaDao;
import py.com.sigj.expediente.domain.TipoDemanda;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class TipoDemandaDaoImpl extends DaoImpl<TipoDemanda> implements TipoDemandaDao {

	@Override
	public String getCamposFiltrables() {
		return "descripcion";
	}

	@Override
	public TipoDemanda find(Long id) {
		logger.info("Buscando registro con id: {}", id);
		TipoDemanda td = entityManager.find(getEntityClass(), id);
		initializeCollection(td.getListExpediente());
		return td;

	}
}
