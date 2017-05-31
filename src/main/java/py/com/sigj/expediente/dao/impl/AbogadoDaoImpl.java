package py.com.sigj.expediente.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.AbogadoDao;
import py.com.sigj.expediente.domain.Abogado;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class AbogadoDaoImpl extends DaoImpl<Abogado> implements AbogadoDao {

	@Override
	public String getCamposFiltrables() {
		return "empleado.persona.cedula_ruc||empleado.persona.nombre_razonSocial||empleado.persona.apellido||domicilioLaboral||domicilioActual";
	}
}
