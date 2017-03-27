package py.com.sigj.expediente.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.MateriaDao;
import py.com.sigj.expediente.domain.Materia;
import py.com.sigj.expediente.domain.Proceso;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class MateriaDaoImpl extends DaoImpl<Materia> implements MateriaDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||descripcion";
	}

	@Override
	public void deleteProcesoRelation(Long id) throws IllegalArgumentException {
		logger.info("Eliminando relaciones de materia en la tabla materia_proceso");
		try {
			String sql = "SELECT id FROM MateriaProceso WHERE materia_id = ?1";
			Query query = null;
			query = entityManager.createQuery(sql);
			int cant = query.executeUpdate();
			logger.info("eliminando relacion materia_proceso..");
		} catch (Exception e) {
			logger.info("error {}", e);
			throw new IllegalArgumentException("Ocurrió un error");
		}
	}

	@Override
	public void refresh(Materia obj) {
		entityManager.refresh(obj);

	}

	@Override
	public List<Proceso> getListaProcesos(Long id) throws Exception {
		logger.info("Obteniendo lista de procesos guardados");
		try {

			String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
			sql = sql.replace("#ENTITY#", "proceso");
			Query query = null;
			// Usuario no envió ningún filtro

			sql = sql + " INNER JOIN materia_proceso AS mp " + "ON mp.proceso_id = p.id " + "INNER JOIN materia AS m "
					+ "ON m.id = mp.materia_id " + "WHERE p.id = ?1";
			query = entityManager.createQuery(sql);
			query.setParameter(1, id);

			List<Proceso> list = query.getResultList();

			logger.info("Obteniendo listado de procesos: {}", list);
			return list;
		} catch (Exception e) {
			logger.info("error {}", e);
			throw new Exception("Ocurrió un error");
		}
	}
}
