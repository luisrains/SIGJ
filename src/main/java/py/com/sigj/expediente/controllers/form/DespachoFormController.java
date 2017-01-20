package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.DespachoListController;
import py.com.sigj.expediente.dao.DespachoDao;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.domain.Despacho;

@Controller
@Scope("request")
@RequestMapping("despacho")
public class DespachoFormController extends FormController<Despacho> {

	@Autowired
	private DespachoDao despachoDao;

	@Autowired
	private MateriaDao materiaDao;

	@Autowired
	private DespachoListController despachoList;

	@Override
	public String getTemplatePath() {
		return "expediente/despacho_index_p";
	}

	@Override
	public String getNombreObjeto() {
		return "despacho";
	}

	@Override
	public Despacho getNuevaInstancia() {
		return new Despacho();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("materiaList", materiaDao.getList(0, 20, null));
		map.addAttribute("columnas", despachoList.getColumnas());
		map.addAttribute("columnasStr", despachoList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Despacho> getDao() {
		return despachoDao;
	}

}
