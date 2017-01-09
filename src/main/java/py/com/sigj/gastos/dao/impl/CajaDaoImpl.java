package py.com.sigj.gastos.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.gastos.dao.CajaDao;
import py.com.sigj.gastos.domain.Caja;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class CajaDaoImpl extends DaoImpl<Caja> implements CajaDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||monto||fecha";
	}
}
