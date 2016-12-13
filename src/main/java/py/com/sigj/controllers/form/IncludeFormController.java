package py.com.owl.owlapp.controllers.form;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("request")
// @RequestMapping("include")
public class IncludeFormController {

	@RequestMapping("include")
	public String includes() {
		return "includes";
	}

}
