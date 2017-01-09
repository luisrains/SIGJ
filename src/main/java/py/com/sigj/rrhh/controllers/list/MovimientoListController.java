package py.com.sigj.rrhh.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.rrhh.dao.MovimientoDao;
import py.com.sigj.rrhh.domain.Movimiento;

@Controller
@Scope("session")
@RequestMapping("movimiento")
public class MovimientoListController extends ListController<Movimiento> {

	@Autowired
	private MovimientoDao movimientoDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "ingreso", "egreso", "fecha", "descripcion" };
	}

	@Override
	public Dao<Movimiento> getDao() {
		return movimientoDao;
	}

}
