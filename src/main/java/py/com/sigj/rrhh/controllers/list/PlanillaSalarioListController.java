package py.com.sigj.rrhh.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.rrhh.dao.PlanillaSalarioDao;
import py.com.sigj.rrhh.domain.PlanillaSalario;

@Controller
@Scope("session")
@RequestMapping("planilla_salario")
public class PlanillaSalarioListController extends ListController<PlanillaSalario> {

	@Autowired
	private PlanillaSalarioDao planillaSalarioDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "mes", "anho", "ingresoTotal", "egresoTotal", "montoCobro" };
	}

	@Override
	public Dao<PlanillaSalario> getDao() {
		return planillaSalarioDao;
	}

}
