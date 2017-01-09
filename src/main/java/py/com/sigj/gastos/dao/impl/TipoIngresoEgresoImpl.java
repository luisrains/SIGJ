package py.com.sigj.gastos.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.gastos.dao.TipoIngresoEgresoDao;
import py.com.sigj.gastos.domain.TipoIngresoEgreso;

/**
 *
 * @author ariquelme
 *
 */

@Repository
@Scope("session") // Crea una nueva instancia para cada sesion.
public class TipoIngresoEgresoImpl extends DaoImpl<TipoIngresoEgreso> implements TipoIngresoEgresoDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||descripcion";
	}
}
