package es.us.pfc.permuta.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import es.us.pfc.permuta.entities.Usuario;

public class CuentaUsuario extends Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private List<String> rolesUsuario;
	
	public CuentaUsuario(Usuario usuario, List<String> rolesUsuario){
		super(usuario);
		this.rolesUsuario = rolesUsuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		String roles = StringUtils.collectionToCommaDelimitedString(rolesUsuario);			
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public String getPassword() {
		return super.getClave();
	}

	@Override
	public String getUsername() {
		return super.getNombreUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
