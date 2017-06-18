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
import py.com.sigj.expediente.domain.Persona;
import py.com.sigj.rrhh.controllers.list.MovimientoListController;
import py.com.sigj.rrhh.dao.EmpleadoDao;
import py.com.sigj.rrhh.dao.MovimientoDao;
import py.com.sigj.rrhh.domain.Empleado;
import py.com.sigj.rrhh.domain.Movimiento;

@Controller
@Scope("request")
@RequestMapping("movimiento")
public class MovimientoFormController extends FormController<Movimiento> {

	@Autowired
	private MovimientoDao movimientoDao;
	
	@Autowired
	private EmpleadoDao empleadoDao;

	@Autowired
	private MovimientoListController movimientoList;

	@Override
	public String getTemplatePath() {
		return "rrhh/movimiento_index";
	}

	@Override
	public String getNombreObjeto() {
		return "movimiento";
	}

	@Override
	public Movimiento getNuevaInstancia() {
		return new Movimiento();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", movimientoList.getColumnas());
		map.addAttribute("columnasPersona", movimientoList.getColumnasPersona());
		map.addAttribute("columnasStr", movimientoList.getColumnasStr(null));
		map.addAttribute("columnasStrPersona", movimientoList.getColumnasStr(movimientoList.getColumnasPersona()));
		map.addAttribute("empleadoList", empleadoDao.getList(0, 100, null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Movimiento> getDao() {
		return movimientoDao;
	}

	
	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Movimiento obj,
			BindingResult bindingResult,
			@RequestParam(required = false) String accion,
			@RequestParam(value="egreso_format",required = false) String egreso,
			@RequestParam(value="ingreso_format",required = false) String ingreso,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, obj, bindingResult,ingreso,egreso);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO MOVIMIENTO {}", obj);
			return editar_listado(map, obj, bindingResult,ingreso,egreso);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map,
			@Valid Movimiento obj,
			BindingResult bindingResult,String ingreso,String egreso) {
		try {
			if (obj.getId() == null) {
				if(ingreso.equals("") || ingreso == ""){
					obj.setIngreso(0);
				}else{
					ingreso = ingreso.replaceAll("\\.", "");
					obj.setIngreso(Integer.valueOf(ingreso));
				}
				if(egreso == "" || egreso.equals("")){
					obj.setEgreso(0);
				}else{
					egreso = egreso.replaceAll("\\.", "");
					obj.setEgreso(Integer.valueOf(egreso));
				}
				
				getDao().create(obj);
			}

			map.addAttribute("msgExito", msg.get("Registro agregado"));
			logger.info("Se crea movimiento nuevo -> {}", obj);

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
			@Valid Movimiento obj, 
			BindingResult bindingResult,String ingreso,String egreso) {
		try {
			
			Empleado empleado = null;
			if (obj != null) {
				if (obj.getEmpleado().getId() != null) {
					empleado = empleadoDao.find(obj.getEmpleado().getId());
					obj.setEmpleado(empleado);
				}

			}
			if(ingreso.equals("") || ingreso == ""){
				ingreso = ingreso.replaceAll("\\.", "");
				obj.setIngreso(Integer.valueOf(ingreso));
			}else{
				obj.setIngreso(0);
			}
			if(egreso == "" || egreso.equals("")){
				egreso = egreso.replaceAll("\\.", "");
				obj.setEgreso(Integer.valueOf(egreso));
			}else{
				obj.setEgreso(0);
			}
			getDao().createOrUpdate(obj);
			logger.info("Movimiento Actualizado {}", obj);
			map.addAttribute("msgExito", msg.get("Registro Actualizado"));

		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), obj);
		}
		Movimiento c = new Movimiento();
		map.addAttribute(getNombreObjeto(), c);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	public String eliminar_listado(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		Movimiento movimiento = new Movimiento();
		Persona persona = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				movimiento = getDao().find(id_objeto);
				movimientoDao.destroy(movimiento);
				logger.info("Cliente eliminado {}", movimiento);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (Exception ex) {

			movimiento.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), movimiento);
		}

		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

}
