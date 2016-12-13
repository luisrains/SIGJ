package py.com.sigj.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Message {
	@Autowired
	private MessageSource messageSource;

	public String get(String msg, Object... args) {
		return messageSource.getMessage(msg, args, msg, LocaleContextHolder.getLocale());
	}

	public String getOrDefault(String msg, String defaultMsg, Object... args) {
		return messageSource.getMessage(msg, args, defaultMsg, LocaleContextHolder.getLocale());
	}
}
