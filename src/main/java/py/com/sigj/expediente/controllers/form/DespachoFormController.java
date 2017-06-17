package py.com.sigj.expediente.controllers.form;

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
import py.com.sigj.expediente.controllers.list.DespachoListController;
import py.com.sigj.expediente.dao.DespachoDao;
import py.com.sigj.expediente.dao.ExpedienteDao;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.domain.Despacho;

@Controller
@Scope("request")
@RequestMapping("despacho")
public class DespachoFormController extends FormController<Despacho> {

	@Autowired
	private DespachoDao despachoDao;

	@Autowired
	private MateriaDao materiaDao;

	@Autowired
	private ExpedienteDao expedienteDao;

	@Autowired
	private DespachoListController despachoList;

	@Override
	public String getTemplatePath() {
		return "expediente/despacho_index";
	}

	@Override
	public String getNombreObjeto() {
		return "despacho";
	}

	@Override
	public Despacho getNuevaInstancia() {
		return new Despacho();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("expedienteList", expedienteDao.getList(0, 20, null));
		map.addAttribute("columnas", despachoList.getColumnas());
		map.addAttribute("columnasStr", despachoList.getColumnasStr(null));

		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Despacho> getDao() {
		return despachoDao;
	}

	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Despacho obj, BindingResult bindingResult,
			@RequestParam(required = false) String accion,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, obj, bindingResult);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO PROCESO {}", obj);
			return editar_listado(map, obj, bindingResult);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @Valid Despacho obj, BindingResult bindingResult) {
		try {
			if (obj.getId() == null) {
				getDao().createOrUpdate(obj);

				map.addAttribute("msgExito", msg.get("Registro agregado"));
				logger.info("Se crea un nuevo Despacho -> {}", obj);
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
	public String editar_listado(ModelMap map, @Valid Despacho obj, BindingResult bindingResult) {
		try {
			if (obj != null) {
				getDao().createOrUpdate(obj);
				logger.info("Despacho Actualizado {}", obj);
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

		Despacho despacho = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				despacho = getDao().find(id_objeto);
				getDao().destroy(despacho);

				logger.info("Despacho eliminado  {}", despacho);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (UnexpectedRollbackException ex) {
			despacho.setId(null);
			map.addAttribute("error", "No puede borrar un despacho ya que una materia hace referencia al mismo.");
			map.addAttribute(getNombreObjeto(), despacho);
		}
		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

}
