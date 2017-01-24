package py.com.sigj.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import py.com.sigj.rrhh.domain.Movimiento;

@Component
public class MovimientoConverter implements Converter<String, Movimiento> {
	@Override
	public Movimiento convert(String idStr) {

		Movimiento movimiento = new Movimiento();
		Long id = Long.parseLong(idStr);
		movimiento.setId(id);
		// return tipoClienteDao.find(id);
		return movimiento;
	}
}
