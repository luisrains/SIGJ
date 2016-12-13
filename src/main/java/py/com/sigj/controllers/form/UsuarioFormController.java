package py.com.owl.owlapp.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.owl.owlapp.controllers.list.UsuarioListController;
import py.com.owl.owlapp.dao.Dao;
import py.com.owl.owlapp.dao.RolDao;
import py.com.owl.owlapp.dao.UsuarioDao;
import py.com.owl.owlapp.domain.Usuario;

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
		map.addAttribute("columnasStr", usuarioList.getColumnasStr());
		super.agregarValoresAdicionales(map);
	}
}
