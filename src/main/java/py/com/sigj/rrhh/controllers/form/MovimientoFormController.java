package py.com.sigj.rrhh.controllers.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.ExpedienteDao;
import py.com.sigj.expediente.domain.Expediente;
import py.com.sigj.expediente.domain.Persona;
import py.com.sigj.rrhh.controllers.list.MovimientoListController;
import py.com.sigj.rrhh.dao.EmpleadoDao;
import py.com.sigj.rrhh.dao.MovimientoDao;
import py.com.sigj.rrhh.dao.MovimientoExpedienteDao;
import py.com.sigj.rrhh.domain.Empleado;
import py.com.sigj.rrhh.domain.Movimiento;
import py.com.sigj.rrhh.domain.MovimientoExpediente;

@Controller
@Scope("request")
@RequestMapping("movimiento")
public class MovimientoFormController extends FormController<Movimiento> {

	@Autowired
	private MovimientoDao movimientoDao;
	
	@Autowired
	private MovimientoExpedienteDao movimientoExpedienteDao;
	
	@Autowired
	private ExpedienteDao expedienteDao;
	
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
		map.addAttribute("expedienteList", expedienteDao.getListAll(null));
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
			@RequestParam(value="movimiento-expediente",required = false) String expediente_id,
			@RequestParam(value="tipo",required = false) String tipo,
			@RequestParam(value="monto",required = false) String monto,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, obj, bindingResult,tipo,expediente_id,monto);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO MOVIMIENTO {}", obj);
			return editar_listado(map, obj, bindingResult,monto,tipo,expediente_id);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map,
			@Valid Movimiento obj,
			BindingResult bindingResult,@RequestParam(value="tipo",required = true) String ingresoEgreso,
			@RequestParam(value="expediente_id",required = true) String expediente_id,
			@RequestParam(value="monto",required = true) String monto) {
		try {
			String ingreso ="";
			String egreso = "";
			if (obj.getId() == null) {
				if("I".equals(ingresoEgreso.toUpperCase())){
					ingreso = monto.replaceAll("\\.", "");
					obj.setIngreso(Integer.valueOf(ingreso));
				}else{
					egreso = monto.replaceAll("\\.", "");
					obj.setEgreso(Integer.valueOf(egreso));
					
				}
				
				Long id_expediente = Long.parseLong(expediente_id);
				if(obj.getEmpleado().getId()==null){ // para el empleado generico 
					Empleado e = empleadoDao.find((long)10);
					obj.setEmpleado(e);
				}
				getDao().create(obj);
				if(id_expediente != 0){
					Expediente ex = expedienteDao.find(id_expediente);
					MovimientoExpediente me = new MovimientoExpediente();
					me.setExpediente(ex);
					me.setMovimiento(obj);
					movimientoExpedienteDao.create(me);
				}
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
			BindingResult bindingResult,String ingresoEgreso,String monto,String expediente_id) {
		try {
			
			Empleado empleado = null;
			if (obj != null) {
				if (obj.getEmpleado().getId() != null) {
					empleado = empleadoDao.find(obj.getEmpleado().getId());
					obj.setEmpleado(empleado);
				}

			}
			if(ingresoEgreso.equals("I")){
				monto = monto.replaceAll("\\.", "");
				obj.setIngreso(Integer.valueOf(monto));
			}else{
				obj.setIngreso(0);
			}
			if(ingresoEgreso.equals("E")){
				monto = monto.replaceAll("\\.", "");
				obj.setEgreso(Integer.valueOf(monto));
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
	
	
	
	@RequestMapping(value = "buscar-movimiento/{id_expediente}/{tipo}", method = RequestMethod.GET)
	public String buscar(HttpServletRequest request, ModelMap map, @PathVariable("id_expediente") Long id_expediente, 
			@PathVariable("tipo") String tipo) {
		List<Movimiento> mov = new ArrayList<>();
		List<MovimientoExpediente> me = null;
		try {
			me = movimientoDao.getLitMovimientoExpediente(id_expediente);
			map.addAttribute("movimiento_expediente", me);
			if("I".equals(tipo.toUpperCase())){
				map.addAttribute("isIngreso",true);
				map.addAttribute("isEgreso",false);
			}else{
				map.addAttribute("isIngreso",false);
				map.addAttribute("isEgreso",true);
			}
			
		} catch (Exception ex) {

			
		}
		agregarValoresAdicionales(map);
		
		return "rrhh/listado_ingreso_egreso_factura_index";
	}

}
