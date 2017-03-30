package py.com.sigj.gastos.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.dao.CajaDao;
import py.com.sigj.gastos.domain.Caja;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("session")
@RequestMapping("caja")
public class CajaListController extends ListController<Caja> {

	@Autowired
	private CajaDao cajaDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "codigo", "monto", "fecha" };
	}

	@Override
	public Dao<Caja> getDao() {
		return cajaDao;
	}

}
