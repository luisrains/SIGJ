package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.ProcesoDao;
import py.com.sigj.expediente.domain.Proceso;

@Controller
@Scope("session")
@RequestMapping("proceso")
public class ProcesoListController extends ListController<Proceso> {

	@Autowired
	private ProcesoDao procesoDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "codigo", "descripcion" };
	}

	@Override
	public Dao<Proceso> getDao() {
		return procesoDao;
	}

}
