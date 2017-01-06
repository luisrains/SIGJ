package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.TipoAbogadoDao;
import py.com.sigj.expediente.domain.TipoAbogado;

@Controller
@Scope("session")
@RequestMapping("tipo_abogado")
public class TipoAbogadoListController extends ListController<TipoAbogado> {

	@Autowired
	private TipoAbogadoDao tipoAbogadoDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "codigo", "descripcion" };
	}

	@Override
	public Dao<TipoAbogado> getDao() {
		return tipoAbogadoDao;
	}

}
