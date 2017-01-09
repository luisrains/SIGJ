package py.com.sigj.gastos.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.gastos.dao.FacturaDetalleDao;
import py.com.sigj.gastos.domain.FacturaDetalle;

/**
 *
 * @author ariquelme
 *
 */

@Repository
@Scope("session") // Crea una nueva instancia para cada sesion.
public class FacturaDetalleDaoImpl extends DaoImpl<FacturaDetalle> implements FacturaDetalleDao {

	@Override
	public String getCamposFiltrables() {
		return "facturaCabecera||servicio";
	}
}
