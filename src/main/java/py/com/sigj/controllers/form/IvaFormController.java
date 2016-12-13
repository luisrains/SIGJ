package py.com.owl.owlapp.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.owl.owlapp.controllers.list.IvaListController;
import py.com.owl.owlapp.dao.Dao;
import py.com.owl.owlapp.dao.IvaDao;
import py.com.owl.owlapp.domain.Iva;

@Controller
@Scope("request")
@RequestMapping("iva")
public class IvaFormController extends FormController<Iva> {

	@Autowired
	private IvaDao ivaDao;

	@Autowired
	private IvaListController ivaList;

	@Override
	public String getTemplatePath() {
		return "iva/iva_index";
	}

	@Override
	public String getNombreObjeto() {
		return "iva";
	}

	@Override
	public Iva getNuevaInstancia() {
		// TODO Auto-generated method stub
		return new Iva();
	}

	@Override
	public Dao<Iva> getDao() {
		// TODO Auto-generated method stub
		return ivaDao;
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", ivaList.getColumnas());
		map.addAttribute("columnasStr", ivaList.getColumnasStr());
		super.agregarValoresAdicionales(map);
	}

}
