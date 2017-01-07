package py.com.sigj.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import py.com.sigj.expediente.domain.Persona;

@Component
public class PersonaConverter implements Converter<String, Persona> {

	@Override
	public Persona convert(String idStr) {

		Persona persona = new Persona();
		Long id = Long.parseLong(idStr);
		persona.setId(id);
		// return tipoClienteDao.find(id);
		return persona;
	}

}
