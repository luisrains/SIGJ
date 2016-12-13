package py.com.sigj.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomWebAuthenticationDetailsSource
implements
AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {

	@Override
	public WebAuthenticationDetails buildDetails(HttpServletRequest context) {

		return new CustomWebAuthenticationDetails(context);
	}
}