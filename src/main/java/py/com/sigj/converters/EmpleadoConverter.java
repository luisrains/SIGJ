package py.com.sigj.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import py.com.sigj.rrhh.domain.Empleado;

@Component
public class EmpleadoConverter implements Converter<String, Empleado> {

	@Override
	public Empleado convert(String idStr) {

		Empleado empleado = new Empleado();
		Long id = Long.parseLong(idStr);
		empleado.setId(id);
		// return tipoClienteDao.find(id);
		return empleado;
	}

}
