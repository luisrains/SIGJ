package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.DespachoDao;
import py.com.sigj.expediente.domain.Despacho;

@Controller
@Scope("session")
@RequestMapping("despacho")
public class DespachoListController extends ListController<Despacho> {

	@Autowired
	private DespachoDao despachoDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "descripcion", "juez", "materia.descripcion" };
	}

	@Override
	public Dao<Despacho> getDao() {
		return despachoDao;
	}

}
