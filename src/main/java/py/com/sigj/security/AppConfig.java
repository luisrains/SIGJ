package py.com.owl.owlapp.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan({ "py.com.owl*" })
@Import({ SecurityConfig.class })
public class AppConfig {

}
