package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.TipoDemandaDao;
import py.com.sigj.expediente.domain.TipoDemanda;

@Controller
@Scope("session")
@RequestMapping("proceso_tipo_demanda")
public class ProcesoTipoDemandaListController extends ListController<TipoDemanda> {

	@Autowired
	private TipoDemandaDao tipoDemandaDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "proceso.descripcion", "tipoDemanda.descripcion" };
	}

	@Override
	public Dao<TipoDemanda> getDao() {
		return tipoDemandaDao;
	}

}
