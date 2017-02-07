package py.com.sigj.rrhh.controllers.form;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.rrhh.controllers.list.PlanillaSalarioListController;
import py.com.sigj.rrhh.dao.PlanillaSalarioDao;
import py.com.sigj.rrhh.domain.PlanillaSalario;

@Controller
@Scope("request")
@RequestMapping("planilla_salario")
public class PlanillaSalarioFormController extends FormController<PlanillaSalario> {

	@Autowired
	private PlanillaSalarioDao planillaSalarioDao;

	@Autowired
	private PlanillaSalarioListController planillaSalarioList;

	@Override
	public String getTemplatePath() {
		return "rrhh/planillaSalario_index";
	}

	@Override
	public String getNombreObjeto() {
		return "planillaSalario";
	}

	@Override
	public PlanillaSalario getNuevaInstancia() {
		return new PlanillaSalario();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", planillaSalarioList.getColumnas());
		map.addAttribute("columnasStr", planillaSalarioList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<PlanillaSalario> getDao() {
		return planillaSalarioDao;
	}

	@RequestMapping(value = "/validar_fecha", method = RequestMethod.POST)
	public List<Object[]> validar_fecha(ModelMap map, @RequestParam(required = true) String fecha) {
		logger.info("Fecha:{}", fecha);
		logger.info("Esto hay en map:{}", map);
		List<Object[]> list = planillaSalarioDao.lista_planilla(fecha);
		return list;

	}

}
