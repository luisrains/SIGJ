package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.AbogadoDao;
import py.com.sigj.expediente.domain.Abogado;

@Controller
@Scope("session")
@RequestMapping("abogado")
public class AbogadoListController extends ListController<Abogado> {

	@Autowired
	private AbogadoDao abogadoDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "domicilioLaboral", "domicilioActual", "empleado.salario",
				"tipoAbogado.descripcion" };
	}

	@Override
	public Dao<Abogado> getDao() {
		return abogadoDao;
	}

	public String[] getColumnasPersona() {
		return new String[] { "id", "cedula_ruc", "nombre_razonSocial", "apellido" };
	}
}
