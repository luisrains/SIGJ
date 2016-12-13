package py.com.owl.owlapp.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.owl.owlapp.dao.RolDao;
import py.com.owl.owlapp.dao.UsuarioDao;
import py.com.owl.owlapp.domain.Usuario;

@Controller
@Scope("session")
@RequestMapping("usuario")
public class UsuarioListController extends ListController<Usuario> {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private RolDao rolDao;

	@Override
	public UsuarioDao getDao() {
		return usuarioDao;
	}

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "codigo", "nombre", "apellido", "rolStr" };
	}

}
