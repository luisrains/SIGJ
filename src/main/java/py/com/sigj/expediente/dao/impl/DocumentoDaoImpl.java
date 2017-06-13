package py.com.sigj.expediente.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.DocumentoDao;
import py.com.sigj.expediente.domain.Documento;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class DocumentoDaoImpl extends DaoImpl<Documento> implements DocumentoDao {

	@Override
	public String getCamposFiltrables() {
		return "descripcion||juez";
	}

	@Override
	public Documento find(Long id) {
		logger.info("Buscando registro con id: {}", id);
		Documento d = entityManager.find(getEntityClass(), id);
		return d;

	}

}
