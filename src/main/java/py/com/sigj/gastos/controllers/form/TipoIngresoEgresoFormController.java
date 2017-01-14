package py.com.sigj.gastos.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.controllers.list.TipoIngresoEgresoListController;
import py.com.sigj.gastos.dao.TipoIngresoEgresoDao;
import py.com.sigj.gastos.domain.TipoIngresoEgreso;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("request")
@RequestMapping("tipo_ingreso_egreso")
public class TipoIngresoEgresoFormController extends FormController<TipoIngresoEgreso> {

	@Autowired
	private TipoIngresoEgresoDao tipoIngresoEgresoDao;

	@Autowired
	private TipoIngresoEgresoListController tipoIngresoEgresoList;

	@Override
	public String getTemplatePath() {
		return "test/tipoIngresoEgreso_index";
	}

	@Override
	public String getNombreObjeto() {
		return "tipoIngresoEgreso";
	}

	@Override
	public TipoIngresoEgreso getNuevaInstancia() {
		return new TipoIngresoEgreso();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", tipoIngresoEgresoList.getColumnas());
		map.addAttribute("columnasStr", tipoIngresoEgresoList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<TipoIngresoEgreso> getDao() {
		return tipoIngresoEgresoDao;
	}

}
