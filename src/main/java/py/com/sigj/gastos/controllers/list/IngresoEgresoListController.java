package py.com.sigj.gastos.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.dao.IngresoEgresoDao;
import py.com.sigj.gastos.domain.IngresoEgreso;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("session")
@RequestMapping("ingreso_egreso")
public class IngresoEgresoListController extends ListController<IngresoEgreso> {

	@Autowired
	private IngresoEgresoDao ingresoEgresoDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "caja", "tipoIngresoEgreso", "descripcion" };
	}

	@Override
	public Dao<IngresoEgreso> getDao() {
		return ingresoEgresoDao;
	}

}
