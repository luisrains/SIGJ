package py.com.owl.owlapp.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.owl.owlapp.dao.PersonaDao;
import py.com.owl.owlapp.domain.Persona;

@Controller
@Scope("session")
@RequestMapping("persona")
public class PersonaListController extends ListController<Persona> {

	@Autowired
	private PersonaDao personaDao;

	@Override
	public PersonaDao getDao() {
		return personaDao;
	}

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "cedula", "nombre", "apellido", "direccion" };
	}

}
