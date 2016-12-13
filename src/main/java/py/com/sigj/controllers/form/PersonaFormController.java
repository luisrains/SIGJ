package py.com.sigj.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.PersonaListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.dao.PersonaDao;
import py.com.sigj.domain.Persona;

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
		// TODO Auto-generated method stub
		return "persona/persona_index";
	}

	@Override
	public String getNombreObjeto() {
		return "persona";
	}

	@Override
	public Persona getNuevaInstancia() {
		// TODO Auto-generated method stub
		return new Persona();
	}

	@Override
	public Dao<Persona> getDao() {
		// TODO Auto-generated method stub
		return personaDao;
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", personaList.getColumnas());
		map.addAttribute("columnasStr", personaList.getColumnasStr());
		super.agregarValoresAdicionales(map);
	}

	/*
	 * private final Logger logger = LoggerFactory.getLogger(getClass());
	 *
	 * @Autowired private PersonaDao personaDao;
	 *
	 * @Autowired private Message msg;
	 *
	 * // una variable que es el spring lo que recibimos // en el model hay que
	 * cargar todas las variables que necesitamos
	 *
	 * @RequestMapping("persona") public String index(ModelMap map) {
	 *
	 * map.addAttribute("persona", new Persona()); return
	 * "persona/persona_index"; }
	 *
	 * // Valid es para que el spring use el hibernate para validar, la persona
	 * de // acuerdo a lo definido en la base de datos // el resultado de la
	 * validacion va mandarnos en bindingResult, porque no va // tirar ningun
	 * error
	 *
	 * @RequestMapping(value = "persona/save", method = RequestMethod.POST)
	 * public String guardar(ModelMap map, @Valid Persona persona, BindingResult
	 * bindingResult) { try { if (bindingResult.hasErrors()) {
	 * map.addAttribute("error", msg.get("errores_validacion"));
	 * List<FieldError> errores = bindingResult.getFieldErrors();
	 * map.addAttribute("errorList", errores); } else { if (persona.getId() ==
	 * null) { personaDao.create(persona); map.addAttribute("msgExito",
	 * msg.get("registro_agregado")); } else { personaDao.edit(persona);
	 * map.addAttribute("msgExito", msg.get("registro_actualizado")); }
	 *
	 * } } catch (Exception ex) {
	 *
	 * persona.setId(null); map.addAttribute("error",
	 * getErrorFromException(ex));
	 *
	 * }
	 *
	 * map.addAttribute("persona", persona); return "persona/persona_index"; }
	 */

	/**
	 * Cuando ocurre una excepción, el error que se muestra es muy genérico. Se
	 * debe recorrer el stack de error y verificar si no fue error de constraint
	 * (valores duplicados, etc.)
	 */
	/*
	 * private String getErrorFromException(final Exception exception) {
	 * Throwable th = exception; while (th != null) { if
	 * (th.getClass().equals(org.hibernate.exception.
	 * ConstraintViolationException.class)) { ConstraintViolationException cve =
	 * (ConstraintViolationException) th; return
	 * msg.get(cve.getConstraintName()); } th = th.getCause(); } return
	 * exception.getMessage(); }
	 *
	 * @RequestMapping("persona/edit/{id}") public String edit(ModelMap
	 * map, @PathVariable Long id) { try { Persona persona =
	 * personaDao.find(id); if (persona == null) { map.addAttribute("error",
	 * "No se encontró persona con id " + id); persona = new Persona(); }
	 * map.addAttribute("persona", persona); } catch (Exception ex) {
	 * map.addAttribute("error", "Error al buscar persona. " + ex.getMessage());
	 * map.addAttribute("persona", new Persona()); }
	 *
	 * return "persona/persona_index"; }
	 */

}
