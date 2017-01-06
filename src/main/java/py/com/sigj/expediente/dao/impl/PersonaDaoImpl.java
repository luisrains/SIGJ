package py.com.sigj.expediente.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.PersonaDao;
import py.com.sigj.expediente.domain.Persona;

//hibernate recomendia repository para cuando trabaja con transacciones de base de datos, le decis que vas a trabajar con base de datos directos
@Repository
@Scope("session") // para crear una nueva instancia para cada sesion
public class PersonaDaoImpl extends DaoImpl<Persona> implements PersonaDao {

	@Override
	public String getCamposFiltrables() {
		return "cedula_ruc||nombre_razonSocial||apellido||sexo||estadoCivil||ocupacion||correoElectronico||telefono";
	}
}
