package py.com.sigj.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import py.com.sigj.expediente.domain.EstadoExternoInterno;

@Component
public class EstadoExternoInternoConverter implements Converter<String, EstadoExternoInterno> {
	@Override
	public EstadoExternoInterno convert(String idStr) {
		EstadoExternoInterno estadoExternoInterno = new EstadoExternoInterno();
		Long id = Long.parseLong(idStr);
		estadoExternoInterno.setId(id);
		return estadoExternoInterno;
	}

}
