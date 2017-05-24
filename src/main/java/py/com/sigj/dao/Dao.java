package py.com.sigj.dao;

import java.util.List;

public interface Dao<T> {
	/**
	 * Inserta un registro en la base de datos
	 */
	void create(T obj);

	void createOrUpdate(T obj);

	/**
	 * Actualiza el registro de la base de datos
	 */
	void edit(T obj);

	/**
	 * @return obj con el id indicado
	 */
	T find(Long id);

	/**
	 * Elimina un registro de la base de datos.
	 */
	void destroy(T obj);

	/**
	 * @param sSearch
	 *
	 *            filtro que se debe aplicar en la búsqueda
	 * @return registros de la tabla
	 */

	List<T> getList(Integer filaInicio, Integer filaFin, String sSearch);

	List<T> getListAll(String sSearch);

	/**
	 * @param id
	 *            del objeto metodo que busca el listado de objetos de acuerdo
	 *            al id utilizado en el selectPicker al momento de editar un
	 *            objeto.
	 * @return Lista de objeto.List<>
	 */
	// List<T> getListaSelect(Long id);

}
