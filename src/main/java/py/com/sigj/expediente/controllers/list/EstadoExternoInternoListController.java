package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.EstadoExternoInternoDao;
import py.com.sigj.expediente.domain.EstadoExternoInterno;

@Controller
@Scope("session")
@RequestMapping("estado_externo_interno")
public class EstadoExternoInternoListController extends ListController<EstadoExternoInterno> {

	@Autowired
	private EstadoExternoInternoDao estadoExternoInternoDao;

	@Override
	public String[] getColumnas() {

		return new String[] { "id", "codigo", "descripcion", "tipoEstado" };
	}

	@Override
	public Dao<EstadoExternoInterno> getDao() {

		return estadoExternoInternoDao;
	}

}
