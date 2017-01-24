package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.MateriaListController;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.domain.Materia;

@Controller
@Scope("request")
@RequestMapping("materia")
public class MateriaFormController extends FormController<Materia> {

	@Autowired
	private MateriaDao materiaDao;

	@Autowired
	private MateriaListController materiaList;

	@Override
	public String getTemplatePath() {
		return "expediente/materia_index";
	}

	@Override
	public String getNombreObjeto() {
		return "materia";
	}

	@Override
	public Materia getNuevaInstancia() {
		return new Materia();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", materiaList.getColumnas());
		map.addAttribute("columnasStr", materiaList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Materia> getDao() {
		return materiaDao;
	}

}
