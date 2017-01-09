package py.com.sigj.gastos.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.controllers.list.FacturaDetalleListController;
import py.com.sigj.gastos.dao.FacturaDetalleDao;
import py.com.sigj.gastos.domain.FacturaDetalle;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("request")
@RequestMapping("caja")
public class FacturaDetalleFormController extends FormController<FacturaDetalle> {

	@Autowired
	private FacturaDetalleDao facturaDetalleDao;

	@Autowired
	private FacturaDetalleListController facturaDetalleList;

	@Override
	public String getTemplatePath() {
		return "test/facturaDetalle_index";
	}

	@Override
	public String getNombreObjeto() {
		return "facturaDetalle";
	}

	@Override
	public FacturaDetalle getNuevaInstancia() {
		return new FacturaDetalle();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", facturaDetalleList.getColumnas());
		map.addAttribute("columnasStr", facturaDetalleList.getColumnasStr());
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<FacturaDetalle> getDao() {
		return facturaDetalleDao;
	}

}
