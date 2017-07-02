package py.com.sigj.rrhh.controllers.form;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import py.com.sigj.controllers.form.FormController;
import py.com.sigj.dao.Dao;
import py.com.sigj.rrhh.controllers.list.PlanillaSalarioListController;
import py.com.sigj.rrhh.dao.EmpleadoDao;
import py.com.sigj.rrhh.dao.MovimientoDao;
import py.com.sigj.rrhh.dao.PlanillaSalarioDao;
import py.com.sigj.rrhh.dao.PlanillaSueldoDao;
import py.com.sigj.rrhh.domain.Movimiento;
import py.com.sigj.rrhh.domain.PlanillaSalario;
import py.com.sigj.rrhh.domain.PlanillaSueldo;
import py.com.sigj.util.WebUtils;

@Controller
@Scope("request")
@RequestMapping("planilla_salario")
public class PlanillaSalarioFormController extends FormController<PlanillaSalario> {

	@Autowired
	MovimientoDao movimientoDao;

	@Autowired
	EmpleadoDao empleadoDao;

	@Autowired
	PlanillaSalarioDao planillaSalarioDao;

	@Autowired
	PlanillaSueldoDao planillaSueldoDao;

	@Autowired
	ResourceLoader loader;

	@Autowired
	private PlanillaSalarioListController planillaSalarioList;

	@Override
	public String getTemplatePath() {
		return "rrhh/planillaSalario_index";
	}

	@Override
	public String getNombreObjeto() {
		return "planillaSalario";
	}

	@Override
	public PlanillaSalario getNuevaInstancia() {
		return new PlanillaSalario();
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("columnas", planillaSalarioList.getColumnas());
		map.addAttribute("columnasStr", planillaSalarioList.getColumnasStr(null));
		super.agregarValoresAdicionales(map);
	}

	@Override
	public Dao<PlanillaSalario> getDao() {
		return planillaSalarioDao;
	}
	/*
	 * @RequestMapping(value = "planilla_salario", method = RequestMethod.GET)
	 * public String index(ModelMap map) { return super.index(map);
	 *
	 * }
	 */

	@RequestMapping(value = "/validar_fecha", method = RequestMethod.GET)
	public String validar_fecha(ModelMap map, @RequestParam(value = "fecha", required = true) String fecha) {
		List<PlanillaSalario> lista = new ArrayList<PlanillaSalario>();
		if(fecha != null && !fecha.equalsIgnoreCase("") && fecha != ""){
			 lista = obtenerListaPlanilla(fecha);
			 if(lista == null || lista.isEmpty()){
				 map.addAttribute("vacio", "si");
			 }else{
				 map.addAttribute("vacio", "no");
			 }
			
		}else{
			lista = null;
			map.addAttribute("vacio", "si");
		}
		map.addAttribute("planilla_salario", lista);
		return "rrhh/planillaSalario_form";
	}

