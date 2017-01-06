package py.com.sigj.gastos.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.controllers.list.ServicioListController;
import py.com.sigj.gastos.dao.ServicioDao;
import py.com.sigj.gastos.domain.Servicio;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("request")
@RequestMapping("servicio")
public class ServicioFormController extends FormController<Servicio> {

	@Autowired
	private ServicioDao servicioDao;

	@Autowired
	private ServicioListController servicioList;

	@Override
	public String getTemplatePath() {
		return "test/servicio_index";
	}

	@Override
	public String getNombreObjeto() {
		return "servicio";
	}

	@Override
	public Servicio getNuevaInstancia() {
		return new Servicio();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", servicioList.getColumnas());
		map.addAttribute("columnasStr", servicioList.getColumnasStr());
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Servicio> getDao() {
		return servicioDao;
	}

}
