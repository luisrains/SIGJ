package py.com.sigj.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import py.com.sigj.expediente.domain.TipoDemanda;

@Component
public class TipoDemandaConverter implements Converter<String, TipoDemanda> {

	@Override
	public TipoDemanda convert(String idStr) {
		TipoDemanda tipoDemanda = new TipoDemanda();
		Long id = Long.parseLong(idStr);
		tipoDemanda.setId(id);
		return tipoDemanda;
	}

}
