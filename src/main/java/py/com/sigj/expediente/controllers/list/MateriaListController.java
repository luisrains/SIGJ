package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.domain.Materia;

@Controller
@Scope("session")
@RequestMapping("materia")
public class MateriaListController extends ListController<Materia> {

	@Autowired
	private MateriaDao materiaDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "codigo", "descripcion" };
	}

	@Override
	public Dao<Materia> getDao() {
		return materiaDao;
	}

}
