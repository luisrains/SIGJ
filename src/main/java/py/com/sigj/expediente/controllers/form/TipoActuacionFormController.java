package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.TipoActuacionListController;
import py.com.sigj.expediente.dao.TipoActuacionDao;
import py.com.sigj.expediente.domain.TipoActuacion;

@Controller
@Scope("request")
@RequestMapping("tipo_actuacion")
public class TipoActuacionFormController extends FormController<TipoActuacion> {

	@Autowired
	private TipoActuacionDao tipoActuacionDao;

	@Autowired
	private TipoActuacionListController tipoActuacionList;

	@Override
	public String getTemplatePath() {
		return "expediente/tipo_actuacion_index";
	}

	@Override
	public String getNombreObjeto() {
		return "tipoActuacion";
	}

	@Override
	public TipoActuacion getNuevaInstancia() {
		return new TipoActuacion();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", tipoActuacionList.getColumnas());
		map.addAttribute("columnasStr", tipoActuacionList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<TipoActuacion> getDao() {
		return tipoActuacionDao;
	}

}
