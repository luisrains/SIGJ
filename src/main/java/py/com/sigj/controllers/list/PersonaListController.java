package py.com.sigj.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.dao.PersonaDao;
import py.com.sigj.expediente.domain.PersonaFisica;

@Controller
@Scope("session")
@RequestMapping("persona")
public class PersonaListController extends ListController<PersonaFisica> {

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
