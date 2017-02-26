package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.ActuacionListController;
import py.com.sigj.expediente.dao.ActuacionDao;
import py.com.sigj.expediente.domain.Actuacion;

@Controller
@Scope("request")
@RequestMapping("actuacion")
public class ActuacionFormController extends FormController<Actuacion> {

	@Autowired
	private ActuacionDao actuacionDao;

	@Autowired
	private ActuacionListController actuacionList;

	@Override
	public String getTemplatePath() {
		return "expediente/Actuacion_index";
	}

	@Override
	public String getNombreObjeto() {
		return "actuacion";
	}

	@Override
	public Actuacion getNuevaInstancia() {
		return new Actuacion();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("actuacionList", actuacionDao.getList(0, 20, null));
		map.addAttribute("columnas", actuacionList.getColumnas());
		map.addAttribute("columnasStr", actuacionList.getColumnasStr(null));

		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Actuacion> getDao() {
		return actuacionDao;
	}

}
