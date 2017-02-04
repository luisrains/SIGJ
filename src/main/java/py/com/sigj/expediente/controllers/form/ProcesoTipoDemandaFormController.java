package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.TipoDemandaListController;
import py.com.sigj.expediente.dao.ProcesoTipoDemandaDao;
import py.com.sigj.expediente.domain.ProcesoTipoDemanda;

@Controller
@Scope("request")
@RequestMapping("proceso_tipo_demanda")
public class ProcesoTipoDemandaFormController extends FormController<ProcesoTipoDemanda> {

	@Autowired
	private ProcesoTipoDemandaDao procesoTipoDemandaDao;

	@Autowired
	private TipoDemandaListController tipoDemandaList;

	@Override
	public String getTemplatePath() {
		return "test/tipoDemanda_index";
	}

	@Override
	public String getNombreObjeto() {
		return "tipoDemanda";
	}

	@Override
	public ProcesoTipoDemanda getNuevaInstancia() {
		return new ProcesoTipoDemanda();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", tipoDemandaList.getColumnas());
		map.addAttribute("columnasStr", tipoDemandaList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<ProcesoTipoDemanda> getDao() {
		return procesoTipoDemandaDao;
	}

}
