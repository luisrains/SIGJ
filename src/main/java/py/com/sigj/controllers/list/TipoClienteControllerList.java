package py.com.owl.owlapp.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.owl.owlapp.dao.TipoClienteDao;
import py.com.owl.owlapp.domain.TipoCliente;

@Controller
@Scope("session")
@RequestMapping("tipo_cliente")
public class TipoClienteControllerList extends ListController<TipoCliente> {

	@Autowired
	private TipoClienteDao tipoClienteDao;

	@Override
	public TipoClienteDao getDao() {
		// TODO Auto-generated method stub
		return tipoClienteDao;
	}

	@Override
	public String[] getColumnas() {
		// TODO Auto-generated method stub
		return new String[] { "id", "codigo", "nombre" };
	}

}
