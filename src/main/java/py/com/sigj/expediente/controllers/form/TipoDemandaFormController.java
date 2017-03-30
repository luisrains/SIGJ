package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.ProcesoListController;
import py.com.sigj.expediente.controllers.list.TipoDemandaListController;
import py.com.sigj.expediente.dao.TipoDemandaDao;
import py.com.sigj.expediente.domain.TipoDemanda;

@Controller
@Scope("request")
@RequestMapping("tipo_demanda")
public class TipoDemandaFormController extends FormController<TipoDemanda> {

	@Autowired
	private TipoDemandaDao tipoDemandaDao;

	@Autowired
	private TipoDemandaListController tipoDemandaList;

	@Autowired
	private ProcesoListController procesoList;

	@Override
	public String getTemplatePath() {
		return "expediente/tipo_demanda_index";
	}

	@Override
	public String getNombreObjeto() {
		return "tipoDemanda";
	}

	@Override
	public TipoDemanda getNuevaInstancia() {
		return new TipoDemanda();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", tipoDemandaList.getColumnas());
		map.addAttribute("columnasStr", tipoDemandaList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<TipoDemanda> getDao() {
		return tipoDemandaDao;
	}

}
