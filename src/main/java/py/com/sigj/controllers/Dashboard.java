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
import py.com.sigj.expediente.domain.Expediente;

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
		Long cedula = (long) 121321;
		List<Expediente> exp = expedienteDao.getListByCedulaRuc(cedula);
		
//		for (Expediente expe : exp) {
//			List<MovimientoActuacion> actuaciones = movimientoActuacionDao.getListActuacionByExpediente(expe.getId());
//		
//		}
		map.addAttribute("expediente", exp);
		return "inicio";
	}

}
