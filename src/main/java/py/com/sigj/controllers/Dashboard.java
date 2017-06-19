package py.com.sigj.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import py.com.sigj.main.SesionUsuario;
import py.com.sigj.util.ExpedienteActuacionBean;
import py.com.sigj.util.WebUtils;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class Dashboard {

	@Autowired
	private SesionUsuario sesionUsuario;
	
	@Autowired
	private ExpedienteDao expedienteDao;
	
	@Autowired
	private MovimientoActuacionDao movimientoActuacionDao;
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}

	@RequestMapping("inicio")
	public String start(ModelMap map,HttpServletRequest request) {
		ExpedienteActuacionBean exAc = null;
		List<ExpedienteActuacionBean> listExAc = new ArrayList<>();
		List<ExpedienteAbogado> exp = null;
		
		if(sesionUsuario!= null && sesionUsuario.getUsuario().getCedulaRuc() != null){
			String cedula = sesionUsuario.getUsuario().getCedulaRuc();
			exp = expedienteDao.getListByCedulaRuc(cedula);
			
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
			
		}
		
		
		
		HttpSession session = request.getSession();
		map.addAttribute("expediente", exp);
		map.addAttribute("expedienteActuacionBean", listExAc);
		session.setAttribute("currentUserName", sesionUsuario.getUsuario().getNombreRazonSocial());
		session.setAttribute("currentUserLast", sesionUsuario.getUsuario().getApellido());
		session.setAttribute("userSession", sesionUsuario);
		
		map.addAttribute("userSession", sesionUsuario);
//		map.addAttribute("currentUserName", sesionUsuario.getUsuario().getNombreRazonSocial());
//		map.addAttribute("currentUserLast", sesionUsuario.getUsuario().getApellido());
		return "inicio";
	}
	

}
