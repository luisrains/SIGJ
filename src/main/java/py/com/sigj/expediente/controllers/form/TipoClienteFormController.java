package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.TipoClienteListController;
import py.com.sigj.expediente.dao.TipoClienteDao;
import py.com.sigj.expediente.domain.TipoCliente;

@Controller
@Scope("request")
@RequestMapping("tipo_cliente")
public class TipoClienteFormController extends FormController<TipoCliente> {

	@Autowired
	private TipoClienteDao tipoClienteDao;

	@Autowired
	private TipoClienteListController tipoClienteList;

	@Override
	public String getTemplatePath() {
		return "test/tipoCliente_index";
	}

	@Override
	public String getNombreObjeto() {
		return "tipoCliente";
	}

	@Override
	public TipoCliente getNuevaInstancia() {
		return new TipoCliente();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", tipoClienteList.getColumnas());
		map.addAttribute("columnasStr", tipoClienteList.getColumnasStr());
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<TipoCliente> getDao() {
		return tipoClienteDao;
	}

}
