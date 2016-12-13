package py.com.sigj.main;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import py.com.sigj.domain.Usuario;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class SesionUsuario {

	private Usuario usuario;

	private Usuario usuarioPorConfirmar;

	public Usuario getUsuarioPorConfirmar() {
		return usuarioPorConfirmar;
	}

	public void setUsuarioPorConfirmar(Usuario usuarioPorConfirmar) {
		this.usuarioPorConfirmar = usuarioPorConfirmar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogger() {
		return usuario != null;
	}

}
