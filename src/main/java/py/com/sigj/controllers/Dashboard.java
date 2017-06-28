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

		List<ExpedienteAbogado> expList = null;
		List<ExpedienteActuacionBean> ultimosDiezExpediente = new ArrayList<>();
		List<ExpedienteActuacionBean> expedienteSinVencer = new ArrayList<>();
		HttpSession session = request.getSession();
		if(sesionUsuario!= null && sesionUsuario.getUsuario().getCedulaRuc() != null){
			String cedula = sesionUsuario.getUsuario().getCedulaRuc();
			expList = expedienteDao.getListByCedulaRuc(cedula);
			int cantDias=0;
			int cont=0;
			Date fechaActual = new Date();
			for (ExpedienteAbogado expe : expList) {
				if(expe.getExpediente().getFechaActuacion()!=null){
					cantDias =WebUtils.getDaysBetweenDates(fechaActual,expe.getExpediente().getFechaActuacion());
					if(cantDias <=3 && cantDias >=0){
						//cargamos los ultimos diez si alcanza diez, si sobre pasa salimos con el break
						ExpedienteActuacionBean eac = new ExpedienteActuacionBean();
						eac.setDiaVencimiento(cantDias);
						eac.setExpediente(expe.getExpediente());
						ultimosDiezExpediente.add(eac);
						cont++;		
					}else{
						ExpedienteActuacionBean eAcSin = new ExpedienteActuacionBean();
						eAcSin.setDiaVencimiento(cantDias);
						eAcSin.setExpediente(expe.getExpediente());
						expedienteSinVencer.add(eAcSin);
					}
					
					if(cont==10){
						break;
					}	
				}
			}
		
		
		map.addAttribute("expediente", expList);
		map.addAttribute("ultimosDiezExpediente", ultimosDiezExpediente);
		map.addAttribute("expedienteSinVencer", expedienteSinVencer);
		
		session.setAttribute("currentUserName", sesionUsuario.getUsuario().getNombreRazonSocial());
		session.setAttribute("currentUserLast", sesionUsuario.getUsuario().getApellido());
		session.setAttribute("userSession", sesionUsuario);
		
		map.addAttribute("userSession", sesionUsuario);
		return "inicio";
	}
		map.addAttribute("expediente", expList);
		map.addAttribute("ultimosDiezExpediente", ultimosDiezExpediente);
		map.addAttribute("expedienteSinVencer", expedienteSinVencer);
		session.setAttribute("currentUserName", sesionUsuario.getUsuario().getNombreRazonSocial());
		session.setAttribute("currentUserLast", sesionUsuario.getUsuario().getApellido());
		session.setAttribute("userSession", sesionUsuario);
		
		map.addAttribute("userSession", sesionUsuario);
		return "inicio";
	
	}
}
