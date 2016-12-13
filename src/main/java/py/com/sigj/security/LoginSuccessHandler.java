package py.com.owl.owlapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import py.com.owl.owlapp.main.Contexto;
import py.com.owl.owlapp.main.SesionUsuario;

@Service
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		SesionUsuario sesionUsuario = (SesionUsuario) Contexto.getBean("sesionUsuario");
		sesionUsuario.setUsuario(sesionUsuario.getUsuarioPorConfirmar());
		logger.info("Usuario autenticado con éxito: {}", sesionUsuario.getUsuario());
		super.onAuthenticationSuccess(request, response, authentication);

	}

}
