package py.com.sigj.gastos.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.dao.FacturaCabeceraDao;
import py.com.sigj.gastos.domain.FacturaCabecera;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("session")
@RequestMapping("caja")
public class FacturaCabeceraListController extends ListController<FacturaCabecera> {

	@Autowired
	private FacturaCabeceraDao facturaCabeceraDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "cliente", "caja", "abogado", "fecha" };
	}

	@Override
	public Dao<FacturaCabecera> getDao() {
		return facturaCabeceraDao;
	}

}
