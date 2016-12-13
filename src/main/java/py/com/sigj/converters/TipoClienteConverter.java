package py.com.sigj.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import py.com.sigj.domain.TipoCliente;

@Component
public class TipoClienteConverter implements Converter<String, TipoCliente> {

	@Override
	public TipoCliente convert(String idStr) {
		TipoCliente tipoCliente = new TipoCliente();
		Long id = Long.parseLong(idStr);
		tipoCliente.setId(id);
		// return tipoClienteDao.find(id);
		return tipoCliente;
	}

}
