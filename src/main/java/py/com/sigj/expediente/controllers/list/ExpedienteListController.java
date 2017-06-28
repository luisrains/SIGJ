package py.com.sigj.expediente.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.ExpedienteDao;
import py.com.sigj.expediente.domain.Expediente;

@Controller
@Scope("session")
@RequestMapping("expediente")
public class ExpedienteListController extends ListController<Expediente> {

	@Autowired
	private ExpedienteDao expedienteDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "caratula", "nroExpediente", "anho", "monto", "moneda", "estadoExterno.descripcion","estadoInterno.descripcion", "fechaSelloCargo" };
	}

	@Override
	public Dao<Expediente> getDao() {
		return expedienteDao;
	}

	/*
	 * public String[] getColumnasPersona() { return new String[] { "id",
	 * "persona.cedula_ruc", "persona.nombre_razonSocial", "persona.apellido" };
	 * }
	 */
}
