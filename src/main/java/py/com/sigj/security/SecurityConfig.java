package py.com.owl.owlapp.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private LoginSuccessHandler successHandler;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userRoleService).passwordEncoder(new Md5PasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expression = http
				.authorizeRequests();

		Map<String, String> map = permisosUrl();
		for (String url : map.keySet()) {
			String permiso = map.get(url);
			expression = expression.antMatchers(url).access("hasAuthority('" + permiso + "')");

		}
		expression.and().formLogin().loginPage("/login").and().formLogin().successHandler(successHandler).and()
				.exceptionHandling().accessDeniedPage("/403").and().formLogin();

	}

	private Map<String, String> permisosUrl() {
		Map<String, String> map = new HashMap<>();
		map.put("/cliente/**", "Cliente_sel");
		map.put("/persona/**", "Persona_sel");
		map.put("/proveedor/**", "Proveedor_sel");
		map.put("/usuario/**", "Usuario_sel");
		map.put("/venta/**", "Venta_sel");
		map.put("/iva/**", "Iva_sel");

		return map;
	}

}
