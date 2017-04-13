package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.ClienteDao;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.Cliente;

@Controller
@Scope("session")
@RequestMapping("cliente")
public class ClienteListController extends ListController<Cliente> {

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "persona.cedula_ruc", "persona.nombre_razonSocial", "persona.apellido" };
	}

	@Override
	public Dao<Cliente> getDao() {
		return clienteDao;
	}

	public String[] getColumnasPersona() {
		return new String[] { "id", "cedula_ruc", "nombre_razonSocial", "apellido" };
	}
}
