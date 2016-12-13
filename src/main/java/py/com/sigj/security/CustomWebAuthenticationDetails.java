package py.com.owl.owlapp.security;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CustomWebAuthenticationDetails(HttpServletRequest request) {

		super(request);

		Enumeration<String> params = request.getParameterNames();
		/* Obtenemos todos los parámetros del request y cargamos en la sesión */
		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
			request.getSession().setAttribute(paramName,
					request.getParameter(paramName));

		}
	}

}
