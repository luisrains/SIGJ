package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.ModeloHojaDao;
import py.com.sigj.expediente.domain.ModeloHoja;

@Controller
@Scope("session")
@RequestMapping("modelo_hoja")
public class ModeloHojaListController extends ListController<ModeloHoja> {

	@Autowired
	private ModeloHojaDao modeloHojaDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "descripcion" };
	}

	@Override
	public Dao<ModeloHoja> getDao() {
		return modeloHojaDao;
	}

}
