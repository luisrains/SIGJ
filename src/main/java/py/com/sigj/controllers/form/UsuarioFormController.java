package py.com.sigj.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.list.UsuarioListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.dao.RolDao;
import py.com.sigj.dao.UsuarioDao;
import py.com.sigj.security.Usuario;

@Controller
@Scope("request")
@RequestMapping("usuario")
public class UsuarioFormController extends FormController<Usuario> {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private RolDao rolDao;
	@Autowired
	private UsuarioListController usuarioList;

	@Override
	public String getTemplatePath() {
		return "usuario/usuario_index";
	}

	@Override
	public String getNombreObjeto() {
		return "usuario";
	}

	@Override
	public Usuario getNuevaInstancia() {
		return new Usuario();
	}

	@Override
	public Dao<Usuario> getDao() {
		return usuarioDao;
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("rolList", rolDao.getList(0, 20, null));
		map.addAttribute("columnas", usuarioList.getColumnas());
		map.addAttribute("columnasStr", usuarioList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}
}
