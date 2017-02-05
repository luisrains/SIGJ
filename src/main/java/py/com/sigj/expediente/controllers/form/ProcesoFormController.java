package py.com.sigj.expediente.controllers.form;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.ProcesoListController;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.dao.ProcesoDao;
import py.com.sigj.expediente.dao.ProcesoTipoDemandaDao;
import py.com.sigj.expediente.dao.TipoDemandaDao;
import py.com.sigj.expediente.domain.Proceso;

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
	private ProcesoTipoDemandaFormController procesoTipoDemandaForm;

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
	public String guardar_listado(ModelMap map, @Valid Proceso obj, BindingResult bindingResult,
			Map<String, String> param) {
		logger.info("PARAMETROS arr {}", param);
		String tipos = param.get("selec");

		// ProcesoTipoDemanda ptd =
		// procesoTipoDemandaDao.find(Long.valueOf(arr[0]));
		/*
		 * Respuesta<ProcesoTipoDemanda> ptdr =
		 * procesoTipoDemandaForm.createOrUpdate(ptd, bindingResult); if
		 * (ptdr.isExito()) { logger.info("exitoso se agreggo",
		 * ptdr.getMensajeExito()); } else { logger.info("no fue exitoso",
		 * ptdr.getMensajeError()); } if (resp.isExito()) {
		 * map.addAttribute("msgExito", resp.getMensajeExito()); } else {
		 * map.addAttribute("error", resp.getMensajeError());
		 * map.addAttribute("errorList", resp.getErrores()); }
		 * 
		 * map.addAttribute(getNombreObjeto(), resp.getDato());
		 * agregarValoresAdicionales(map);
		 */
		return getTemplatePath();
	}

}
