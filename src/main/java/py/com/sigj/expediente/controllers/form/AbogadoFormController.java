package py.com.sigj.expediente.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.AbogadoListController;
import py.com.sigj.expediente.dao.AbogadoDao;
import py.com.sigj.expediente.dao.TipoAbogadoDao;
import py.com.sigj.expediente.domain.Abogado;

@Controller
@Scope("request")
@RequestMapping("abogado")
public class AbogadoFormController extends FormController<Abogado> {

	@Autowired
	private AbogadoDao abogadoDao;

	@Autowired
	private TipoAbogadoDao tipoAbogadoDao;

	@Autowired
	private AbogadoListController abogadoList;

	@Override
	public String getTemplatePath() {
		return "expediente/abogado_index";
	}

	@Override
	public String getNombreObjeto() {
		return "abogado";
	}

	@Override
	public Abogado getNuevaInstancia() {
		return new Abogado();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("tipoAbogadoList", tipoAbogadoDao.getList(0, 20, null));
		map.addAttribute("columnas", abogadoList.getColumnas());
		map.addAttribute("columnasStr", abogadoList.getColumnasStr(null));
		String[] ve = { "id", "cedula_ruc", "nombre_razonSocial" };
		map.addAttribute("columnasStrPersona", abogadoList.getColumnasStr(abogadoList.getColumnasPersona()));
		map.addAttribute("columnasPersona", abogadoList.getColumnasPersona());
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Abogado> getDao() {
		return abogadoDao;
	}

}
