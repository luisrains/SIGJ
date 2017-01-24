package py.com.sigj.rrhh.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.rrhh.controllers.list.MovimientoListController;
import py.com.sigj.rrhh.dao.MovimientoDao;
import py.com.sigj.rrhh.domain.Movimiento;

@Controller
@Scope("request")
@RequestMapping("movimiento")
public class MovimientoFormController extends FormController<Movimiento> {

	@Autowired
	private MovimientoDao movimientoDao;

	@Autowired
	private MovimientoListController movimientoList;

	@Override
	public String getTemplatePath() {
		return "rrhh/movimiento_index";
	}

	@Override
	public String getNombreObjeto() {
		return "movimiento";
	}

	@Override
	public Movimiento getNuevaInstancia() {
		return new Movimiento();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", movimientoList.getColumnas());
		map.addAttribute("columnasPersona", movimientoList.getColumnasPersona());
		map.addAttribute("columnasStr", movimientoList.getColumnasStr(null));
		map.addAttribute("columnasStrPersona", movimientoList.getColumnasStr(movimientoList.getColumnasPersona()));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Movimiento> getDao() {
		return movimientoDao;
	}

}
