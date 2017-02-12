package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.ModeloHojaListController;
import py.com.sigj.expediente.dao.ModeloHojaDao;
import py.com.sigj.expediente.domain.ModeloHoja;

@Controller
@Scope("request")
@RequestMapping("modelo_hoja")
public class ModeloHojaFormController extends FormController<ModeloHoja> {

	@Autowired
	private ModeloHojaDao modeloHojaDao;

	@Autowired
	private ModeloHojaListController modeloHojaList;

	@Override
	public String getTemplatePath() {
		return "expediente/modeloHoja_index";
	}

	@Override
	public String getNombreObjeto() {
		return "modeloHoja";
	}

	@Override
	public ModeloHoja getNuevaInstancia() {
		return new ModeloHoja();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", modeloHojaList.getColumnas());
		map.addAttribute("columnasStr", modeloHojaList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<ModeloHoja> getDao() {
		return modeloHojaDao;
	}

}
