package py.com.owl.owlapp.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.owl.owlapp.dao.RolDao;
import py.com.owl.owlapp.domain.Rol;

@Repository
@Scope("session")
public class RolDaoImpl extends DaoImpl<Rol> implements RolDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||descripcion";
	}

}
