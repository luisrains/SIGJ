package py.com.sigj.expediente.controllers.form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.ClienteDao;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.AbogadoListController;
import py.com.sigj.expediente.controllers.list.MovimientoActuacionListController;
import py.com.sigj.expediente.controllers.list.ClienteListController;
import py.com.sigj.expediente.controllers.list.ExpedienteListController;
import py.com.sigj.expediente.controllers.list.MateriaListController;
import py.com.sigj.expediente.dao.AbogadoDao;
import py.com.sigj.expediente.dao.DespachoDao;
import py.com.sigj.expediente.dao.EstadoExternoInternoDao;
import py.com.sigj.expediente.dao.ExpedienteAbogadoDao;
import py.com.sigj.expediente.dao.ExpedienteClienteDao;
import py.com.sigj.expediente.dao.ExpedienteDao;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.dao.MovimientoActuacionDao;
import py.com.sigj.expediente.dao.ProcesoDao;
import py.com.sigj.expediente.dao.TipoActuacionDao;
import py.com.sigj.expediente.dao.TipoDemandaDao;
import py.com.sigj.expediente.domain.Expediente;
import py.com.sigj.expediente.domain.ExpedienteAbogado;
import py.com.sigj.expediente.domain.ExpedienteCliente;
import py.com.sigj.expediente.domain.MovimientoActuacion;
import py.com.sigj.expediente.domain.TipoActuacion;
import py.com.sigj.util.RenderingInfo;
import py.com.sigj.util.WebUtils;

@Controller
@Scope("request")
@RequestMapping("expediente")
public class ExpedienteFormController extends FormController<Expediente> {

	@Autowired
	private ExpedienteDao expedienteDao;

	@Autowired
	private ExpedienteAbogadoDao expedienteAbogadoDao;

	@Autowired
	private ExpedienteClienteDao expedienteClienteDao;

	@Autowired
	private ClienteListController clienteList;

	@Autowired
	private ExpedienteListController expedienteList;

	@Autowired
	private MovimientoActuacionListController actuacionList;

	@Autowired
	private AbogadoListController abogadoList;

	@Autowired
	private AbogadoDao abogadoDao;

	@Autowired
	private ClienteDao clienteDao;

	@Autowired
	private MateriaDao materiaDao;

	@Autowired
	private MateriaListController materiaList;

	@Autowired
	private ProcesoDao procesoDao;

	@Autowired
	private EstadoExternoInternoDao estadoDao;

	@Autowired
	private TipoDemandaDao tipoDemandaDao;

	@Autowired
	private DespachoDao despachoDao;

	@Autowired
	private TipoActuacionDao tipoActuacionDao;
	
	@Autowired
	private MovimientoActuacionDao movimientoActuacionDao;

	@Override
	public String getTemplatePath() {
		return "expediente/expediente_index";
	}

	@Override
	public String getNombreObjeto() {
		return "expediente";
	}

