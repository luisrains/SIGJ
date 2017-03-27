package py.com.sigj.converters;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import py.com.sigj.gastos.domain.FacturaCabecera; 

@Component
public class FacturaCabeceraConverter implements Converter<String,FacturaCabecera> {

	@Override
	public FacturaCabecera convert(String idStr) {
		
		FacturaCabecera facturaCabecera = new FacturaCabecera();
		Long id = Long.parseLong(idStr);
		facturaCabecera.setId(id);
		return facturaCabecera;
	}

}
