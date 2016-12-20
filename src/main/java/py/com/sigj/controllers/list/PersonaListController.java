package py.com.sigj.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.dao.Dao;
import py.com.sigj.dao.PersonaDao;
import py.com.sigj.expediente.domain.Persona;

@Controller
@Scope("session")
@RequestMapping("persona")
public class PersonaListController extends ListController<Persona> {

	@Autowired
	private PersonaDao personaDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "cedula", "nombre", "apellido", "direccion" };
	}

	@Override
	public Dao<Persona> getDao() {
		// TODO Auto-generated method stub
		return personaDao;
	}

}
