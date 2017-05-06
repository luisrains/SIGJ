package py.com.sigj.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import py.com.sigj.dao.Dao;
import py.com.sigj.main.GenericEntity;

//para que po lo menos tenga emetodo getId()
public abstract class DaoImpl<T extends GenericEntity> implements Dao<T> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected EntityManager entityManager;
	private String entityName;
	private Class<T> entityClass;

	@Transactional
	@Override
	public void create(T obj) {

		logger.info("Insertando registro {}", obj);
		entityManager.persist(obj);
		entityManager.flush();
	}

	@Transactional
	@Override
	public void createOrUpdate(T obj) {

		logger.info("Insertando registro {}", obj);
		entityManager.merge(obj);
		entityManager.flush();
	}

	@Transactional
	@Override
	public void edit(T obj) {
		logger.info("Editando registro {}", obj);
		entityManager.merge(obj);

	}

	@Transactional
	@Override
	public T find(Long id) {
		logger.info("Buscando registro con id: {}", id);
		return entityManager.find(getEntityClass(), id);

	}

	@Transactional
	@Override
	public void destroy(T obj) {
		logger.info("Borrando registro {}", obj);
		entityManager.remove(find(obj.getId()));

	}

	/**
	 * @param sSearch
	 *            es el texto a buscar por cada registro.
	 *
	 *            <code>
	*
	Suponiendo que se busca 'JUAN PEREZ', entonces se
	*
	generará la siguiente consulta
	*
	*
	SELECT *
	*
	FROM persona
	*
	WHERE lower(cedula||nombre||apellido) LIKE lower('%juan%perez%')
	*
	*
	La búsqueda se hace en los campos cedula, nombre y apellido
	* </code>
	 **/
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> getList(Integer filaInicio, Integer filaFin, String sSearch) {
		logger.info("Obteniendo lista de personas, sSearch: {}", sSearch);

		String sql = "SELECT object(#ENTITY#) FROM #ENTITY# AS #ENTITY# ";
		sql = sql.replace("#ENTITY#", getEntityName());
		Query query = null;
		// Usuario no envió ningún filtro

		if (StringUtils.isBlank(sSearch)) {
			query = entityManager.createQuery(sql);
		} else {
			sql = sql + " WHERE lower(" + getCamposFiltrables() + ") LIKE lower(?1)";
			query = entityManager.createQuery(sql);
			query.setParameter(1, "%" + sSearch.replace(" ", "%") + "%");
		}
		query.setFirstResult(filaInicio);
		query.setMaxResults(filaFin);
		List<T> list = query.getResultList();
		logger.info("Cantidad de registros encontrados: {}", list);
		return list;
	}

	public abstract String getCamposFiltrables();

	public String getEntityName() {
		if (entityName == null) {
			Entity entity = getEntityClass().getAnnotation(Entity.class);
			if (entity.name() == null || entity.name().compareTo("") == 0) {
				entityName = getEntityClass().getSimpleName();
			} else {
				entityName = entity.name();
			}
		}
		return entityName;
	}

	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {
		if (entityClass == null) {
			ParameterizedType superClass = (ParameterizedType) this.getClass().getGenericSuperclass();
			entityClass = (Class<T>) superClass.getActualTypeArguments()[0];
		}
		return entityClass;
	}
}
