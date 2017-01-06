package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.TipoAbogadoListController;
import py.com.sigj.expediente.dao.TipoAbogadoDao;
import py.com.sigj.expediente.domain.TipoAbogado;

@Controller
@Scope("request")
@RequestMapping("tipo_abogado")
public class TipoAbogadoFormController extends FormController<TipoAbogado> {

	@Autowired
	private TipoAbogadoDao tipoAbogadoDao;

	@Autowired
	private TipoAbogadoListController tipoAbogadoList;

	@Override
	public String getTemplatePath() {
		return "test/tipoAbogado_index";
	}

	@Override
	public String getNombreObjeto() {
		return "tipoAbogado";
	}

	@Override
	public TipoAbogado getNuevaInstancia() {
		return new TipoAbogado();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", tipoAbogadoList.getColumnas());
		map.addAttribute("columnasStr", tipoAbogadoList.getColumnasStr());
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<TipoAbogado> getDao() {
		return tipoAbogadoDao;
	}

}
