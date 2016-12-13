package py.com.owl.owlapp.main;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Contexto implements ApplicationContextAware {

	private static final long serialVersionUID = 1L;
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		Contexto.context = applicationContext;
	}

	public static Object getBean(String name) {
		return context.getBean(name);
	}
}
