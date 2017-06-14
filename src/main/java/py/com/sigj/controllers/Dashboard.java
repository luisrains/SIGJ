package py.com.sigj.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import py.com.sigj.expediente.dao.ExpedienteDao;
import py.com.sigj.expediente.dao.MovimientoActuacionDao;
import py.com.sigj.expediente.domain.ExpedienteAbogado;
import py.com.sigj.expediente.domain.MovimientoActuacion;
import py.com.sigj.util.ExpedienteActuacionBean;
import py.com.sigj.util.WebUtils;

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
		String cedula = "4810026";
		List<ExpedienteAbogado> exp = expedienteDao.getListByCedulaRuc(cedula);
		ExpedienteActuacionBean exAc = null;
		List<ExpedienteActuacionBean> listExAc = new ArrayList<>();
		Date fechaActual = new Date();
		for (ExpedienteAbogado expe : exp) {
			List<MovimientoActuacion> actuacion = movimientoActuacionDao.getListActuacionByExpediente(expe.getExpediente().getId());
			if(actuacion != null && !actuacion.isEmpty()){
				for(MovimientoActuacion ma : actuacion){
					exAc = new ExpedienteActuacionBean();
					exAc.setActuacion(ma);
					exAc.setExpediente(expe.getExpediente());
					exAc.setDiaVencimiento(WebUtils.getDaysBetweenDates(fechaActual,ma.getFechaVencimiento()));
				}
				listExAc.add(exAc);
				
			}
			
		}
		map.addAttribute("expediente", exp);
		map.addAttribute("expedienteActuacionBean", listExAc);
		return "inicio";
	}

}
