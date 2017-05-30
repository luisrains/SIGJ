package py.com.sigj.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan({ "py.com.sigj*" })
@Import({ SecurityConfig.class })
public class AppConfig {

	@Bean
	public CommonsMultipartResolver filterMultipartResolver(){
	    return new CommonsMultipartResolver();
	}
}
