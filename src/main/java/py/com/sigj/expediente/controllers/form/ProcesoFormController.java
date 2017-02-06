package py.com.sigj.expediente.controllers.form;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import py.com.sigj.controllers.Respuesta;
import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.ProcesoListController;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.dao.ProcesoDao;
import py.com.sigj.expediente.dao.ProcesoTipoDemandaDao;
import py.com.sigj.expediente.dao.TipoDemandaDao;
import py.com.sigj.expediente.domain.Proceso;
import py.com.sigj.expediente.domain.ProcesoTipoDemanda;
import py.com.sigj.expediente.domain.TipoDemanda;

@Controller
@Scope("request")
@RequestMapping("proceso")
public class ProcesoFormController extends FormController<Proceso> {

	@Autowired
	private ProcesoDao procesoDao;

	@Autowired
	private MateriaDao materiaDao;

	@Autowired
	private TipoDemandaDao tipoDemandaDao;

	@Autowired
	private ProcesoTipoDemandaDao procesoTipoDemandaDao;

	@Autowired
	private ProcesoListController procesoList;

	@Override
	public String getTemplatePath() {
		return "expediente/proceso_index";
	}

	@Override
	public String getNombreObjeto() {
		return "proceso";
	}

	@Override
	public Proceso getNuevaInstancia() {
		return new Proceso();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("materiaList", materiaDao.getList(0, 20, null));
		map.addAttribute("tipoDemandaList", tipoDemandaDao.getList(0, 20, null));
		logger.info("tipo demanda", tipoDemandaDao.getList(0, 20, null));
		map.addAttribute("columnas", procesoList.getColumnas());
		map.addAttribute("columnasStr", procesoList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Proceso> getDao() {
		return procesoDao;
	}

	/*
	 * falta llamar al controler de procesoTipoDemanda para poder mandarle un
	 * proceso y un tipo de demanda y asi cargar la tabla intermedia
	 */
	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @RequestParam("selec") List<String> selec, @Valid Proceso obj,
			BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				map.addAttribute("error", msg.get("errores_validacion"));
				List<FieldError> errores = bindingResult.getFieldErrors();
				map.addAttribute("errorList", errores);
			} else {
				if (obj.getId() == null) {
					getDao().create(obj);
					for (String idLong : selec) {
						Long idFormat = Long.parseLong(idLong);
						// creamos un tipoDemanda con el proceso y el tipo de
						// demanda seleccionado
						ProcesoTipoDemanda tipo = new ProcesoTipoDemanda();
						tipo.setProceso(obj);
						// buscamos el tipoDemanda
						TipoDemanda tipoDemanda = tipoDemandaDao.find(idFormat);
						tipo.setTipoDemanda(tipoDemanda);
						procesoTipoDemandaDao.create(tipo);
						logger.info("procesoTipoDemanda Creado {}", tipo);
					}

					map.addAttribute("msgExito", msg.get("Registro agregado"));
				} else {
					getDao().edit(obj);
					map.addAttribute("msgExito", msg.get("Registro Actualizado"));
				}

			}
		} catch (Exception ex) {
			// TODO: tener en cuenta si es nuevo o edit
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));

		}
		map.addAttribute(getNombreObjeto(), obj);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

}
