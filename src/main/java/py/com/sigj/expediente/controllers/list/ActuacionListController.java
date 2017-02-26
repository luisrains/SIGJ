package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.ActuacionDao;
import py.com.sigj.expediente.domain.Actuacion;

@Controller
@Scope("session")
@RequestMapping("actuacion")
public class ActuacionListController extends ListController<Actuacion> {

	@Autowired
	private ActuacionDao actuacionDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "documento.descripcion", "tipoActuacion.descripcion", "expediente.nroExpediente",
				"descripcion", "fechaEstado" };
	}

	@Override
	public Dao<Actuacion> getDao() {
		return actuacionDao;
	}

	/*
	 * public String[] getColumnasPersona() { return new String[] { "id",
	 * "persona.cedula_ruc", "persona.nombre_razonSocial", "persona.apellido" };
	 * }
	 */
}
