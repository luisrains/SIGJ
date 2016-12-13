package py.com.sigj.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import py.com.sigj.dao.PermisoDao;
import py.com.sigj.dao.UsuarioDao;
import py.com.sigj.domain.Permiso;
import py.com.sigj.domain.Usuario;
import py.com.sigj.main.Contexto;
import py.com.sigj.main.SesionUsuario;

@Service
public class UserRoleService implements UserDetailsService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		UsuarioDao userDao = (UsuarioDao) Contexto.getBean("usuarioDaoImpl");
		Usuario user = userDao.buscar(username);

		if (user == null) {
			logger.info("No se encontró USUARIO: {}", username);
			throw new UsernameNotFoundException("No existe Usuario");
		}

		SesionUsuario sesionUsuario = (SesionUsuario) Contexto.getBean("sesionUsuario");
		// existe usuario, pero falta que spring verifique contraseña
		sesionUsuario.setUsuarioPorConfirmar(user);
		/*
		 * UserSession userSession = (UserSession) ApplicationContextProvider
		 * .getBeanStatic("userSession"); try { UserBC userBC = (UserBC)
		 * ApplicationContextProvider .getBeanStatic("userBCImpl");
		 *
		 * User user = userBC.findByUsername(username);
		 *
		 * if (user == null) { userSession.addObject("loginError",
		 * getMsg().get("wrong_user_or_pass")); return
		 * getUsuarioAnonimo(username); }
		 *
		 * userSession.setUserTmp(user); return
		 * buildUserForAuthentication(user); } catch (Exception exc) {
		 *
		 * return null; }
		 */

		return buildUserForAuthentication(user);
	}

	protected UserDetails buildUserForAuthentication(final Usuario user) {
		final List<GrantedAuthority> permisos = new ArrayList<>();
		PermisoDao permisoDao = (PermisoDao) Contexto.getBean("permisoDaoImpl");
		// por medio del rol, obtenemos todos los permisos del usuario
		for (final Permiso permiso : permisoDao.ListByRol(user.getRol())) {
			@SuppressWarnings("serial")
			GrantedAuthority ga = new GrantedAuthority() {

				@Override
				public String getAuthority() {

					return permiso.getCodigo();
				}
			};
			permisos.add(ga);
		}

		@SuppressWarnings("serial")
		UserDetails userDetail = new UserDetails() {

			@Override
			public boolean isEnabled() {

				return true;// user.isActivo();
			}

			@Override
			public boolean isCredentialsNonExpired() {

				return true;
			}

			@Override
			public boolean isAccountNonLocked() {

				return true;// usuario.isBloqueado();
			}

			@Override
			public boolean isAccountNonExpired() {

				return true;
			}

			@Override
			public String getUsername() {

				return user.getCodigo();
			}

			@Override
			public String getPassword() {

				return user.getPassword();
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {

				return permisos;
			}
		};
		return userDetail;
	}

}
