package py.com.sigj.gastos.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.gastos.dao.CajaDao;
import py.com.sigj.gastos.domain.Caja;

/**
 *
 * @author ariquelme
 *
 */

@Repository
@Scope("session") // Crea una nueva instancia para cada sesion.
public class CajaDaoImpl extends DaoImpl<Caja> implements CajaDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||ingresoEgreso||descripcion||monto||fecha";
	}
}
