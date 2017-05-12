package py.com.sigj.expediente.controllers.form;

import java.util.Date;
import java.util.List;

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

import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.ClienteDao;
import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.controllers.list.AbogadoListController;
import py.com.sigj.expediente.controllers.list.ActuacionListController;
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
import py.com.sigj.expediente.dao.ProcesoDao;
import py.com.sigj.expediente.dao.TipoDemandaDao;
import py.com.sigj.expediente.domain.Expediente;
import py.com.sigj.expediente.domain.ExpedienteAbogado;
import py.com.sigj.expediente.domain.ExpedienteCliente;
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
	private ActuacionListController actuacionList;

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

	// @Autowired
	// private DocumentoDao documentoDao;

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
		map.addAttribute("columnasStrActuacion", expedienteList.getColumnasStr(actuacionList.getColumnas()));

		map.addAttribute("estadoExternoList", estadoDao.getListAll(null));
		map.addAttribute("materiaList", materiaDao.getListAll(null));
		map.addAttribute("tipoProcesoList", procesoDao.getListAll(null));
		map.addAttribute("tipoDemandaList", tipoDemandaDao.getListAll(null));
		map.addAttribute("DespachoList", despachoDao.getListAll(null));
		map.addAttribute("DespachoList", despachoDao.getListAll(null));

		map.addAttribute("columnasMateria", materiaList.getColumnas());
		map.addAttribute("columnasStrMateria", materiaList.getColumnasStr(materiaList.getColumnas()));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<Expediente> getDao() {
		return expedienteDao;
	}

	@RequestMapping(value = "accion2", method = RequestMethod.POST)
	public String accion2(ModelMap map, @Valid Expediente obj,
			@RequestParam(value = "abogado", required = false) String abogado, BindingResult bindingResult,
			@RequestParam(required = false) String accion, HttpServletRequest request,
			@RequestParam(value = "id_objeto", required = false) Long id_objeto) {

		if (StringUtils.equals(accion, "save")) {
			return guardar_listado(map, abogado, bindingResult, request);
		} else if (StringUtils.equals(accion, "edit")) {
			logger.info("OBJETO PROCESO {}", obj);
			// return editar_listado(map, abogado, obj, bindingResult, request);
		} else if (id_objeto != null) {
			// return eliminar_listado(map, id_objeto);

		}
		return getTemplatePath();

	}

	// recibimos una lista de abogados y clientes como un vector de string en
	// este formato
	// { "mapa": {"abogados" : [ { "id_abogado":"12", "tipo_abogado":"A" } ],
	// "clientes": [ { "id_cliente":"2", "tipo_cliente":"D" } ] } }
	@RequestMapping(value = "save_listado", method = RequestMethod.GET)
	public String guardar_listado(ModelMap map, @RequestParam(value = "rd_expediente") String rdInfoAbogadoCliente,
			BindingResult bindingResult, HttpServletRequest request) {
		Expediente obj = null;
		// rdInfoAbogadoCliente = "{ 'mapa': {'abogados' : [ {
		// 'id_abogado':'12', 'tipo_abogado':'A' } ],'clientes': [ {
		// 'id_cliente':'2', 'tipo_cliente':'D' } ] } }";
		try {

			HttpSession session = request.getSession();
			RenderingInfo rdInfo = null;
			if (rdInfoAbogadoCliente != null && rdInfoAbogadoCliente != "") {

				rdInfo = WebUtils.deserializeRenderingInfo(rdInfoAbogadoCliente);

				List<RenderingInfo> listaAbogados = (List<RenderingInfo>) rdInfo.get("abogados");
				List<RenderingInfo> listaCliente = (List<RenderingInfo>) rdInfo.get("clientes");

			}

			// fake
			obj.setAnho("20170");
			obj.setCaratula("ninguno");
			// obj.setFechaSelloCargo("25-02-2017");
			obj.setFolio("21");
			obj.setMoneda("gs");
			obj.setMonto(10000);
			obj.setNroExpediente("402");
			obj.setNroLiquidación("154654");
			List<String> abogados = null;
			List<String> cliente = null;
			if (obj.getId() == null && abogados != null) {
				getDao().create(obj);
				for (String s : abogados) {
					ExpedienteAbogado ea = new ExpedienteAbogado();
					Long idFormat = Long.parseLong(s);
					ea.setAbogado(abogadoDao.find(idFormat));
					ea.setExpediente(obj);
					ea.setTipoAbogado("t");
					expedienteAbogadoDao.create(ea);

				}
			}
			if (cliente != null) {

				for (String s : cliente) {
					ExpedienteAbogado ea = new ExpedienteAbogado();
					Long idFormat = Long.parseLong(s);
					ea.setAbogado(abogadoDao.find(idFormat));
					ea.setExpediente(obj);
					ea.setTipoAbogado("t");
					expedienteAbogadoDao.create(ea);

				}

			}

			map.addAttribute("msgExito", msg.get("Registro agregado"));
			logger.info("Se crea un nuevo Rol -> {}", obj);
		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
		}
		map.addAttribute(getNombreObjeto(), obj);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}

	@RequestMapping(value = "save_listado2", method = RequestMethod.GET)
	public String guardar_listado2(ModelMap map, @RequestParam(value = "rd_expediente") String rdInfoAbogadoCliente) {
		Expediente obj = new Expediente();
		// rdInfoAbogadoCliente = "{ 'mapa': {'abogados' : [ {
		// 'id_abogado':'12', 'tipo_abogado':'A' } ],'clientes': [ {
		// 'id_cliente':'2', 'tipo_cliente':'D' } ] } }";
		try {
			// fake

			obj.setAnho("20170");
			obj.setCaratula("ninguno");
			// obj.setFechaSelloCargo("25-02-2017");
			obj.setFolio("21");
			obj.setMoneda("gs");
			obj.setMonto(10000);
			obj.setNroExpediente("402");
			obj.setNroLiquidación("154654");

			// HttpSession session = request.getSession();
			RenderingInfo rdInfo = null;
			RenderingInfo rdExpediente = null;
			List<String> abogados = null;
			List<String> cliente = null;
			if (rdInfoAbogadoCliente != null && rdInfoAbogadoCliente != "" && rdExpediente != null) {
				rdInfo = WebUtils.deserializeRenderingInfo(rdInfoAbogadoCliente);
				rdExpediente = (RenderingInfo) rdInfo.get("expediente");
			}
			// TODO ver como registrar en despachos el expediente
			obj.setAnho((String) rdExpediente.get("anho"));
			obj.setFolio((String) rdExpediente.get("folio"));
			obj.setCaratula((String) rdExpediente.get("caratula"));
			obj.setMoneda((String) rdExpediente.get("moneda"));
			obj.setMonto((int) rdExpediente.get("monto"));
			obj.setNroExpediente((String) rdExpediente.get("nroExpediente"));
			obj.setFechaSelloCargo((Date) rdExpediente.get("fecha"));
			obj.setNroLiquidación((String) rdExpediente.get("nroLiquidación"));

			List<RenderingInfo> listaAbogados = (List<RenderingInfo>) rdInfo.get("abogados");
			List<RenderingInfo> listaCliente = (List<RenderingInfo>) rdInfo.get("clientes");
			if (obj.getId() == null && listaAbogados != null) {
				getDao().create(obj);
				for (RenderingInfo rd : listaAbogados) {
					ExpedienteAbogado ea = new ExpedienteAbogado();
					Long idFormat = (Long) rd.get("id_abogado");
					ea.setAbogado(abogadoDao.find(idFormat));
					ea.setExpediente(obj);
					ea.setTipoAbogado((String) rd.get("tipo_abogado"));
					expedienteAbogadoDao.create(ea);
				}
			}
			if (listaCliente != null) {

				for (RenderingInfo rd : listaCliente) {
					ExpedienteCliente ec = new ExpedienteCliente();
					Long idFormat = (Long) rd.get("id_cliente");
					ec.setCliente(clienteDao.find(idFormat));
					ec.setExpediente(obj);
					ec.setTipoCliente((String) rd.get("tipo_cliente"));
					expedienteClienteDao.create(ec);

				}

			}

			map.addAttribute("msgExito", msg.get("Registro agregado"));
			logger.info("Se crea un nuevo Rol -> {}", obj);
		} catch (Exception ex) {
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));
		}
		map.addAttribute(getNombreObjeto(), obj);
		agregarValoresAdicionales(map);
		return getTemplatePath();

	}
	/*
	 * @RequestMapping(value = "editar_listado", method = RequestMethod.POST)
	 * public String editar_listado(ModelMap map, @RequestParam("selec")
	 * List<String> abogado, @Valid Expediente obj, BindingResult bindingResult,
	 * HttpServletRequest request) { try { HttpSession session =
	 * request.getSession(); List<Abogado> list = new ArrayList<Abogado>();
	 * logger.info("ID DE OBJ {}", obj); if (obj != null && abogado != null) {
	 * list = permisoDao.ListByRol(obj); for (abogado p : list) { RolPermiso rp
	 * = new RolPermiso(); rp = rolPermisoDao.eliminarPorPermiso(obj.getId(),
	 * p.getId()); rolPermisoDao.destroy(rp); } for (String idLong : abogado) {
	 * RolPermiso rp = new RolPermiso(); rp.setRol(obj); Long idFormat =
	 * Long.parseLong(idLong); rp.setPermiso(permisoDao.find(idFormat));
	 *
	 * rolPermisoDao.create(rp); } } List<Abogado> listAbogado = new
	 * ArrayList<Abogado>(); for (String s : abogado) { Long idFormat =
	 * Long.parseLong(s); listAbogado.add(permisoDao.find(idFormat)); }
	 * obj.setListPermiso(listAbogado); getDao().createOrUpdate(obj);
	 * logger.info("Rol Actualizado {}", obj);
	 *
	 * map.addAttribute("msgExito", msg.get("Registro Actualizado"));
	 *
	 * } catch (Exception ex) { obj.setId(null); map.addAttribute("error",
	 * getErrorFromException(ex)); map.addAttribute(getNombreObjeto(), obj); }
	 * agregarValoresAdicionales(map); return getTemplatePath(); }
	 *
	 * @RequestMapping(value = "eliminar_listado", method = RequestMethod.POST)
	 * public String eliminar_listado(ModelMap map, @RequestParam("id_objeto")
	 * Long id_objeto) { List<Abogado> list = new ArrayList<Abogado>(); Rol rol
	 * = null; try { logger.info("ID DE OBJ {}", id_objeto); if (id_objeto !=
	 * null) { rol = getDao().find(id_objeto); List<RolPermiso> rp =
	 * rolPermisoDao.eliminarPorRol(rol.getId()); for (RolPermiso rpp : rp) {
	 * rolPermisoDao.destroy(rpp); }
	 *
	 * getDao().destroy(rol);
	 *
	 * logger.info("Rol eliminado {}", rol); map.addAttribute("msgExito",
	 * msg.get("Registro Eliminado")); } } catch (UnexpectedRollbackException
	 * ex) { rol.setId(null); map.addAttribute("error",
	 * "No puede borrar un rol ya que un abogado hace referencia a él.");
	 * map.addAttribute(getNombreObjeto(), rol); }
	 * map.addAttribute(getNombreObjeto(), getNuevaInstancia());
	 * agregarValoresAdicionales(map); return getTemplatePath();
	 *
	 * }
	 */

}
