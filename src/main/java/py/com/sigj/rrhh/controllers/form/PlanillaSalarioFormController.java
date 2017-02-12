package py.com.sigj.rrhh.controllers.form;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/validar_fecha", method = RequestMethod.POST)

	public String validar_fecha(ModelMap map, @RequestParam(required = true) String fecha) {

		String aux1 = null;
		String aux2 = null;
		aux1 = fecha.substring(0, 2);
		aux2 = fecha.substring(3, 7);
		List<PlanillaSalario> psx = new ArrayList<PlanillaSalario>();
		PlanillaSueldo psu1 = null;
		PlanillaSueldo p1 = null;
		for (PlanillaSueldo p : planillaSueldoDao.getList(0, 20, null)) {
			if (p.getAnho().equals(aux2) && p.getMes().equals(aux1)) {
				p1 = p;
			}
		}
		if (p1 != null) {
			psx = planillaSalarioDao.buscar(p1.getId());
		} else {
			PlanillaSueldo planillaSueldo = new PlanillaSueldo();
			planillaSueldo.setAnho(aux2);
			planillaSueldo.setMes(aux1);
			planillaSueldoDao.create(planillaSueldo);
			for (PlanillaSueldo psu : planillaSueldoDao.getList(0, 10, null)) {// arreglar
																				// valores
																				// estaticos
				if (psu.getAnho().equals(aux2) && psu.getMes().equals(aux1)) {
					psu1 = psu;
				}
			}
			logger.info("entras pio aca ");
			logger.info("Esto recibimos:{}", empleadoDao.getList(0, 10, null));
			logger.info("Esto recibimos de movimiento:{}", movimientoDao.getList(0, 10, null));
			List<Movimiento> listaAux = movimientoDao.getList(0, 10, null);
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
					sueldo = sueldo + ((ingreso - egreso) * 50) / 100;
					PlanillaSalario ps = new PlanillaSalario();

					ps.setMontoCobro(sueldo);
					ps.setIngresoTotal(ingreso);
					ps.setEgresoTotal(egreso);

					ps.setEmpleado(auxiliar.get(i).getEmpleado());
					ps.setPlanillaSueldo(psu1);
					logger.info("Esto tiene ps:{}", ps);
					planillaSalarioDao.create(ps);

				} else if (ingreso < egreso) {
					logger.info("Entra en el if de egreso > ingreso");
					sueldo = sueldo + (egreso - ingreso);
					PlanillaSalario ps = new PlanillaSalario();

					ps.setMontoCobro(sueldo);
					ps.setIngresoTotal(ingreso);
					ps.setEgresoTotal(egreso);

					ps.setEmpleado(auxiliar.get(i).getEmpleado());
					ps.setPlanillaSueldo(psu1);
					logger.info("Esto tiene ps:{}", ps);
					planillaSalarioDao.create(ps);

				} else {
					PlanillaSalario ps = new PlanillaSalario();

					ps.setMontoCobro(sueldo);
					ps.setIngresoTotal(ingreso);
					ps.setEgresoTotal(egreso);
					ps.setEmpleado(auxiliar.get(i).getEmpleado());
					ps.setPlanillaSueldo(psu1);
					logger.info("Esto tiene ps:{}", ps);
					planillaSalarioDao.create(ps);
				}
				cont++;
			}
			logger.info("La planilla queda asi:{}", planillaSalarioDao.getList(0, 10, null));
			map.addAttribute("planilla_salario", planillaSalarioDao.getList(0, 10, null));

		}
		return null;

	}
}
