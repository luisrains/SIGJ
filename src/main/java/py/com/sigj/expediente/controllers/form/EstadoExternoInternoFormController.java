package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.EstadoExternoInternoListController;
import py.com.sigj.expediente.dao.EstadoExternoInternoDao;
import py.com.sigj.expediente.domain.EstadoExternoInterno;

@Controller
@Scope("request")
@RequestMapping("estado_externo_interno")
public class EstadoExternoInternoFormController extends FormController<EstadoExternoInterno> {

	@Autowired
	private EstadoExternoInternoDao estadoExternoInternoDao;

	@Autowired
	private EstadoExternoInternoListController estadoExternoInternoList;

	@Override
	public String getTemplatePath() {

		return "expediente/estado_externo_interno_index";
	}

	@Override
	public String getNombreObjeto() {

		return "estadoExternoInterno";
	}

	@Override
	public EstadoExternoInterno getNuevaInstancia() {

		return new EstadoExternoInterno();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", estadoExternoInternoList.getColumnas());
		map.addAttribute("columnasStr", estadoExternoInternoList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<EstadoExternoInterno> getDao() {

		return estadoExternoInternoDao;
	}

}
