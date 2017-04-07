package py.com.sigj.gastos.controllers.form;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.gastos.controllers.list.FacturaCabeceraListController;
import py.com.sigj.gastos.dao.FacturaCabeceraDao;
import py.com.sigj.gastos.domain.FacturaCabecera;

/**
 *
 * @author ariquelme
 *
 */

@Controller
@Scope("request")
@RequestMapping("factura_cabecera")
public class FacturaCabeceraFormController extends FormController<FacturaCabecera> {

	@Autowired
	private FacturaCabeceraDao facturaCabeceraDao;

	@Autowired
	private FacturaCabeceraListController facturaCabeceraList;

	@Override
	public String getTemplatePath() {
		return "gastos/factura_cabecera_index";
	}

	@Override
	public String getNombreObjeto() {
		return "facturaCabecera";
	}

	@Override
	public FacturaCabecera getNuevaInstancia() {
		return new FacturaCabecera();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", facturaCabeceraList.getColumnas());
		map.addAttribute("columnasStr", facturaCabeceraList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}
	@RequestMapping(value = "/factura", method = RequestMethod.GET)
	public String generarFactura(ModelMap map, @RequestParam(value = "factura_cabecera", required = true) String facturaCabecera,
			@RequestParam(value = "factura_detalle", required = true) String facturaDetalle) throws JsonParseException, JsonMappingException, IOException{
			
			logger.info(facturaCabecera);
			logger.info(facturaDetalle);
			HashMap<String,Object> result =
			        new ObjectMapper().readValue(facturaCabecera, HashMap.class);
			logger.info("El hash map");
			logger.info(String.valueOf(result));
		return "";
	}
	@Override
	public Dao<FacturaCabecera> getDao() {
		return facturaCabeceraDao;
	}

}
