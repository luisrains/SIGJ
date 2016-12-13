package py.com.sigj.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.dao.RolDao;
import py.com.sigj.dao.UsuarioDao;
import py.com.sigj.domain.Usuario;

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
