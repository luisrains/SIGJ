package py.com.sigj.gastos.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.controllers.list.IngresoEgresoListController;
import py.com.sigj.gastos.dao.IngresoEgresoDao;
import py.com.sigj.gastos.domain.IngresoEgreso;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("request")
@RequestMapping("ingreso_egreso")
public class IngresoEgresoFormController extends FormController<IngresoEgreso> {

	@Autowired
	private IngresoEgresoDao ingresoEgresoDao;

	@Autowired
	private IngresoEgresoListController ingresoEgresoList;

	@Override
	public String getTemplatePath() {
		return "gastos/ingresoEgreso_index";
	}

	@Override
	public String getNombreObjeto() {
		return "ingresoEgreso";
	}

	@Override
	public IngresoEgreso getNuevaInstancia() {
		return new IngresoEgreso();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", ingresoEgresoList.getColumnas());
		map.addAttribute("columnasStr", ingresoEgresoList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<IngresoEgreso> getDao() {
		return ingresoEgresoDao;
	}

}
