package py.com.sigj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class DateFormatter implements Formatter<Date> {
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public DateFormatter() {
		super();
	}

	@Override
	public Date parse(final String text, final Locale locale) throws ParseException {
		return simpleDateFormat.parse(text);
	}

	@Override
	public String print(final Date object, final Locale locale) {
		return simpleDateFormat.format(object);
	}
}
