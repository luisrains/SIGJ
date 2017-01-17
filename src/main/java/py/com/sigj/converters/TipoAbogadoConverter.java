package py.com.sigj.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import py.com.sigj.expediente.domain.TipoAbogado;

@Component
public class TipoAbogadoConverter implements Converter<String, TipoAbogado> {

	@Override
	public TipoAbogado convert(String idStr) {

		TipoAbogado tipoAbogado = new TipoAbogado();
		Long id = Long.parseLong(idStr);
		tipoAbogado.setId(id);
		// return tipoClienteDao.find(id);
		return tipoAbogado;
	}

}
