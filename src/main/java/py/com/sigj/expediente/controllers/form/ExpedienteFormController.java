package py.com.sigj.expediente.controllers.form;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lowagie.text.pdf.codec.Base64;

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.ClienteDao;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.AbogadoListController;
import py.com.sigj.expediente.controllers.list.ClienteListController;
import py.com.sigj.expediente.controllers.list.ExpedienteListController;
import py.com.sigj.expediente.controllers.list.MateriaListController;
import py.com.sigj.expediente.controllers.list.MovimientoActuacionListController;
import py.com.sigj.expediente.dao.AbogadoDao;
import py.com.sigj.expediente.dao.DespachoDao;
import py.com.sigj.expediente.dao.DocumentoDao;
import py.com.sigj.expediente.dao.EstadoExternoInternoDao;
import py.com.sigj.expediente.dao.ExpedienteAbogadoDao;
import py.com.sigj.expediente.dao.ExpedienteClienteDao;
import py.com.sigj.expediente.dao.ExpedienteDao;
import py.com.sigj.expediente.dao.ExpedienteDocumentoDao;
import py.com.sigj.expediente.dao.ExpedienteFacturaDao;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.dao.MovimientoActuacionDao;
import py.com.sigj.expediente.dao.ProcesoDao;
import py.com.sigj.expediente.dao.TipoActuacionDao;
import py.com.sigj.expediente.dao.TipoDemandaDao;
import py.com.sigj.expediente.dao.TipoDocumentoDao;
import py.com.sigj.expediente.domain.Abogado;
import py.com.sigj.expediente.domain.Cliente;
import py.com.sigj.expediente.domain.Documento;
import py.com.sigj.expediente.domain.Expediente;
import py.com.sigj.expediente.domain.ExpedienteAbogado;
import py.com.sigj.expediente.domain.ExpedienteCliente;
import py.com.sigj.expediente.domain.ExpedienteDocumento;
import py.com.sigj.expediente.domain.ExpedienteFactura;
import py.com.sigj.expediente.domain.MovimientoActuacion;
import py.com.sigj.expediente.domain.TipoActuacion;
import py.com.sigj.expediente.domain.TipoDocumento;
import py.com.sigj.main.SesionUsuario;
import py.com.sigj.rrhh.dao.MovimientoExpedienteDao;
import py.com.sigj.rrhh.domain.MovimientoExpediente;
import py.com.sigj.util.RenderingInfo;
import py.com.sigj.util.WebUtils;

@Controller
@Scope("request")
@RequestMapping("expediente")
public class ExpedienteFormController extends FormController<Expediente> {

	@Autowired
	private ExpedienteDao expedienteDao;
	
	@Autowired
	private ExpedienteFacturaDao expedienteFacturaDao;

	@Autowired
	private ExpedienteAbogadoDao expedienteAbogadoDao;

	@Autowired
	private ExpedienteClienteDao expedienteClienteDao;

	@Autowired
	private ClienteListController clienteList;
	
	@Autowired
	private MovimientoActuacionListController movimientoActuacionList;

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
	private DocumentoDao documentoDao;

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
	private TipoDocumentoDao tipoDocumentoDao;

	@Autowired
	private DespachoDao despachoDao;

	@Autowired
	private TipoActuacionDao tipoActuacionDao;
	
	@Autowired
	private MovimientoActuacionDao movimientoActuacionDao;
	
	@Autowired
	private ExpedienteDocumentoDao expedienteDocumentoDao;
	
	@Autowired
	private MovimientoExpedienteDao movimientoExpedienteDao;
	
