package py.com.sigj.gastos.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.controllers.list.FacturaCabeceraListController;
import py.com.sigj.gastos.dao.FacturaCabeceraDao;
import py.com.sigj.gastos.domain.FacturaCabecera;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("request")
@RequestMapping("factura_cabecera")
public class FacturaCabeceraFormController extends FormController<FacturaCabecera> {

	@Autowired
	private FacturaCabeceraDao facturaCabeceraDao;

	@Autowired
	private FacturaCabeceraListController facturaCabeceraList;

	@Override
	public String getTemplatePath() {
		return "gastos/facturaCabecera_index";
	}

	@Override
	public String getNombreObjeto() {
		return "facturaCabecera";
	}

	@Override
	public FacturaCabecera getNuevaInstancia() {
		return new FacturaCabecera();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", facturaCabeceraList.getColumnas());
		map.addAttribute("columnasStr", facturaCabeceraList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<FacturaCabecera> getDao() {
		return facturaCabeceraDao;
	}

}
