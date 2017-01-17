package py.com.sigj.rrhh.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.rrhh.controllers.list.EmpleadoListController;
import py.com.sigj.rrhh.dao.EmpleadoDao;
import py.com.sigj.rrhh.domain.Empleado;

@Controller
@Scope("request")
@RequestMapping("empleado")
public class EmpleadoFormController extends FormController<Empleado> {

	@Autowired
	private EmpleadoDao empleadoDao;

	@Autowired
	private EmpleadoListController empleadoList;

	@Override
	public String getTemplatePath() {
		return "rrhh/empleado_index";
	}

	@Override
	public String getNombreObjeto() {
		return "empleado";
	}

	@Override
	public Empleado getNuevaInstancia() {
		return new Empleado();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", empleadoList.getColumnas());
		map.addAttribute("columnasPersona", empleadoList.getColumnasPersona());
		map.addAttribute("columnasStr", empleadoList.getColumnasStr(null));
		map.addAttribute("columnasStrPersona", empleadoList.getColumnasStr(empleadoList.getColumnasPersona()));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Empleado> getDao() {
		return empleadoDao;
	}

}
