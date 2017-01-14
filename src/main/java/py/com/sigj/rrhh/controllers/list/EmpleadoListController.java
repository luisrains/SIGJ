package py.com.sigj.rrhh.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.rrhh.dao.EmpleadoDao;
import py.com.sigj.rrhh.domain.Empleado;

@Controller
@Scope("session")
@RequestMapping("empleado")
public class EmpleadoListController extends ListController<Empleado> {

	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "persona.cedula_ruc", "persona.nombre_razonSocial", "persona.apellido", "salario",
				"fechaIngreso" };
	}

	@Override
	public Dao<Empleado> getDao() {
		return empleadoDao;
	}

	public String[] getColumnasPersona() {
		return new String[] { "id", "cedula_ruc", "nombre_razonSocial", "apellido" };
	}

}
