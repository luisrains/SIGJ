package py.com.sigj.expediente.controllers.form;

import java.util.ArrayList;
import java.util.List;

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
import py.com.sigj.dao.ClienteDao;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.ClienteListController;
import py.com.sigj.expediente.controllers.list.ExpedienteListController;
import py.com.sigj.expediente.dao.ExpedienteDao;
import py.com.sigj.expediente.dao.PersonaDao;
import py.com.sigj.expediente.domain.Cliente;
import py.com.sigj.expediente.domain.Expediente;
import py.com.sigj.expediente.domain.Persona;
import py.com.sigj.gastos.controllers.list.FacturaCabeceraListController;
import py.com.sigj.gastos.dao.FacturaCabeceraDao;
import py.com.sigj.gastos.domain.FacturaCabecera;

@Controller
@Scope("request")
@RequestMapping("cliente")
public class ClienteFormController extends FormController<Cliente> {

	@Autowired
	private ClienteDao clienteDao;

	

	@Autowired
	private PersonaDao personaDao;

	

	@Autowired
	private ClienteListController clienteList;

	

	@Override
	public String getTemplatePath() {
		return "expediente/cliente_index";
	}

	@Override
	public String getNombreObjeto() {
		return "cliente";
	}

	@Override
	public Cliente getNuevaInstancia() {
		return new Cliente();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", clienteList.getColumnas());
		map.addAttribute("columnasStr", clienteList.getColumnasStr(null));
		map.addAttribute("columnasPersona", clienteList.getColumnasPersona());
		map.addAttribute("columnasStrPersona", clienteList.getColumnasStr(clienteList.getColumnasPersona()));
		
		map.addAttribute("personaList", personaDao.getList(0, 100, null));

		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Cliente> getDao() {
		return clienteDao;
	}

	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Cliente obj,
			BindingResult bindingResult,
			@RequestParam(required = false) String accion,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, obj, bindingResult);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO PROCESO {}", obj);
			return editar_listado(map,obj, bindingResult);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, 
			@Valid Cliente obj,
			BindingResult bindingResult) {
		try {
			if (obj.getId() == null) {
				getDao().createOrUpdate(obj);
			}

			map.addAttribute("msgExito", msg.get("Registro agregado"));
			logger.info("Se crea cliente nuevo -> {}", obj);

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
			@Valid Cliente obj,
			BindingResult bindingResult) {
		try {
			List<FacturaCabecera> listFactura = new ArrayList<FacturaCabecera>();
			List<Expediente> listExpediente = new ArrayList<Expediente>();
			Persona persona = null;
			if (obj != null ) {
				if (obj.getPersona().getId() != null) {
					persona = personaDao.find(obj.getPersona().getId());
					obj.setPersona(persona);
				}

			}
			
			getDao().createOrUpdate(obj);
			logger.info("Cliente Actualizado {}", obj);
			map.addAttribute("msgExito", msg.get("Registro Actualizado"));

		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), obj);
		}
		Cliente c = new Cliente();
		map.addAttribute(getNombreObjeto(), c);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	public String eliminar_listado(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		Cliente cliente = new Cliente();
		Persona persona = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				cliente = getDao().find(id_objeto);
				clienteDao.destroy(cliente);
				logger.info("Cliente eliminado {}", cliente);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (Exception ex) {

			cliente.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), cliente);
		}

		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

}