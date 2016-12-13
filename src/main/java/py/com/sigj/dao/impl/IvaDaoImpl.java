package py.com.owl.owlapp.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.owl.owlapp.dao.IvaDao;
import py.com.owl.owlapp.domain.Iva;

@Repository
@Scope("session")
public class IvaDaoImpl extends DaoImpl<Iva> implements IvaDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||porcentaje";
	}

}
