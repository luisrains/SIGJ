package py.com.sigj.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.RolDao;
import py.com.sigj.security.Rol;

@Repository
@Scope("session")
public class RolDaoImpl extends DaoImpl<Rol> implements RolDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||descripcion";
	}

}
