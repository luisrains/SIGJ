package py.com.sigj.converters;

import org.springframework.core.convert.converter.Converter;

import py.com.sigj.security.Rol;

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
