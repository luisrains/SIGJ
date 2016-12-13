package py.com.owl.owlapp.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.owl.owlapp.dao.ClienteDao;
import py.com.owl.owlapp.domain.Cliente;

@Repository
@Scope("session")
public class ClienteDaoImpl extends DaoImpl<Cliente> implements ClienteDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||razonSocial";
	}

}
