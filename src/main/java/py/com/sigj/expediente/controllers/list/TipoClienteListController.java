package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.TipoClienteDao;
import py.com.sigj.expediente.domain.TipoCliente;

@Controller
@Scope("session")
@RequestMapping("tipo_cliente")
public class TipoClienteListController extends ListController<TipoCliente> {

	@Autowired
	private TipoClienteDao tipoClienteDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id","codigo", "descripcion" };
	}

	@Override
	public Dao<TipoCliente> getDao() {
		return tipoClienteDao;
	}

}
