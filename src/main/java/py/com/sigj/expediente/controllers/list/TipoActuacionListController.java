package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.TipoActuacionDao;
import py.com.sigj.expediente.domain.TipoActuacion;

@Controller
@Scope("session")
@RequestMapping("tipo_actuacion")
public class TipoActuacionListController extends ListController<TipoActuacion> {

	@Autowired
	private TipoActuacionDao tipoActuacionDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "abreviatura" ,"descripcion", "plazo" };
	}

	@Override
	public Dao<TipoActuacion> getDao() {

		return tipoActuacionDao;
	}

}
