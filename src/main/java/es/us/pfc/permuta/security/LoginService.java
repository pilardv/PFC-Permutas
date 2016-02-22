package es.us.pfc.permuta.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

}