	@Override
	public Expediente getNuevaInstancia() {
		return new Expediente();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("expedienteList", expedienteDao.getList(0, 20, null));
		map.addAttribute("columnas", expedienteList.getColumnas());
		map.addAttribute("columnasActuacion", actuacionList.getColumnas());
		map.addAttribute("columnasClient", clienteList.getColumnas());
		map.addAttribute("columnasAbogado", abogadoList.getColumnasForExpediente());
		map.addAttribute("columnasStr", expedienteList.getColumnasStr(null));
		map.addAttribute("columnasStrClient", clienteList.getColumnasStr(null));
		map.addAttribute("columnasStrAbogado", abogadoList.getColumnasStr(abogadoList.getColumnasForExpediente()));
		map.addAttribute("tipoActuacionList", tipoActuacionDao.getListAll(null));
		//map.addAttribute("columnasStrActuacion", expedienteList.getColumnasStr(actuacionList.getColumnas()));

		map.addAttribute("estadoExternoList", estadoDao.getListAll(null));
		map.addAttribute("materiaList", materiaDao.getListAll(null));
		map.addAttribute("tipoProcesoList", procesoDao.getListAll(null));
		map.addAttribute("tipoDemandaList", tipoDemandaDao.getListAll(null));
		map.addAttribute("DespachoList", despachoDao.getListAll(null));
		logger.info("despchos {} ",despachoDao.getListAll(null) );
		map.addAttribute("columnasMateria", materiaList.getColumnas());
		map.addAttribute("columnasStrMateria", materiaList.getColumnasStr(materiaList.getColumnas()));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Expediente> getDao() {
		return expedienteDao;
	}


	/**
	 * recibe un RenderingInfo a ser deszerializado Example:
	 * rdInfoAbogadoCliente = "{ 'mapa': {'abogados' : [ { 'id_abogado':'12',
	 * 'tipo_abogado':'A' } ],'clientes': [ { 'id_cliente':'2',
	 * 'tipo_cliente':'D' } ] } }";
	 *
	 * @param map
	 * @param String
	 * @param RenderingInfo
	 * @return String
	 */
	@RequestMapping(value = "save_listado2", method = RequestMethod.GET)
	public String guardar_listado2(ModelMap map, @RequestParam(value = "rd_expediente") String rdInfoAbogadoCliente) {
		Expediente obj = new Expediente();
		List<RenderingInfo> listaAbogados = null;
		List<RenderingInfo> listaCliente = null;
		List<ExpedienteAbogado> abogadoList = new ArrayList<>();
		List<ExpedienteCliente> clienteList = new ArrayList<>();
		
		try {
			RenderingInfo rdInfo = null;
			Map<String, Object> rdExpediente = null;
			List<String> abogados = null;
			List<String> cliente = null;
			if (rdInfoAbogadoCliente != null && rdInfoAbogadoCliente != "") {
				rdInfo = WebUtils.deserializeRenderingInfo(rdInfoAbogadoCliente);
				listaAbogados = (List<RenderingInfo>) rdInfo.get("abogados");
				listaCliente = (List<RenderingInfo>) rdInfo.get("clientes");
				logger.info("expediente _>{}", rdInfo.get("expediente"));
				rdExpediente = (Map<String, Object>) rdInfo.get("expediente");
			}
			// TODO ver como registrar en despachos el expediente
			obj.setAnho((String) rdExpediente.get("anho"));
			obj.setFolio((String) rdExpediente.get("folio"));
			obj.setCaratula((String) rdExpediente.get("caratula"));
			obj.setMoneda((String) rdExpediente.get("moneda"));
			String monto = (String) rdExpediente.get("monto");
			monto = monto.replaceAll("\\.", "");
			obj.setMonto(Integer.parseInt(monto));
			obj.setNroExpediente((String) rdExpediente.get("nroExpediente"));
			String fecha = (String)rdExpediente.get("fecha");
			obj.setFechaSelloCargo(WebUtils.getDate(fecha.replace("/", "")));
			obj.setNroLiquidacion((String) rdExpediente.get("nroLiquidación"));
			// validar el despacho
			Long id_desp = (Long) Long.parseLong((String)rdExpediente.get("despacho"));
			obj.setDespachoActual(despachoDao.find(id_desp));

			if (obj.getId() == null && listaAbogados != null) {
				getDao().create(obj);
				
				for (int i = 0; i < listaAbogados.size(); i++) {
					Map<String, Object> rd = (Map<String, Object>) listaAbogados.get(i);
					ExpedienteAbogado ea = new ExpedienteAbogado();
					Long idFormat = Long.parseLong((String) rd.get("id_abogado"));
					ea.setAbogado(abogadoDao.find(idFormat));
					ea.setExpediente(obj);
					ea.setTipoAbogado((String) rd.get("tipo_abogado"));
					expedienteAbogadoDao.create(ea);
					abogadoList.add(ea);
				}

			}
			if (listaCliente != null) {
				for (int i = 0; i < listaCliente.size(); i++) {
						Map<String, Object> rd = (Map<String, Object>) listaCliente.get(i);
					ExpedienteCliente ec = new ExpedienteCliente();
					Long idFormat = Long.parseLong((String)rd.get("id_cliente"));
					ec.setCliente(clienteDao.find(idFormat));
					ec.setExpediente(obj);
					ec.setTipoCliente((String) rd.get("tipo_cliente"));
					expedienteClienteDao.create(ec);
					clienteList.add(ec);

				}

			}

			map.addAttribute("msgExito", msg.get("Registro agregado"));
			map.addAttribute("clienteList",clienteList );
			map.addAttribute("abogadoList",abogadoList );
			
			
			logger.info("Se crea un nuevo expediente -> {}", obj);
		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
		}
		MovimientoActuacion ma = new MovimientoActuacion();
		agregarValoresAdicionales(map);
		map.addAttribute("expediente", obj);
		map.addAttribute("movimientoActuacion", ma);
		return "expediente/expediente_section_2";

	}
	
	@RequestMapping(value = "actuacion", method = RequestMethod.POST)
	public String setArchivo(ModelMap map,@Valid MovimientoActuacion actuacion, BindingResult bindingResult,
			@RequestParam(required = false) String id_expediente) {
			Expediente exp = null;
			MovimientoActuacion mov = new MovimientoActuacion();

		try {
			if(actuacion.getId() == null){
				exp = expedienteDao.find(Long.parseLong(id_expediente));
				actuacion.setExpediente(exp);
				movimientoActuacionDao.create(actuacion);
				map.addAttribute("msgExito", msg.get("Registro agregado"));
			}			
			
			
			
			
			logger.info("Se crea un nuevo movimiento actuacion -> {}", actuacion);
		} catch (Exception ex) {
			mov.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
		}
		agregarValoresAdicionales(map);
		map.addAttribute("movmientoActuacion", mov);
		return "expediente/expediente_section_2";

	}


}
