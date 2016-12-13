package py.com.owl.owlapp.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Diego Cerrano
 * @since 1.0
 * @version 1 19/09/2016
 *
 */
@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class Dashboard {


	@RequestMapping("/")
	public String index() {

		return "index";
	}

}
