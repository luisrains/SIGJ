package py.com.sigj.security;

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
		map.put("/cliente/**", "ver-cli");
//		map.put("/materia/**", "ver-mat");
//		map.put("/usuario/**", "ver-usu");
//		map.put("/proceso/**", "ver-pro");
//		map.put("/expediente/**", "ver-exp");
//		map.put("/abogado/**", "ver-abg");
//		map.put("/actuacion/**", "ver-act");
//		map.put("/despacho/**", "ver-des");
//		map.put("/documento/**", "ver-doc");
//		map.put("/estado_externo_interno/**", "ver-estExtInt");
		map.put("/inicio/**", "ver-inicio");
		//faltan mas url que mapear, ver si no podemos meter en una base de datos la url y que lea de ahi para que no tener muchas lineas de codigo
		return map;
	}

}
