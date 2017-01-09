package py.com.sigj.gastos.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.dao.FacturaDetalleDao;
import py.com.sigj.gastos.domain.FacturaDetalle;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("session")
@RequestMapping("caja")
public class FacturaDetalleListController extends ListController<FacturaDetalle> {

	@Autowired
	private FacturaDetalleDao facturaDetalleDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "facturaCabecera", "servicio" };
	}

	@Override
	public Dao<FacturaDetalle> getDao() {
		return facturaDetalleDao;
	}

}
