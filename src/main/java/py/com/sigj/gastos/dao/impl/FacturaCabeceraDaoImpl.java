package py.com.sigj.gastos.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.gastos.dao.FacturaCabeceraDao;
import py.com.sigj.gastos.domain.FacturaCabecera;

/**
 *
 * @author ariquelme
 *
 */

@Repository
@Scope("session") // Crea una nueva instancia para cada sesion.
public class FacturaCabeceraDaoImpl extends DaoImpl<FacturaCabecera> implements FacturaCabeceraDao {

	@Override
	public String getCamposFiltrables() {
		return null;
	}
}
