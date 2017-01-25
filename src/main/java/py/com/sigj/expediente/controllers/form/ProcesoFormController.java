package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.ProcesoListController;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.dao.ProcesoDao;
import py.com.sigj.expediente.domain.Proceso;

@Controller
@Scope("request")
@RequestMapping("proceso")
public class ProcesoFormController extends FormController<Proceso> {

	@Autowired
	private ProcesoDao procesoDao;

	@Autowired
	private MateriaDao materiaDao;

	@Autowired
	private ProcesoListController procesoList;

	@Override
	public String getTemplatePath() {
		return "expediente/proceso_index";
	}

	@Override
	public String getNombreObjeto() {
		return "proceso";
	}

	@Override
	public Proceso getNuevaInstancia() {
		return new Proceso();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("materiaList", materiaDao.getList(0, 20, null));
		map.addAttribute("columnas", procesoList.getColumnas());
		map.addAttribute("columnasStr", procesoList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Proceso> getDao() {
		return procesoDao;
	}

}
