package py.com.sigj.gastos.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.gastos.dao.ServicioDao;
import py.com.sigj.gastos.domain.Servicio;

/**
 *
 * @author ariquelme
 *
 */

@Repository
@Scope("session") // Crea una nueva instancia para cada sesion.
public class ServicioDaoImpl extends DaoImpl<Servicio> implements ServicioDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||tipoServicio";
	}
}
