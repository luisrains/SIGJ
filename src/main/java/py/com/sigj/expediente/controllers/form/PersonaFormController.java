package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "expediente/persona_index";
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
	@RequestMapping(value = "eliminar", method = RequestMethod.POST)
	public String eliminarModel(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		Persona persona = new Persona();
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				persona = getDao().find(id_objeto);
				personaDao.destroy(persona);
				logger.info("Persona eliminado {}", persona);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (Exception ex) {

			persona.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), persona);
		}

		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();
	}
}
