package py.com.sigj.expediente.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.ExpedienteDocumento;
import py.com.sigj.expediente.domain.MovimientoActuacion;

public interface ExpedienteDocumentoDao extends Dao<ExpedienteDocumento> {
	

	public List<ExpedienteDocumento> getListByExpediente(String sSearch);
}
