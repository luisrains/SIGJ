package py.com.sigj.expediente.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.ExpedienteDocumentoDao;
import py.com.sigj.expediente.dao.MovimientoActuacionDao;
import py.com.sigj.expediente.domain.ExpedienteDocumento;
import py.com.sigj.expediente.domain.MovimientoActuacion;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class ExpedienteDocumentoDaoImpl extends DaoImpl<ExpedienteDocumento> implements ExpedienteDocumentoDao {

	@Override
	public String getCamposFiltrables() {
		return "descripcion";
	}
}
