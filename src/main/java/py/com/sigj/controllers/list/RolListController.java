package py.com.sigj.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.dao.Dao;
import py.com.sigj.dao.RolDao;
import py.com.sigj.security.Rol;

@Controller
@Scope("session")
@RequestMapping("rol")
public class RolListController extends ListController<Rol> {

	@Autowired
	RolDao rolDao;
	
	@Override
	public String[] getColumnas() {
		
		return new String[] { "id", "codigo", "descripcion" };
	}

	@Override
	public Dao<Rol> getDao() {
		
		return rolDao;
	}

}
