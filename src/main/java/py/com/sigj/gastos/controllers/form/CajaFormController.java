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
import py.com.sigj.gastos.controllers.list.CajaListController;
import py.com.sigj.gastos.dao.CajaDao;
import py.com.sigj.gastos.domain.Caja;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("request")
@RequestMapping("caja")
public class CajaFormController extends FormController<Caja> {

	@Autowired
	private CajaDao cajaDao;

	@Autowired
	private CajaListController cajaList;

	@Override
	public String getTemplatePath() {
		return "gastos/caja_index";
	}

	@Override
	public String getNombreObjeto() {
		return "caja";
	}

	@Override
	public Caja getNuevaInstancia() {
		return new Caja();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", cajaList.getColumnas());
		map.addAttribute("columnasStr", cajaList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Caja> getDao() {
		return cajaDao;
	}

	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Caja obj, 
			@RequestParam(required = false) String accion,
			@RequestParam(value="monto_format",required = false) String monto,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {
		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, obj,monto);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO CAJA {}", obj);
			return editar_listado(map, obj,monto);
		} else if (id_objeto != null) {
			return eliminar_listado(map, id_objeto);
		}
		return getTemplatePath();

	}

	@RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	public String eliminar_listado(ModelMap map, @RequestParam("id_objeto") Long id_objeto) {
		Caja caja = null;
		try {
			logger.info("ID DE OBJ {}", id_objeto);
			if (id_objeto != null) {
				caja = getDao().find(id_objeto);
				getDao().destroy(caja);

				logger.info("Caja eliminada {}", caja);
				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
			}
		} catch (Exception ex) {
			caja.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), caja);
		}
		map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado", method = RequestMethod.POST)
	public String guardar_listado(ModelMap map, @Valid Caja obj,String monto) {
		try {

			if (obj.getId() == null) {
				monto = monto.replaceAll("\\.", "");
				obj.setMonto(Integer.valueOf(monto));
				getDao().createOrUpdate(obj);
				map.addAttribute("msgExito", msg.get("Registro agregado"));
				logger.info("Se crea una nueva Caja -> {}", obj);
			}
		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
		}
		map.addAttribute(getNombreObjeto(), obj);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "editar_listado", method = RequestMethod.POST)
	public String editar_listado(ModelMap map, @Valid Caja obj,String monto) {
		try {
			logger.info("ID DE OBJ {}", obj);
			monto = monto.replaceAll("\\.", "");
			obj.setMonto(Integer.valueOf(monto));
			getDao().createOrUpdate(obj);
			logger.info("Caja Actualizada {}", obj);
			map.addAttribute("msgExito", msg.get("Registro Actualizado"));

		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
			map.addAttribute(getNombreObjeto(), obj);
		}
		agregarValoresAdicionales(map);
		return getTemplatePath();
	}

}
