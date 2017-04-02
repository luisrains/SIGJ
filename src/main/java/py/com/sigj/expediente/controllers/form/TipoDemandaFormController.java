package py.com.sigj.expediente.controllers.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.TipoDemandaListController;
import py.com.sigj.expediente.dao.ExpedienteDao;
import py.com.sigj.expediente.dao.TipoDemandaDao;
import py.com.sigj.expediente.domain.Expediente;
import py.com.sigj.expediente.domain.TipoDemanda;

@Controller
@Scope("request")
@RequestMapping("tipo_demanda")
public class TipoDemandaFormController extends FormController<TipoDemanda> {

	@Autowired
	private TipoDemandaDao tipoDemandaDao;

	@Autowired
	private ExpedienteDao expedienteDao;

	@Autowired
	private TipoDemandaListController tipoDemandaList;

	@Override
	public String getTemplatePath() {
		return "expediente/tipo_demanda_index";
	}

	@Override
	public String getNombreObjeto() {
		return "tipoDemanda";
	}

	@Override
	public TipoDemanda getNuevaInstancia() {
		return new TipoDemanda();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", tipoDemandaList.getColumnas());
		map.addAttribute("columnasStr", tipoDemandaList.getColumnasStr(null));
		map.addAttribute("expedienteList", expedienteDao.getList(0, 20, null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<TipoDemanda> getDao() {
		return tipoDemandaDao;
	}

	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid TipoDemanda obj, BindingResult bindingResult,
			@RequestParam(required = false) String accion,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, obj, bindingResult);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO Tipo Demanda {}", obj);
			return editar_listado(map, obj, bindingResult);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @Valid TipoDemanda obj, BindingResult bindingResult) {
		try {
			if (obj.getId() == null) {
				getDao().createOrUpdate(obj);

				map.addAttribute("msgExito", msg.get("Registro agregado"));
				logger.info("Se crea un nuevo TipoDemanda -> {}", obj);
			}

		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
		}
		map.addAttribute(getNombreObjeto(), obj);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "editar_listado", method = RequestMethod.POST)
	public String editar_listado(ModelMap map, @Valid TipoDemanda obj, BindingResult bindingResult) {
		try {
			if (obj != null) {
				getDao().createOrUpdate(obj);
				logger.info("TipoDemanda Actualizado {}", obj);
				map.addAttribute("msgExito", msg.get("Registro Actualizado"));
			}
		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), obj);
		}
		agregarValoresAdicionales(map);
		return getTemplatePath();
	}

	@RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	public String eliminar_listado(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		List<Expediente> listExpediente = new ArrayList<Expediente>();
		TipoDemanda tipoDemanda = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				tipoDemanda = getDao().find(id_objeto);
				tipoDemanda.setListExpediente(listExpediente);
				getDao().destroy(tipoDemanda);

				logger.info("TipoDemanda eliminado  {}", tipoDemanda);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (UnexpectedRollbackException ex) {
			tipoDemanda.setId(null);
			map.addAttribute("error", "No puede borrar un Objeto de Causa ya que un proceso hace referencia al mismo.");
			map.addAttribute(getNombreObjeto(), tipoDemanda);
		}
		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}
}
