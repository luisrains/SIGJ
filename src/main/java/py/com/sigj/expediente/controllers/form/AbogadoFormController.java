package py.com.sigj.expediente.controllers.form;

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
import py.com.sigj.expediente.controllers.list.AbogadoListController;
import py.com.sigj.expediente.dao.AbogadoDao;
import py.com.sigj.expediente.domain.Abogado;
import py.com.sigj.rrhh.dao.EmpleadoDao;
import py.com.sigj.rrhh.domain.Empleado;

@Controller
@Scope("request")
@RequestMapping("abogado")
public class AbogadoFormController extends FormController<Abogado> {

	@Autowired
	private AbogadoDao abogadoDao;

	@Autowired
	private EmpleadoDao empleadoDao;

	@Autowired
	private AbogadoListController abogadoList;

	@Override
	public String getTemplatePath() {
		return "expediente/abogado_index";
	}

	@Override
	public String getNombreObjeto() {
		return "abogado";
	}

	@Override
	public Abogado getNuevaInstancia() {
		return new Abogado();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("empleadoList", empleadoDao.getList(0, 20, null));
		map.addAttribute("columnas", abogadoList.getColumnas());
		map.addAttribute("columnasEmpleado", abogadoList.getColumnasPersona());
		map.addAttribute("columnasStr", abogadoList.getColumnasStr(null));
		map.addAttribute("columnasStrEmpleado", abogadoList.getColumnasStr(abogadoList.getColumnasPersona()));

		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Abogado> getDao() {
		return abogadoDao;
	}

	// accion2
	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Abogado obj, BindingResult bindingResult,
			@RequestParam(required = false) String accion,
			@RequestParam(value = "selec", required = false) String selec,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto,
			@RequestParam(value = "id_empleado", required = false) Long id_empleado) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, obj, id_empleado, bindingResult);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO PROCESO {}", obj);
			return editar_listado(map, obj, id_empleado, bindingResult);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @Valid Abogado obj,
			@RequestParam(value = "id_empleado", required = true) Long id_empleado, BindingResult bindingResult) {
		try {
			if (obj.getId() == null) {
				getDao().create(obj);
			}

			map.addAttribute("msgExito", msg.get("Registro agregado"));
			logger.info("Se crea abogado nuevo -> {}", obj);

		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));

		}
		map.addAttribute(getNombreObjeto(), obj);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "editar_listado", method = RequestMethod.POST)
	public String editar_listado(ModelMap map, @Valid Abogado obj,
			@RequestParam(value = "id_empleado", required = true) Long id_empleado, BindingResult bindingResult) {
		try {

			Empleado empleado = null;
			if (obj != null && id_empleado != null) {
				if (obj.getEmpleado().getId() != id_empleado) {
					empleado = empleadoDao.find(id_empleado);
					obj.setEmpleado(empleado);
				}

			}
			getDao().createOrUpdate(obj);
			logger.info("Abogado Actualizado {}", obj);
			map.addAttribute("msgExito", msg.get("Registro Actualizado"));

		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), obj);
		}
		Abogado c = new Abogado();
		map.addAttribute(getNombreObjeto(), c);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	public String eliminar_listado(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		Abogado abogado = new Abogado();
		Empleado empleado = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				abogado = getDao().find(id_objeto);
				abogadoDao.destroy(abogado);
				logger.info("Abogado eliminado {}", abogado);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (Exception ex) {

			abogado.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), abogado);
		}

		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

}
