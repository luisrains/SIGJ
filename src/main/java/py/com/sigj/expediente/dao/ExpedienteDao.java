package py.com.sigj.expediente.dao;

import java.util.List;

import py.com.sigj.dao.Dao;
import py.com.sigj.expediente.domain.Abogado;
import py.com.sigj.expediente.domain.Cliente;
import py.com.sigj.expediente.domain.Expediente;
import py.com.sigj.expediente.domain.ExpedienteAbogado;
import py.com.sigj.expediente.domain.ExpedienteCliente;

public interface ExpedienteDao extends Dao<Expediente> {

	public List<ExpedienteAbogado> getListByCedulaRuc(String cedula);
	public List<ExpedienteCliente> getListByCedulaRucCliente(String cedula);
	public List<Expediente> filtro(String nroExpediente,String abogado,String despacho, String estado, String anho);
	public List<ExpedienteCliente> getListByExpedienteId(String id_expediente);
	public List<ExpedienteAbogado> getListByExpedienteIdAb(String id_expediente);
	public List<Cliente> buscarParteCliente(String search);
	public List<Abogado> buscarParteAbogado(String search);
}
