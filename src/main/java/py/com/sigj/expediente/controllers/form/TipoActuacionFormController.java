package py.com.sigj.expediente.controllers.form;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.ResponseBody;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.TipoActuacionListController;
import py.com.sigj.expediente.dao.TipoActuacionDao;
import py.com.sigj.expediente.domain.Despacho;
import py.com.sigj.expediente.domain.Materia;
import py.com.sigj.expediente.domain.Proceso;
import py.com.sigj.expediente.domain.TipoActuacion;
import py.com.sigj.util.RenderingInfo;

@Controller
@Scope("request")
@RequestMapping("tipo_actuacion")
public class TipoActuacionFormController extends FormController<TipoActuacion> {

	@Autowired
	private TipoActuacionDao tipoActuacionDao;

	@Autowired
	private TipoActuacionListController tipoActuacionList;
	


	@Override
	public String getTemplatePath() {
		return "expediente/tipo_actuacion_index";
	}

	@Override
	public String getNombreObjeto() {
		return "tipoActuacion";
	}

	@Override
	public TipoActuacion getNuevaInstancia() {
		return new TipoActuacion();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", tipoActuacionList.getColumnas());
		map.addAttribute("columnasStr", tipoActuacionList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<TipoActuacion> getDao() {
		return tipoActuacionDao;
	}
	
	
	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid TipoActuacion obj,
			
			BindingResult bindingResult,
			@RequestParam(required = false) String accion,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, obj, bindingResult);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO Tipo Actuacion {}", obj);
			return editar_listado(map, obj, bindingResult);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);
		}
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @Valid TipoActuacion obj,
			BindingResult bindingResult) {
		try {
		
			if (obj.getId() == null) {
				getDao().createOrUpdate(obj);
			}
			

			// obj.setListaProceso(listProceso);
			// obj.setListaDespacho(listDespacho);
			

			map.addAttribute("msgExito", msg.get("Registro agregado"));
			logger.info("Se crea el tipo de Actuacion -> {}", obj);

		} catch (Exception ex) {
			// TODO: tener en cuenta si es nuevo o edit
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));

		}

		map.addAttribute(getNombreObjeto(), obj);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "editar_listado", method = RequestMethod.POST)
	public String editar_listado(ModelMap map, @Valid TipoActuacion obj,
			BindingResult bindingResult) {
		try {
			
			logger.info("ID DE OBJ {}", obj);
			
			getDao().createOrUpdate(obj);
			logger.info("tipo Actuacion Actualizado {}", obj);
			map.addAttribute("msgExito", msg.get("Registro Actualizado"));

		} catch (Exception ex) {
			// TODO: tener en cuenta si es nuevo o edit
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), obj);
		}

		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	public String eliminar_listado(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		TipoActuacion ta = new TipoActuacion();
		try {
			
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				ta = getDao().find(id_objeto);
				
				tipoActuacionDao.destroy(ta);

				logger.info("Tipo Actuacion eliminada {}", ta);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (Exception ex) {

			ta.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), ta);
		}

		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	



}
