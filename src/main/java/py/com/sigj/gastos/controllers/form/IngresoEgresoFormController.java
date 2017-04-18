package py.com.sigj.gastos.controllers.form;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.controllers.list.IngresoEgresoListController;
import py.com.sigj.gastos.dao.IngresoEgresoDao;
import py.com.sigj.gastos.domain.IngresoEgreso;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("request")
@RequestMapping("ingreso_egreso")
public class IngresoEgresoFormController extends FormController<IngresoEgreso> {

	@Autowired
	private IngresoEgresoDao ingresoEgresoDao;

	@Autowired
	private IngresoEgresoListController ingresoEgresoList;

	@Override
	public String getTemplatePath() {
		return "gastos/ingreso_egreso_index";
	}

	@Override
	public String getNombreObjeto() {
		return "ingresoEgreso";
	}

	@Override
	public IngresoEgreso getNuevaInstancia() {
		return new IngresoEgreso();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", ingresoEgresoList.getColumnas());
		map.addAttribute("columnasStr", ingresoEgresoList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<IngresoEgreso> getDao() {
		return ingresoEgresoDao;
	}

	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid IngresoEgreso obj, @RequestParam(required = false) String accion,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			//return guardar_listado(map, obj);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO INGRESO_EGRESO {}", obj);
			//return editar_listado(map, obj);
		} else if (id_objeto != null) {
			//return eliminar_listado(map, id_objeto);
		}
		return getTemplatePath();

	}
}
	