	@Autowired
	private SesionUsuario sesionUsuario;

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
		//logger.info("tipo actuacion {} ",tipoActuacionDao.getListAll(null));
		map.addAttribute("tipoDocumentoList", tipoDocumentoDao.getListAll(null));
		map.addAttribute("estadoExternoList", estadoDao.getListAll(null));
		map.addAttribute("materiaList", materiaDao.getListAll(null));
		map.addAttribute("tipoProcesoList", procesoDao.getListAll(null));
		map.addAttribute("tipoDemandaList", tipoDemandaDao.getListAll(null));
		map.addAttribute("DespachoList", despachoDao.getListAll(null));
		//logger.info("despchos {} ",despachoDao.getListAll(null) );
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
	public String guardar_listado2(HttpServletRequest request, ModelMap map, @RequestParam(value = "rd_expediente", required=false) String rdInfoAbogadoCliente) {
		HttpSession sesion = request.getSession();
		
		
		
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

			if (rdInfoAbogadoCliente == null || rdInfoAbogadoCliente.isEmpty()) {
				rdInfoAbogadoCliente = (String) sesion.getAttribute("rdInfoAbogadoCliente");
			} else if (rdInfoAbogadoCliente != null && rdInfoAbogadoCliente != "") {
				rdInfo = WebUtils.deserializeRenderingInfo(rdInfoAbogadoCliente);
				listaAbogados = (List<RenderingInfo>) rdInfo.get("abogados");
				listaCliente = (List<RenderingInfo>) rdInfo.get("clientes");
				logger.info("expediente _>{}", rdInfo.get("expediente"));
				rdExpediente = (Map<String, Object>) rdInfo.get("expediente");

				// TODO ver como registrar en despachos el expediente
				obj.setAnho((String) rdExpediente.get("anho"));
				obj.setFolio((String) rdExpediente.get("folio"));
				obj.setCaratula((String) rdExpediente.get("caratula"));
				obj.setMoneda((String) rdExpediente.get("moneda"));
				String monto = (String) rdExpediente.get("monto");
				monto = monto.replaceAll("\\.", "");
				obj.setMonto(Integer.parseInt(monto));
				obj.setNroExpediente((String) rdExpediente.get("nroExpediente"));
				String fecha = (String) rdExpediente.get("fecha");
				obj.setFechaSelloCargo(WebUtils.getDate(fecha.replace("/", "")));
				obj.setNroLiquidacion((String) rdExpediente.get("nroLiquidacion"));
				// validar el despacho
				Long id_desp = Long.parseLong((String) rdExpediente.get("despacho"));
				Long id_estado = Long.parseLong((String) rdExpediente.get("estado"));
				obj.setEstado(estadoDao.find(id_estado));
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
						Long idFormat = Long.parseLong((String) rd.get("id_cliente"));
						ec.setCliente(clienteDao.find(idFormat));
						ec.setExpediente(obj);
						ec.setTipoCliente((String) rd.get("tipo_cliente"));
						expedienteClienteDao.create(ec);
						clienteList.add(ec);

					}

				}
				logger.info("Se crea un nuevo expediente -> {}", obj);
				map.addAttribute("msgExito", msg.get("Registro agregado"));
				map.addAttribute("clienteList", clienteList);
				map.addAttribute("abogadoList", abogadoList);
				map.addAttribute("expediente", obj);
				sesion.setAttribute("expediente", obj);
				sesion.setAttribute("clienteList",clienteList);
				sesion.setAttribute("abogadoList",abogadoList );
				
			}
		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
		}		
		MovimientoActuacion ma = new MovimientoActuacion();
		agregarValoresAdicionales(map);
		map.addAttribute("movimientoActuacion", ma);
		return "expediente/expediente_section_2";

	}
	
	@RequestMapping(value = "documento", method = RequestMethod.POST)
	public String setMovimientoActuaccion(HttpServletRequest request, ModelMap map,
			@RequestParam(value = "expediente") String id_exp,
			@RequestParam(value = "titulo") String titulo,
			@RequestParam(value = "tipo_documento") String tipo_documento,
			@RequestParam("documento") MultipartFile documento) {
		HttpSession sesion = request.getSession();
		
		Expediente exp = null;
		ExpedienteDocumento expedienteDoc = new ExpedienteDocumento();
		Date fechaNow = new Date();

		try {
			if(expedienteDoc.getId() == null){
				exp = expedienteDao.find(Long.parseLong(id_exp));
				expedienteDoc.setExpediente(exp);
				
				MultipartFile multipartFile = documento;
				byte[] doc = multipartFile.getBytes();
				Documento docu = new Documento();
				docu.setDocumento(doc);
				TipoDocumento tipoDoc = tipoDocumentoDao.find(Long.parseLong(tipo_documento));
				docu.setTipoDocumento(tipoDoc);
				documentoDao.create(docu);
				docu.setDocumento(doc);
				expedienteDoc.setDocumento(docu);
				expedienteDoc.setTitulo(titulo);
				expedienteDoc.setFechaPresentacion(fechaNow);
				expedienteDocumentoDao.create(expedienteDoc);
				
				map.addAttribute("msgExito", msg.get("Registro agregado"));
				
			}			
			//logger.info("Se agregar un nuevo documento al expediente -> {}", expedienteDoc);
		} catch (Exception ex) {
			expedienteDoc.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
		}
		agregarValoresAdicionales(map);
		map.addAttribute("expedienteDocumento", expedienteDoc);
		Expediente ex = (Expediente) sesion.getAttribute("expediente");
		
		map.addAttribute("expediente", ex);
		return "expediente/expediente_section3";

	}

	
	
	@RequestMapping(value = "ver-documento", method = RequestMethod.GET)
	public String setArchivo(HttpServletRequest request, ModelMap map,
			@RequestParam(value = "expediente") String id_exp) {
		List<MovimientoActuacion> ma = null;
		try {
			MultipartFile doc = null;
			MovimientoActuacion ac = null;
			String base64String = "";
			Expediente expediente = null;
			expediente = expedienteDao.find(Long.parseLong(id_exp));
			if(expediente != null){
				List<ExpedienteAbogado> abogadoList = expedienteDao.getListByExpedienteIdAb(id_exp);
				List<ExpedienteCliente> clienteList = expedienteDao.getListByExpedienteId(id_exp);
				ma = movimientoActuacionDao.getListActuacionByExpediente(Long.parseLong(id_exp));
				if(ma!=null){
					for (MovimientoActuacion movimientoActuacion : ma) {
						if(movimientoActuacion.getDocumento()!= null){
							base64String = 	Base64.encodeBytes(movimientoActuacion.getDocumento());
							movimientoActuacion.setRenderDocumento(base64String);
						}
					}
				}
				map.addAttribute("id_expediente", id_exp);
				map.addAttribute("abogadoList", abogadoList);
				map.addAttribute("clienteList", clienteList);
				map.addAttribute("expediente", expediente);
				map.addAttribute("tipoActuacionList", tipoActuacionDao.getList(0, 100, null));
				map.addAttribute("movimiento_actuacion",ma);
				agregarValoresAdicionales(map);

			}else{
				expediente= new Expediente();
				ma = new ArrayList<>();
				map.addAttribute("movimiento_actuacion",ma);
				map.addAttribute("expediente", expediente);
			}	
		} catch (Exception e) {
			logger.info("Error {}", e);
		}
		return "expediente/actuacion_hojear" ;
	}
	
	@RequestMapping(value = "actuacion-agregar", method = RequestMethod.POST)
	public  String MovimientoAgregar(ModelMap map,HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "expediente") String id_exp,	
			@RequestParam(value = "tipo_actuacion") String tipo_actuacion,
			@RequestParam(value = "fecha_presentacion") String fecha_presentacion,
			@RequestParam(value = "fecha_vencimiento") String fecha_vencimiento,
			@RequestParam(value = "movimiento_observacion") String observacion,
			@RequestParam(value = "hora_presentacion") String hora_presentacion,
			@RequestParam(value = "documento", required=false) MultipartFile documento) throws IOException, ParseException {
		List<MovimientoActuacion> ma = null;
		String base64String = "";
		Expediente expediente = null;
		RenderingInfo rdInfo = new RenderingInfo();
		try {
			HttpSession session = request.getSession();
			session.setAttribute("currentUserName", sesionUsuario.getUsuario().getNombreRazonSocial());
			session.setAttribute("currentUserLast", sesionUsuario.getUsuario().getApellido());
			session.setAttribute("userSession", sesionUsuario);
			MovimientoActuacion ma1 = new MovimientoActuacion();
			if(documento!=null){
				MultipartFile multipartFile = documento;
				byte[] doc = multipartFile.getBytes();
				ma1.setDocumento(doc);
			}
			Expediente exp = expedienteDao.find(Long.parseLong(id_exp));
			if(exp != null){
				fecha_presentacion = fecha_presentacion.replace("/", "");
				fecha_vencimiento = fecha_vencimiento.replace("/", "");
				Calendar calendario = Calendar.getInstance();
				int hora = calendario.get(Calendar.HOUR_OF_DAY);
				int minuto = calendario.get(Calendar.MINUTE);
				int segundo = calendario.get(Calendar.SECOND);
				String tiempo = hora_presentacion+":"+String.valueOf(segundo);
				fecha_presentacion = fecha_presentacion + tiempo;
				fecha_vencimiento = fecha_vencimiento + tiempo;
				Date fe_pre = WebUtils.getDateTime(fecha_presentacion);
				Date fe_ve = WebUtils.getDateTime(fecha_vencimiento); // PASARLE CON HORA?a
				ma1.setExpediente(expedienteDao.find(Long.parseLong(id_exp)));
				ma1.setFechaPresentacion(fe_pre);
				ma1.setFechaVencimiento(fe_ve);
				ma1.setObservacion(observacion);
				ma1.setTipoActuacion(tipoActuacionDao.find(Long.parseLong(tipo_actuacion)));
				movimientoActuacionDao.create(ma1);
				
				ma = movimientoActuacionDao.getListActuacionByExpediente(Long.parseLong(id_exp));
				for (MovimientoActuacion movimientoActuacion : ma) {
					if(movimientoActuacion.getDocumento()!= null){
						base64String = 	Base64.encodeBytes(movimientoActuacion.getDocumento());
						movimientoActuacion.setRenderDocumento(base64String);
					}
				}	
				
				expediente = expedienteDao.find(Long.parseLong(id_exp));
				List<ExpedienteAbogado> abogadoList = expedienteDao.getListByExpedienteIdAb(id_exp);
				List<ExpedienteCliente> clienteList = expedienteDao.getListByExpedienteId(id_exp);
				map.addAttribute("id_expediente", id_exp);
				map.addAttribute("abogadoList", abogadoList);
				map.addAttribute("clienteList", clienteList);
				map.addAttribute("expediente", expediente);
				map.addAttribute("tipoActuacionList", tipoActuacionDao.getList(0, 200, null));
				map.addAttribute("movimiento_actuacion",ma);
				map.addAttribute("msgExito", msg.get("Actuación agregada con éxito"));
				rdInfo.add("msgExito", msg.get("Actuación agregada con éxito"));
			}else{
				expediente= new Expediente();
				ma = new ArrayList<>();
				map.addAttribute("movimiento_actuacion",ma);
				map.addAttribute("expediente", expediente);
			}	
		} catch (Exception e) {
			map.addAttribute("Error al agregar la actuación", "Error al agregar la actuación");
			rdInfo.add("error", msg.get("Error al agregar la actuación", "Error al agregar la actuación"));
		}		
		return "expediente/actuacion_hojear2"; //modificar luego	
		
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public String buscar(HttpServletRequest request, ModelMap map) {
		map.addAttribute("despachoList", despachoDao.getListAll(null));
		map.addAttribute("abogadoList", abogadoDao.getListAll(null));
		map.addAttribute("estadoList", estadoDao.getListAll(null));
		return "expediente/buscar_expediente";
	}
	
	
	@RequestMapping(value = "buscar-resultado", method = RequestMethod.GET)
	public String buscar_seccion2(HttpServletRequest request, ModelMap map,
			@RequestParam(value = "anho") String anho,
			@RequestParam(value = "estado") String estado,
			@RequestParam(value = "despacho_buscar") String despacho,
			@RequestParam(value = "abogado") String abogado,
			@RequestParam(value = "nro_expediente") String nroExpediente) {
			List<Expediente> nRepetidos = new ArrayList<>();
			List<Expediente> expediente = expedienteDao.filtro(nroExpediente,abogado,despacho,estado,anho);
			Long id_expediente = null;
			if(expediente != null && !expediente.isEmpty()){ //control de repetidos
				nRepetidos.add(expediente.get(0));
				for (int i = 1; i < expediente.size(); i++) {
					boolean band = true;
					id_expediente = expediente.get(i).getId();
					for (int j = 0; j < nRepetidos.size(); j++) {
						if(id_expediente == nRepetidos.get(j).getId()){
							logger.info("Encontro repetido");
							band=false;
							break;
						}
					}
					if(band){ // si no encontro repetidos agrega en la lista
						nRepetidos.add(expediente.get(i));
						band = true;
					}
				}
			}
			
			
			String aux = "";
			if(nRepetidos == null || nRepetidos.isEmpty()){
				aux = "null";
			}else{
				aux = (nRepetidos.get(0).getNroExpediente() == null)?"expediente_abogado":"expediente";
			}
			
			map.addAttribute("expedienteList",nRepetidos);
			map.addAttribute("aux", aux);
		return "expediente/buscar_expediente :: expedienteList";
	}



	@RequestMapping(value = "/buscar-parte", method = RequestMethod.GET)
	public String buscar_parte(HttpServletRequest request, ModelMap map,
			@RequestParam(value = "search") String search,
			@RequestParam(value = "tipo_parte") String tipoParte) {
		if("C".equals(tipoParte.toUpperCase())){
			List<Cliente> listParte = expedienteDao.buscarParteCliente(search);
			
			map.addAttribute("listParte", listParte);
			map.addAttribute("tipoParte", tipoParte);
		}else if ("A".equals(tipoParte.toUpperCase())){
			List<Abogado> listParte = expedienteDao.buscarParteAbogado(search);
			
			map.addAttribute("listParte", listParte);
			map.addAttribute("tipoParte", tipoParte);
		}else{
			map.addAttribute("listParte", null);
			map.addAttribute("tipoParte", null);
		}
		
		return "expediente/expediente_resultado";
	}

	
	@RequestMapping(value = "hojar-expediente/{id}", method = RequestMethod.GET)
	public String getExpedienteDigital(HttpServletRequest request, ModelMap map,@PathVariable Long id){
		try {
			MultipartFile doc = null;
			MovimientoActuacion ac = null;
			String id_exp = String.valueOf(id);
			String base64String = "";
			String base64String1 = "";
			List<String> base64StringList = new ArrayList<String>();
			List<String> base64StringList1 = new ArrayList<String>();
			List<MovimientoActuacion> listExpDoc = expedienteDocumentoDao.getListByExpedienteActuacion(id_exp);
			List<ExpedienteDocumento> listExpDoc1 = expedienteDocumentoDao.getListByExpedienteDocumento(id_exp);
			logger.info("listado ..{}",listExpDoc);
				if(listExpDoc != null && !listExpDoc.isEmpty()){
					for (MovimientoActuacion movimientoActuacion : listExpDoc) {
						base64String = 	Base64.encodeBytes(movimientoActuacion.getDocumento());
						base64StringList.add(base64String);
					}
				}
				
				if(listExpDoc1 != null && !listExpDoc1.isEmpty()){
					for (ExpedienteDocumento movimientoActuacion : listExpDoc1) {
						base64String = 	Base64.encodeBytes(movimientoActuacion.getDocumento().getDocumento());
						base64StringList.add(base64String);
					}
				}
				
				map.addAttribute("actuacionList",base64StringList);
				map.addAttribute("documentoList",base64StringList1);
				//logger.info("Listado de actuaciones listExpDoc->{}", listExpDoc);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "expediente/expediente_digital";
		
		
	}
	@RequestMapping(value = "/fecha-vencimiento", method = RequestMethod.GET)
	public  String fecha(HttpServletRequest request,
			@RequestParam(value = "actuacion", required = true) String actuacion_id,
			@RequestParam(value = "fecha", required = true) Date fecha,ModelMap map) throws Exception{
			Long id_actuacion = Long.parseLong(actuacion_id);
			Calendar calendar = Calendar.getInstance();
			Date fecha_aux = new Date();
			String fecha_prue="";
			if(fecha == null || id_actuacion == 0){
				return "";
			}else{
				List<String> feriados = new ArrayList<>();
				feriados.add("01/01");
				feriados.add("01/03");
				feriados.add("01/05");
				feriados.add("14/05");
				feriados.add("15/05");
				feriados.add("12/06");
				feriados.add("15/08");
				feriados.add("29/09");
				feriados.add("08/12");
				feriados.add("25/12");
				TipoActuacion ta = tipoActuacionDao.find(Long.parseLong(actuacion_id));
				calendar.setTime(fecha);
				String aux1 = "";
				 calendar.add(Calendar.DAY_OF_YEAR, ta.getPlazo());
				 fecha_aux = calendar.getTime();
				 SimpleDateFormat f = new SimpleDateFormat("EEEE", new Locale("ES"));
				 String nombre_dia = f.format(calendar.getTime());
				 if(nombre_dia.equalsIgnoreCase("domingo")){
					 calendar.setTime(fecha_aux);
					 calendar.add(Calendar.DAY_OF_YEAR,1 );
				 }else if(nombre_dia.equalsIgnoreCase("sábado")){
					 calendar.setTime(fecha_aux);
					 calendar.add(Calendar.DAY_OF_YEAR,2 );
				 }else{
					 fecha_prue = WebUtils.getStringFromDate(calendar.getTime(), "dd/MM/yyyy");
					 fecha_aux = calendar.getTime();
					 calendar.setTime(fecha_aux);
					 aux1 = fecha_prue.substring(0, 5);
					 for(String i : feriados){
						 if(i.equals(aux1)){
							 calendar.add(Calendar.DAY_OF_YEAR,1);
							 break;
							 
						 }
					 }
				 }
				 fecha_prue = WebUtils.getStringFromDate(calendar.getTime(), "dd/MM/yyyy");
				map.addAttribute("fecha_ven", fecha_prue);
			}
			return "expediente/actuacion_hojear :: .fecha-venc2";
	}
	
	@RequestMapping(value = "/buscar-actuacion", method = RequestMethod.GET)
	public  String buscar_actuacion(HttpServletRequest request,ModelMap map) throws Exception{
		
		return "expediente/buscar_actuacion";
	}
	@RequestMapping(value = "buscar-actuacion-resultado", method = RequestMethod.GET)
	public  String buscar_actuacion_resultado(HttpServletRequest request,ModelMap map,
			@RequestParam(value = "fecha_presentacion", required = false) String fecha_presentacion,
			@RequestParam(value = "fecha_vencimiento", required = false) String fecha_vencimiento) throws Exception{
		
		//List<MovimientoActuacion> ma = movimientoActuacionDao.busqueda_fechas(fecha_presentacion,fecha_vencimiento);
		List<MovimientoActuacion> ma = movimientoActuacionDao.getListAll(null);
		List<MovimientoActuacion> mr = new ArrayList<>();
		List<MovimientoActuacion> nRepetidos = new ArrayList<>();
		Long nroExpediente = null;
		String base64String = "";
		if(!fecha_presentacion.equals("") && fecha_vencimiento.equals("")){
			for(MovimientoActuacion m : ma){
				String aux = WebUtils.getStringFromDate(m.getFechaPresentacion(), "dd/MM/yyyy");
				if(aux.equals(fecha_presentacion)){
					if(m.getDocumento() !=null){
						base64String = 	Base64.encodeBytes(m.getDocumento());
						m.setRenderDocumento(base64String);
					}
					mr.add(m);
				}
			}	
					if(mr != null && !mr.isEmpty()){ //control de repetidos
						nRepetidos.add(mr.get(0));
						for (int i = 1; i < mr.size(); i++) {
							boolean band = true;
							nroExpediente = mr.get(i).getExpediente().getId();
							for (int j = 0; j < nRepetidos.size(); j++) {
								if(nroExpediente == nRepetidos.get(j).getExpediente().getId()){
									logger.info("Encontro repetido");
									band=false;
									break;
								}
							}
							if(band){ // si no encontro repetidos agrega en la lista
								nRepetidos.add(mr.get(i));
								band = true;
							}
						}
					}
				
			
		}
		else if(fecha_presentacion.equals("") && !fecha_vencimiento.equals("")){
			for(MovimientoActuacion m : ma){
				String aux = WebUtils.getStringFromDate(m.getFechaVencimiento(), "dd/MM/yyyy");
				if(aux.equals(fecha_vencimiento)){
					if(m.getDocumento() != null){
						base64String = 	Base64.encodeBytes(m.getDocumento());
						m.setRenderDocumento(base64String);
					}
					mr.add(m);
				}
			}	
					if(mr != null && !mr.isEmpty()){ //control de repetidos
						nRepetidos.add(mr.get(0));
						for (int i = 1; i < mr.size(); i++) {
							boolean band = true;
							nroExpediente = mr.get(i).getExpediente().getId();
							for (int j = 0; j < nRepetidos.size(); j++) {
								if(nroExpediente == nRepetidos.get(j).getExpediente().getId()){
									logger.info("Encontro repetido");
									band=false;
									break;
								}
							}
							if(band){ // si no encontro repetidos agrega en la lista
								nRepetidos.add(mr.get(i));
								band = true;
							}
						}
					}
		}else if(!fecha_presentacion.equals("") && !fecha_vencimiento.equals("")){
			
			
			for(MovimientoActuacion m : ma){
				String aux1 = WebUtils.getStringFromDate(m.getFechaPresentacion(), "dd/MM/yyyy");
				String aux2 = WebUtils.getStringFromDate(m.getFechaVencimiento(), "dd/MM/yyyy");
				if(aux1.equals(fecha_presentacion) && aux2.equals(fecha_vencimiento)){
					if(m.getDocumento() != null){
						base64String = 	Base64.encodeBytes(m.getDocumento());
						m.setRenderDocumento(base64String);
					}
					mr.add(m);
				}
			}	
			if(mr != null && !mr.isEmpty()){ //control de repetidos
				nRepetidos.add(mr.get(0));
				for (int i = 1; i < mr.size(); i++) {
					boolean band = true;
					nroExpediente = mr.get(i).getExpediente().getId();
					for (int j = 0; j < nRepetidos.size(); j++) {
						if(nroExpediente == nRepetidos.get(j).getExpediente().getId()){
							logger.info("Encontro repetido");
							band=false;
							break;
						}
					}
					if(band){ // si no encontro repetidos agrega en la lista
						nRepetidos.add(mr.get(i));
						band = true;
					}
				}
			}
						
						
					
					
			
		}
		if(nRepetidos == null || nRepetidos.isEmpty()){
			map.addAttribute("vacio", "si");
		}else{
			map.addAttribute("vacio", "no");
		}
		
		map.addAttribute("actuacionList", nRepetidos);
		return "expediente/buscar_actuacion_resultado";
	}
	
	@RequestMapping(value = "consultar-montos", method = RequestMethod.GET)
	public  String consultarMontos(HttpServletRequest request,ModelMap map){
		map.addAttribute("expedienteList", expedienteDao.getListAll(null));
		return "expediente/consultar_montos";
	}
	
	@RequestMapping(value = "consultar-montos-resultado", method = RequestMethod.GET)
	public  String consultarMontosResultado(HttpServletRequest request,ModelMap map,
			@RequestParam(value = "id_expediente", required = true) String id_expediente) throws Exception{
		List<MovimientoExpediente> me = movimientoExpedienteDao.findExpediente(Long.parseLong(id_expediente));
		List<ExpedienteFactura> ef = expedienteFacturaDao.findFactura(Long.parseLong(id_expediente));
		int ingreso = 0;
		int egreso = 0;
		int factura = 0;
		for (MovimientoExpediente movimientoExpediente : me) {
			ingreso += movimientoExpediente.getMovimiento().getIngreso();
			egreso += movimientoExpediente.getMovimiento().getEgreso();
		}
		
		for (ExpedienteFactura expedienteFactura : ef) {
			factura =+ expedienteFactura.getFactura().getMontoTotal();
		}
		map.addAttribute("total_ingreso", ingreso);
		map.addAttribute("total_egreso", egreso);
		map.addAttribute("total_factura", factura);
		map.addAttribute("expedienteList", me);
		map.addAttribute("expediente_id", id_expediente);
		return "expediente/consultar_montos_resultado";
	}
	
}
