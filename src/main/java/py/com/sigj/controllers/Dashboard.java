package py.com.sigj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import py.com.sigj.expediente.dao.ExpedienteDao;
import py.com.sigj.expediente.dao.MovimientoActuacionDao;
import py.com.sigj.expediente.domain.ExpedienteCliente;
import py.com.sigj.expediente.domain.MovimientoActuacion;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class Dashboard {

	@Autowired
	private ExpedienteDao expedienteDao;
	
	@Autowired
	private MovimientoActuacionDao movimientoActuacionDao;
	
	@RequestMapping("/")
	public String index() {

		return "index";
	}

	@RequestMapping("inicio")
	public String start(ModelMap map) {
		String cedula = "121321";
		List<ExpedienteCliente> exp = expedienteDao.getListByCedulaRuc(cedula);
		
		for (ExpedienteCliente expe : exp) {
			MovimientoActuacion actuacion = movimientoActuacionDao.getListActuacionByExpediente(expe.getExpediente().getId());
			
		}
		map.addAttribute("expediente", exp);
		return "inicio";
	}

}