	private List<PlanillaSalario> obtenerListaPlanilla(String fecha) {

		String aux1 = null;
		String aux2 = null;
		
		aux1 = fecha.substring(0, 2);
		aux2 = fecha.substring(3, 7);
		List<PlanillaSalario> listResult = new ArrayList<PlanillaSalario>();
		PlanillaSueldo psu1 = null;
		PlanillaSueldo p1 = null;

		for (PlanillaSueldo p : planillaSueldoDao.getList(0, 200, null)) {
			if (p.getAnho().equals(aux2) && p.getMes().equals(aux1)) {
				logger.info("Se carga la planilla");
				p1 = p;
			}

		}
		List<Movimiento> mb = movimientoDao.getList(0, 100, null);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		int val = 2;
		if(mb == null || mb.isEmpty()){
			listResult = null;
			return listResult;
		}
		for (Movimiento ml : mb) {
			String fechaCad1 = sdf1.format(ml.getFecha());
			if (fechaCad1.substring(3, 5).equals(aux1) && fechaCad1.substring(6, 10).equals(aux2)) {
				val = 1;
				break;

			} else {
				val = 0;
			}

		}
		if (p1 != null && val == 1) {
			logger.info("P1d:{}", p1);
			listResult = planillaSalarioDao.buscar(p1.getId());
			logger.info("Probando con la planilla ya cargada en bd:{}", listResult);
			return listResult;

		} else if (val == 0) {
			logger.info("Entre en el else del error");
			// map.addAttribute("error_planilla", val);
		} else {
			/*
			 * aca tenemos que controlar que si aun no existe planilla de sueldo
			 * no se deberia crear si es que no hay movimientos en ese mes
			 * introducido
			 */
			logger.info("Entre en el else donde creamos una nueva planilla");
			logger.info("Se va a crear la planilla sin valores");
			PlanillaSueldo planillaSueldo = new PlanillaSueldo();
			planillaSueldo.setAnho(aux2);
			planillaSueldo.setMes(aux1);
			planillaSueldoDao.create(planillaSueldo);
			for (PlanillaSueldo psu : planillaSueldoDao.getList(0, 100, null)) {// arreglar
																				// valores
																				// estaticos
				if (psu.getAnho().equals(aux2) && psu.getMes().equals(aux1)) {
					psu1 = psu;
				}
			}
			logger.info("entras pio aca ");
			logger.info("Esto recibimos:{}", empleadoDao.getList(0, 100, null));
			logger.info("Esto recibimos de movimiento:{}", movimientoDao.getList(0, 100, null));
			List<Movimiento> listaAux = movimientoDao.getList(0, 100, null);
			List<Movimiento> listaM = new ArrayList<Movimiento>();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			for (Movimiento m : listaAux) {
				String fechaCad = sdf.format(m.getFecha());
				logger.info("Lee el fechaCad que pusimos para mes:{}", fechaCad.substring(3, 5));
				logger.info("Lee el fechaCad que pusimos para año:{}", fechaCad.substring(6, 10));
				if (fechaCad.substring(3, 5).equals(aux1) && fechaCad.substring(6, 10).equals(aux2)) {
					logger.info("Esto compara:{}", fechaCad.substring(3, 5), fechaCad.substring(6, 10));

					listaM.add(m);
					logger.info("Carga la listaM:{}", listaM);
				}
			}
			logger.info("Llega hasta el for de fecha", listaM);
			Long aux = null;

			List<Movimiento> auxiliar = new ArrayList<Movimiento>();
			auxiliar.add(listaM.get(0));
			logger.info("Este es el primer valor:{}", auxiliar);
			for (int i = 1; i < listaM.size(); i++) {
				boolean band = true;
				aux = listaM.get(i).getEmpleado().getId();
				logger.info("Primer for recibe el ID: {}", aux);
				for (int j = 0; j < auxiliar.size(); j++) {
					if (aux == auxiliar.get(j).getEmpleado().getId()) {
						logger.info("Encontro repetido");
						band = false;
						break;
					}

				}
				if (band) {
					logger.info("No hay repetido agrega");
					auxiliar.add(listaM.get(i));
					logger.info("La lista ahora ya tiene esto:{}", auxiliar);
					band = true;
				}

			}

			int acum1 = 0;
			int acum2 = 0;
			int cont = 0;
			for (int i = 0; i < auxiliar.size(); i++) {
				// for (Movimiento m1 : auxiliar) {
				int egreso = 0;
				int ingreso = 0;
				int ganancia = 0;
				logger.info("La lista de no repetidos tiene elementos:{}", auxiliar.size());
				logger.info("recorremos la lista, itereacion:{}", cont);
				int sueldo = auxiliar.get(i).getEmpleado().getSalario();
				for (int j = 0; j < listaM.size(); j++) {
					// for (Movimiento m2 : listaM) {
					logger.info("Este es el id de la iteracion:{}", listaM.get(j).getEmpleado().getId());
					if (auxiliar.get(i).getEmpleado().getId() == listaM.get(j).getEmpleado().getId()) {
						logger.info("Compara ambas listas");
						ingreso = ingreso + listaM.get(j).getIngreso();
						egreso = egreso + listaM.get(j).getEgreso();
						logger.info("Ingreso:{}", ingreso);
					}

				}
				if (ingreso > egreso) {
					logger.info("Entra en el if de ingreso > egreso");
					ganancia = ((ingreso - egreso) * 50) / 100;
					sueldo = sueldo + ganancia;
					PlanillaSalario ps = new PlanillaSalario();

					ps.setMontoCobro(sueldo);
					ps.setIngresoTotal(ingreso);
					ps.setEgresoTotal(egreso);
					ps.setObservacion("El empleado tuvo una ganancia de " + ganancia + "GS");
					ps.setEmpleado(auxiliar.get(i).getEmpleado());
					ps.setPlanillaSueldo(psu1);
					logger.info("Esto tiene ps:{}", ps);
					planillaSalarioDao.create(ps);

				} else if (ingreso < egreso) {
					logger.info("Entra en el if de egreso > ingreso");
					ganancia = egreso - ingreso;
					sueldo = sueldo + (egreso - ingreso);
					PlanillaSalario ps = new PlanillaSalario();

					ps.setMontoCobro(sueldo);
					ps.setIngresoTotal(ingreso);
					ps.setEgresoTotal(egreso);
					ps.setObservacion("Se debe devolver al empleado la cantidad de " + ganancia + "GS");

					ps.setEmpleado(auxiliar.get(i).getEmpleado());
					ps.setPlanillaSueldo(psu1);
					logger.info("Esto tiene ps:{}", ps);
					planillaSalarioDao.create(ps);

				} else {
					PlanillaSalario ps = new PlanillaSalario();
					ganancia = 0;
					ps.setMontoCobro(sueldo);
					ps.setIngresoTotal(ingreso);
					ps.setEgresoTotal(egreso);
					ps.setObservacion("");
					ps.setEmpleado(auxiliar.get(i).getEmpleado());
					ps.setPlanillaSueldo(psu1);
					logger.info("Esto tiene ps:{}", ps);
					planillaSalarioDao.create(ps);
				}
				cont++;
			}
			logger.info("La planilla queda asi:{}", planillaSalarioDao.getList(0, 100, null));
			listResult = planillaSalarioDao.getList(0, 100, null);
		}
		return listResult;

	}
	// < ----------------- JASPER ------------------>

