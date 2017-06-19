package py.com.sigj.rrhh.controllers.form;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.PersonaDao;
import py.com.sigj.expediente.domain.Persona;
import py.com.sigj.rrhh.controllers.list.EmpleadoListController;
import py.com.sigj.rrhh.dao.EmpleadoDao;
import py.com.sigj.rrhh.domain.Empleado;

@Controller
@Scope("request")
@RequestMapping("empleado")
public class EmpleadoFormController extends FormController<Empleado> {

	@Autowired
	private EmpleadoDao empleadoDao;

	@Autowired
	private EmpleadoListController empleadoList;
	
	@Autowired
	private PersonaDao personaDao;

	@Override
	public String getTemplatePath() {
		return "rrhh/empleado_index";
	}

	@Override
	public String getNombreObjeto() {
		return "empleado";
	}

	@Override
	public Empleado getNuevaInstancia() {
		return new Empleado();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", empleadoList.getColumnas());
		map.addAttribute("columnasPersona", empleadoList.getColumnasPersona());
		map.addAttribute("columnasStr", empleadoList.getColumnasStr(null));
		map.addAttribute("columnasStrPersona", empleadoList.getColumnasStr(empleadoList.getColumnasPersona()));
		map.addAttribute("personaList", personaDao.getList(0, 100, null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Empleado> getDao() {
		return empleadoDao;
	}

	
	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Empleado obj,
			BindingResult bindingResult,
			@RequestParam(required = false) String accion,
			@RequestParam(value="salario_format",required = false) String salario,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, obj, bindingResult,salario);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO PROCESO {}", obj);
			return editar_listado(map, obj, bindingResult,salario);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map,
			@Valid Empleado obj,
			BindingResult bindingResult,String salario) {
		try {
			if (obj.getId() == null) {
				Persona persona = personaDao.find(obj.getPersona().getId());
				persona.setDisponible("NO");
				personaDao.createOrUpdate(persona);
				salario = salario.replaceAll("\\.", "");
				obj.setSalario(Integer.valueOf(salario));
				getDao().createOrUpdate(obj);
			}

			map.addAttribute("msgExito", msg.get("Registro agregado"));
			logger.info("Se crea empleado nuevo -> {}", obj);

		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));

		}
		map.addAttribute(getNombreObjeto(), obj);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "editar_listado", method = RequestMethod.POST)
	public String editar_listado(ModelMap map,
			@Valid Empleado obj, 
			BindingResult bindingResult,String salario) {
		try {
			
			Persona persona = null;
			if (obj != null) {
				if (obj.getPersona().getId() != null) {
					persona = personaDao.find(obj.getPersona().getId());
					obj.setPersona(persona);
				}

			}
			salario = salario.replaceAll("\\.", "");
			obj.setSalario(Integer.valueOf(salario));
			getDao().createOrUpdate(obj);
			logger.info("Empleado Actualizado {}", obj);
			map.addAttribute("msgExito", msg.get("Registro Actualizado"));

		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), obj);
		}
		Empleado c = new Empleado();
		map.addAttribute(getNombreObjeto(), c);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	public String eliminar_listado(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		Empleado empleado = new Empleado();
		Persona persona = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				empleado = getDao().find(id_objeto);
				empleado.getPersona().setDisponible("SI");
				personaDao.edit(empleado.getPersona());
				empleadoDao.destroy(empleado);
				logger.info("Cliente eliminado {}", empleado);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (Exception ex) {

			empleado.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), empleado);
		}

		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

}
