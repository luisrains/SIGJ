package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.PersonaListController;
import py.com.sigj.expediente.dao.PersonaDao;
import py.com.sigj.expediente.domain.Persona;

@Controller
@Scope("request")
@RequestMapping("persona")
public class PersonaFormController extends FormController<Persona> {

	@Autowired
	private PersonaDao personaDao;

	@Autowired
	private PersonaListController personaList;

	@Override
	public String getTemplatePath() {
		return "test/persona_index";
	}

	@Override
	public String getNombreObjeto() {
		return "persona";
	}

	@Override
	public Persona getNuevaInstancia() {
		return new Persona();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", personaList.getColumnas());
		map.addAttribute("columnasStr", personaList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Persona> getDao() {
		return personaDao;
	}

}
