package py.com.sigj.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.dao.IvaDao;
import py.com.sigj.domain.Iva;

@Controller
@Scope("session")
@RequestMapping("iva")
public class IvaListController extends ListController<Iva> {

	@Autowired
	private IvaDao ivaDao;

	@Override
	public IvaDao getDao() {
		return ivaDao;
	}

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "codigo", "porcentaje", "baseImpositiva" };
	}

	public String getColumnasStr() {
		return "id;codigo;porcentaje;baseImpositiva";

	}

}
