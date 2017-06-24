package py.com.sigj.expediente.dao.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.sigj.dao.impl.DaoImpl;
import py.com.sigj.expediente.dao.TipoDocumentoDao;
import py.com.sigj.expediente.domain.TipoDocumento;

@Repository
@Scope("session")
public class TipoDocumentoDaoImpl extends DaoImpl<TipoDocumento> implements TipoDocumentoDao {

	@Override
	public String getCamposFiltrables() {
		
		return null;
	}

	
}
