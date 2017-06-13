package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.MovimientoActuacionDao;
import py.com.sigj.expediente.domain.MovimientoActuacion;

@Controller
@Scope("session")
@RequestMapping("actuacion")
public class MovimientoActuacionListController extends ListController<MovimientoActuacion> {

	@Autowired
	private MovimientoActuacionDao movimientoActuacionDao;

	// , "documento.descripcion" "expediente.nroExpediente",
	@Override
	public String[] getColumnas() {
		return new String[] { "id", "observacion", "fechaPresentacion", "fechaVencimiento", "tipo_actuacion.descripcion", "tipo_actuacion.plazo" };
	}

	@Override
	public Dao<MovimientoActuacion> getDao() {
		return movimientoActuacionDao;
	}

	/*
	 * public String[] getColumnasPersona() { return new String[] { "id",
	 * "persona.cedula_ruc", "persona.nombre_razonSocial", "persona.apellido" };
	 * }
	 */
}
