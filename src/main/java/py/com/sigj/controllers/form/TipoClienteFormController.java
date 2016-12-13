package py.com.owl.owlapp.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.owl.owlapp.controllers.list.TipoClienteControllerList;
import py.com.owl.owlapp.dao.Dao;
import py.com.owl.owlapp.dao.TipoClienteDao;
import py.com.owl.owlapp.domain.TipoCliente;

@Controller
@Scope("request")
@RequestMapping("tipo_cliente")
public class TipoClienteFormController extends FormController<TipoCliente> {

	@Autowired
	private TipoClienteDao tipoClienteDao;

	@Autowired
	private TipoClienteControllerList tipoClienteList;

	@Override
	public String getTemplatePath() {
		return "tipo_cliente/tipo_cliente_index";
	}

	@Override
	public String getNombreObjeto() {
		// TODO Auto-generated method stub
		return "tipoCliente";
	}

	@Override
	public TipoCliente getNuevaInstancia() {
		// TODO Auto-generated method stub
		return new TipoCliente();
	}

	@Override
	public Dao<TipoCliente> getDao() {
		return tipoClienteDao;
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", tipoClienteList.getColumnas());
		map.addAttribute("columnasStr", tipoClienteList.getColumnasStr());
		super.agregarValoresAdicionales(map);
	}
	/*
	 * private final Logger logger = LoggerFactory.getLogger(getClass());
	 *
	 * @Autowired private TipoClienteDao tipoClienteDao;
	 *
	 * @Autowired private Message msg;
	 *
	 * @RequestMapping("tipo_cliente") public String index(ModelMap map) {
	 *
	 * map.addAttribute("tipoCliente", new TipoCliente()); return
	 * "tipo_cliente/tipo_cliente_index"; }
	 *
	 * @RequestMapping(value = "tipo_cliente/save", method = RequestMethod.POST)
	 * public String guardar(ModelMap map, @Valid TipoCliente tipoCliente,
	 * BindingResult bindingResult) { try { if (bindingResult.hasErrors()) {
	 * map.addAttribute("error", msg.get("errores_validacion"));
	 * List<FieldError> errores = bindingResult.getFieldErrors();
	 * map.addAttribute("errorList", errores); } else { if (tipoCliente.getId()
	 * == null) { tipoClienteDao.create(tipoCliente);
	 * map.addAttribute("msgExito", msg.get("registro_agregado")); } else {
	 * tipoClienteDao.edit(tipoCliente); map.addAttribute("msgExito",
	 * msg.get("registro_actualizado")); }
	 *
	 * } } catch (Exception ex) {
	 *
	 * tipoCliente.setId(null); map.addAttribute("error",
	 * getErrorFromException(ex));
	 *
	 * }
	 *
	 * map.addAttribute("tipoCliente", tipoCliente); return
	 * "tipo_cliente/tipo_cliente_index"; }
	 *
	 * @RequestMapping("tipo_cliente/edit/{id}") public String edit(ModelMap
	 * map, @PathVariable Long id) { try { TipoCliente tipoCliente =
	 * tipoClienteDao.find(id); if (tipoCliente == null) {
	 * map.addAttribute("error", "No se encontró el tipo de cliente con id " +
	 * id); tipoCliente = new TipoCliente(); } map.addAttribute("tipoCliente",
	 * tipoCliente); } catch (Exception ex) { map.addAttribute("error",
	 * "Error al buscar un tipo de cliente. " + ex.getMessage());
	 * map.addAttribute("tipoCliente", new TipoCliente()); }
	 *
	 * return "tipo_cliente/tipo_cliente_index"; }
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
	 */
}
