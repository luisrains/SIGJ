package py.com.sigj.expediente.controllers.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import py.com.sigj.controllers.list.ListController;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.dao.PersonaDao;
import py.com.sigj.expediente.domain.Persona;
import py.com.sigj.main.DataTable;

@Controller
@Scope("session")
@RequestMapping("persona")
public class PersonaListController extends ListController<Persona> {

	@Autowired
	private PersonaDao personaDao;

	@Override
	public String[] getColumnas() {
		return new String[] { "id", "cedula_ruc", "nombre_razonSocial", "apellido", "fechaNacimiento", "edad", "sexo",
				"correoElectronico", "telefono"};
	}

	@Override
	public Dao<Persona> getDao() {
		return personaDao;
	}
	
	@RequestMapping(value = "json", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	// required=false es opcional el parametro de la url
	public DataTable<Persona> json(@RequestParam(required = false) String sSearch,
			@RequestParam(required = false, defaultValue = "0") Integer iDisplayStart,
			@RequestParam(required = false, defaultValue = "10") Integer iDisplayLength) {

		logger.info("json?sSearch={}, iDisplayStart={}, iDisplayLength={}",
				new Object[] { sSearch, iDisplayStart, iDisplayLength });

		try {
			DataTable<Persona> dt = new DataTable<>();
			List<Persona> list = personaDao.listaPersonas(iDisplayStart, iDisplayStart + iDisplayLength, sSearch);
			Long size = Long.valueOf(list.size());
			dt.setRecordsTotal(size);
			dt.setAaData(list);
			return dt;
		} catch (Exception ex) {
			logger.error("No se pudo obtener lista", ex);
			return new DataTable<>();
		}
	}

}
