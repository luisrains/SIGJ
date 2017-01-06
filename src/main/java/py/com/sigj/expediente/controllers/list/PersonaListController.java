package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.PersonaDao;
import py.com.sigj.expediente.domain.Persona;

@Controller
@Scope("session")
@RequestMapping("persona")
public class PersonaListController extends ListController<Persona> {

	@Autowired
	private PersonaDao personaDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "cedula_ruc", "nombre_razonSocial", "apellido", "fechaNacimiento", "edad", "sexo",
				"estadoCivil", "ocupacion", "correoElectronico", "telefono", "tipoPersona" };
	}

	@Override
	public Dao<Persona> getDao() {
		return personaDao;
	}

}
