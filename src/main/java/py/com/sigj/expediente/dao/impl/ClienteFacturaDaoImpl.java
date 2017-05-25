package py.com.sigj.expediente.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.ClienteFacturaDao;
import py.com.sigj.expediente.domain.ClienteFactura;


//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class ClienteFacturaDaoImpl extends DaoImpl<ClienteFactura> implements ClienteFacturaDao {

	@Override
	public String getCamposFiltrables() {
		return null;
	}
	
}
