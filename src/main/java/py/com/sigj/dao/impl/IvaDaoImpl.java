package py.com.sigj.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.IvaDao;
import py.com.sigj.domain.Iva;

@Repository
@Scope("session")
public class IvaDaoImpl extends DaoImpl<Iva> implements IvaDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||porcentaje";
	}

}
