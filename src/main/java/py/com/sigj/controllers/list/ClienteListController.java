package py.com.sigj.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.dao.ClienteDao;
import py.com.sigj.dao.TipoClienteDao;
import py.com.sigj.expediente.domain.Cliente;

@Controller
@Scope("session")
@RequestMapping("cliente")
public class ClienteListController extends ListController<Cliente> {

	@Autowired
	private TipoClienteDao tipoClienteDao;

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public ClienteDao getDao() {
		return clienteDao;
	}

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "codigo", "ruc", "razonSocial", "tipoCliente.nombre" };
	}

}
