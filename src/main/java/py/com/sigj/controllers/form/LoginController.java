package py.com.sigj.controllers.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import py.com.sigj.dao.UsuarioDao;
import py.com.sigj.main.SesionUsuario;
import py.com.sigj.security.Usuario;

@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SesionUsuario sesionUsuario;
	
	@Autowired
	UsuarioDao usuarioDao;

	@RequestMapping("/403")
	public String error() {

		return "403";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getMaxInactiveInterval() > 60){
			sesionUsuario.setUsuario(null);
			return "login";
		}
		
		sesionUsuario.setUsuario(null);
		return "login";
	}
	
	@RequestMapping("usuario/logout")
	public String logoutUsuario(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getMaxInactiveInterval() > 60){
			sesionUsuario.setUsuario(null);
			return "login";
		}
		
		sesionUsuario.setUsuario(null);
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(ModelMap modelMap,HttpServletRequest request) {
		
		logger.info(String.valueOf(sesionUsuario.getUsuario()));
		
		if (sesionUsuario.isLogger()) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60); // duracion de la session 5min
			session.setAttribute("usuario", sesionUsuario.getUsuario().getRol().getCodigo());
			modelMap.addAttribute("usuario", sesionUsuario.getUsuario().getRol().getCodigo());
			logger.info(String.valueOf(session.getAttribute("usuario")));
			return "redirect:inicio";
		}
		if (sesionUsuario.getUsuarioPorConfirmar() != null) {
			logger.info("Contraseña incorrecta");
			modelMap.addAttribute("errorMsg", "Usuario o Contraseña incorrecta");
			return "login";
			
		}
		if(sesionUsuario.getUsuario() == null){
			
			return "login";
		}
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60); // duracion de la session 5min
		session.setAttribute("usuario", sesionUsuario.getUsuario().getRol().getCodigo());
		modelMap.addAttribute("usuario", sesionUsuario.getUsuario().getRol().getCodigo());
		logger.info(String.valueOf(session.getAttribute("usuario")));
		return "inicio";
	}

	
	 /* @RequestMapping(value = "/login", method = RequestMethod.POST) public
	  String login2(@RequestParam(required = false) String next, ModelMap
	  modelMap, @RequestParam String username,
	 
	  @RequestParam String password,HttpServletRequest request) { try { Usuario usuario =
	  usuarioDao.buscar(username);
	  HttpSession session = request.getSession();
	  if (usuario == null) { modelMap.addAttribute("error",
	  "Usuario o contraseña incorrectos");
	 
	  } else { ((SesionUsuario) session).setUsuario(usuario);
	  logger.info("Usuario '{}' inició sesion -> ", username, new Date()); if
	  (next != null) { logger.info("redirect '{}' next -> ", next); return
	  "redirect:" + next;
	 
	  } else { return "redirect:/dashboard/"; } } } catch (Exception e) {
	  logger.error("Error BD al buscar usuario", e);
	 
	  } return "login"; }*/
	 

}
