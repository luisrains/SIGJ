package py.com.sigj.gastos.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.dao.ServicioDao;
import py.com.sigj.gastos.domain.Servicio;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("session")
@RequestMapping("servicio")
public class ServicioListController extends ListController<Servicio> {

	@Autowired
	private ServicioDao servicioDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "codigo", "tipoServicio" };
	}

	@Override
	public Dao<Servicio> getDao() {
		return servicioDao;
	}

}
