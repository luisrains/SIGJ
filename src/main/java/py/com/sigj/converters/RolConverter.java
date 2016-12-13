package py.com.owl.owlapp.converters;

import org.springframework.core.convert.converter.Converter;

import py.com.owl.owlapp.domain.Rol;

public class RolConverter implements Converter<String, Rol> {

	@Override
	public Rol convert(String idStr) {

		Rol rol = new Rol();
		Long id = Long.parseLong(idStr);
		rol.setId(id);
		// return tipoClienteDao.find(id);
		return rol;
	}

}
