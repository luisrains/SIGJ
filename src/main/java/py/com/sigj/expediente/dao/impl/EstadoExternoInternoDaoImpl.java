package py.com.sigj.expediente.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.EstadoExternoInternoDao;
import py.com.sigj.expediente.domain.EstadoExternoInterno;

@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class EstadoExternoInternoDaoImpl extends DaoImpl<EstadoExternoInterno> implements EstadoExternoInternoDao {

	@Override
	public String getCamposFiltrables() {

		return "codigo||descripcion||tipoEstado";
	}

}