	@RequestMapping(value = "/reporte_planilla_salario", method = RequestMethod.GET)
	public void getComprobanteAhorroProgramado(HttpServletResponse response,HttpServletRequest request,
			@RequestParam(value = "fecha", required = true) String fecha) throws Exception {
		String FOLDER = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/reportes/");

		List<PlanillaSalario> lista = obtenerListaPlanilla(fecha);
		logger.info("llega hasta aca");

		InputStream jasperStream = null;
		jasperStream = new FileInputStream(FOLDER + "/comprobante_pago_salarios.jasper");
		try {
			Map<String, Object> params = new HashMap<>();
			Map<String,String> meses = new HashMap<>();
			meses.put("01", "Enero");
			meses.put("02", "Febrero");
			meses.put("03", "Marzo");
			meses.put("04", "Abril");
			meses.put("05", "Mayo");
			meses.put("06", "Junio");
			meses.put("07", "Julio");
			meses.put("08", "Agosto");
			meses.put("09", "Septiembre");
			meses.put("10", "Octubre");
			meses.put("11", "Noviembre");
			meses.put("12", "Diciembre");
			String aux1 = fecha.substring(0, 2);
			String aux2 = fecha.substring(3, 7);
			String key = "";
			if(fecha != null && !fecha.equalsIgnoreCase("") && fecha != ""){
				key = aux1;
				if(meses.containsKey(key)){
					params.put("MES", meses.get(key));
				}
			}
			
			params.put("ANHO", aux2);
			Date ahora = Calendar.getInstance().getTime();
			// params.put("LOGO", loader.getResource("classpath:" +
			// "/logo_regional.jpg").getInputStream());
			// params.put("USUARIO" , session.getAttribute("nombre_completo"));
			// logger.info(loader.getResource("classpath:" +
			// "/logo_regional.jpg").toString());
			int monto = 0;
			for(int i=0;i<lista.size();i++){
				monto += lista.get(i).getMontoCobro();
			}
			params.put("FECHA", WebUtils.getStringFromDate(ahora, "dd/MM/yyyy"));
			params.put("TITULO", "PLANILLA DE SALARIOS");
			params.put("MONEDA_DEBITO", "GUARANIES");
			params.put("MONEDA", "Gs.");
			params.put("CANTIDAD", String.valueOf(lista.size()));
			BigDecimal b = new BigDecimal(monto);
			String ver =  WebUtils.getFormatNumber(b,"GS");
			params.put("MONTO",ver);
			params.put("NRO_CUENTA", "PAGO DE SALARIOS DEL MES");
			params.put("LISTA_PLANILLA", lista);
			//jasperStream = loader.getResource("/comprobante_ahorro_programado/comprobante_ahorro_programado.jasper").getInputStream();
			logger.info(jasperStream.toString());
			if (jasperStream != null) {
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

				byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
				response.setContentType("application/x-pdf");
				response.setHeader("Content-disposition", "inline; filename=planilla_salario.pdf");
				response.reset();
				response.setContentType("application/pdf");
				response.setHeader("Cache-Control", "no-store");
				response.setHeader("Cache-Control", "private");
				response.setHeader("Pragma", "no-store");
				response.setContentLength(pdfReport.length);
				response.getOutputStream().write(pdfReport);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}

		} catch (IOException e) {

			throw new Exception("Error al obtener Comprobante");
		}
	}
}
