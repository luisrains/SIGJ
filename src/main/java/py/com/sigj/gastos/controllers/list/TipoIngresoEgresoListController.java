package py.com.sigj.gastos.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.dao.TipoIngresoEgresoDao;
import py.com.sigj.gastos.domain.TipoIngresoEgreso;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("session")
@RequestMapping("tipo_ingreso_egreso")
public class TipoIngresoEgresoListController extends ListController<TipoIngresoEgreso> {

	@Autowired
	private TipoIngresoEgresoDao tipoIngresoEgresoDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "codigo", "descripcion" };
	}

	@Override
	public Dao<TipoIngresoEgreso> getDao() {
		return tipoIngresoEgresoDao;
	}

}
