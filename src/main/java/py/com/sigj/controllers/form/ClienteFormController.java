package py.com.sigj.controllers.form;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ClienteListController;
import py.com.sigj.dao.ClienteDao;
import py.com.sigj.dao.Dao;
import py.com.sigj.dao.TipoClienteDao;
import py.com.sigj.domain.Cliente;
import py.com.sigj.domain.TipoCliente;

@Controller
@Scope("request")
@RequestMapping("cliente")
public class ClienteFormController extends FormController<Cliente> {

	@Autowired
	private ClienteDao clienteDao;

	@Autowired
	private TipoClienteDao tipoClienteDao;

	@Autowired
	private ClienteListController clienteList;

	@Override
	public String getTemplatePath() {
		return "cliente/cliente_index";
	}

	@Override
	public String getNombreObjeto() {
		return "cliente";
	}

	@Override
	public Cliente getNuevaInstancia() {
		// TODO Auto-generated method stub
		return new Cliente();
	}

	@Override
	public Dao<Cliente> getDao() {
		// TODO Auto-generated method stub
		return clienteDao;
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("tipoClienteList", tipoClienteDao.getList(0, 20, null));
		map.addAttribute("columnas", clienteList.getColumnas());
		map.addAttribute("columnasStr", clienteList.getColumnasStr());
		super.agregarValoresAdicionales(map);
	}

	// otra opcion de agregar valores adicionales
	@ModelAttribute("tipoClienteList2")
	public List<TipoCliente> getTipoClienteList() {
		return tipoClienteDao.getList(0, 20, null);

	}
}
