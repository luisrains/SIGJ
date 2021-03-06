package py.com.sigj.gastos.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.gastos.dao.IngresoEgresoDao;
import py.com.sigj.gastos.domain.IngresoEgreso;

/**
 *
 * @author ariquelme
 *
 */

@Repository
@Scope("session") // Crea una nueva instancia para cada sesion.
public class IngresoEgresoImpl extends DaoImpl<IngresoEgreso> implements IngresoEgresoDao {

	@Override
	public String getCamposFiltrables() {
		return "descripcion";
	}
}
