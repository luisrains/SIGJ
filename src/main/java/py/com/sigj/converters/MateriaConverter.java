package py.com.sigj.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import py.com.sigj.expediente.domain.Materia;

@Component
public class MateriaConverter implements Converter<String, Materia> {

	@Override
	public Materia convert(String idStr) {

		Materia materia = new Materia();
		Long id = Long.parseLong(idStr);
		materia.setId(id);
		// return tipoClienteDao.find(id);
		return materia;
	}

}
