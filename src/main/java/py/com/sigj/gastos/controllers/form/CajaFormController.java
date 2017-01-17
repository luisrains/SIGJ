package py.com.sigj.gastos.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.controllers.list.CajaListController;
import py.com.sigj.gastos.dao.CajaDao;
import py.com.sigj.gastos.domain.Caja;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("request")
@RequestMapping("caja")
public class CajaFormController extends FormController<Caja> {

	@Autowired
	private CajaDao cajaDao;

	@Autowired
	private CajaListController cajaList;

	@Override
	public String getTemplatePath() {
		return "gastos/caja_index";
	}

	@Override
	public String getNombreObjeto() {
		return "caja";
	}

	@Override
	public Caja getNuevaInstancia() {
		return new Caja();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", cajaList.getColumnas());
		map.addAttribute("columnasStr", cajaList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Caja> getDao() {
		return cajaDao;
	}

}
