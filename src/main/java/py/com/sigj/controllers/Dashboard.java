package py.com.sigj.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class Dashboard {

	@RequestMapping("/")
	public String index() {

		return "index";
	}

	@RequestMapping("inicio")
	public String start() {

		return "inicio";
	}
	

}
