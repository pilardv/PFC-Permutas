package es.us.pfc.permuta.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import es.us.pfc.permuta.entities.Usuario;
import es.us.pfc.permuta.repositories.RolesRepository;
import es.us.pfc.permuta.repositories.UsuarioRepository;

@Service("loginService")
public class LoginService implements UserDetailsService {
	
	private final UsuarioRepository usuarioRepository;
	private final RolesRepository rolesRepository;
	
	@Autowired
	public LoginService(UsuarioRepository usuarioRepository, RolesRepository rolesRepository){
		this.usuarioRepository = usuarioRepository;
		this.rolesRepository = rolesRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
		if(null == usuario){
			throw new UsernameNotFoundException("No existe un usuario: " + nombreUsuario);
		}else{
			List<String> rolesUsuario = rolesRepository.findRolByNombreUsuario(nombreUsuario);
			return new CuentaUsuario(usuario, rolesUsuario);
		} 
	}

	public static CuentaUsuario getPrincipal() {
		CuentaUsuario result;
		SecurityContext context;
		Authentication authentication;
		Object principal;

		// If the asserts in this method fail, then you're
		// likely to have your Tomcat's working directory
		// corrupt. Please, clear your browser's cache, stop
		// Tomcat, update your Maven's project configuration,
		// clean your project, clean Tomcat's working directory,
		// republish your project, and start it over.

		context = SecurityContextHolder.getContext();
		Assert.notNull(context);
		authentication = context.getAuthentication();
		Assert.notNull(authentication);
		principal = authentication.getPrincipal();
		Assert.isTrue(principal instanceof CuentaUsuario);
		result = (CuentaUsuario) principal;
		Assert.notNull(result);
		//Assert.isTrue(result.getId() != 0);

		return result;
	}

}
