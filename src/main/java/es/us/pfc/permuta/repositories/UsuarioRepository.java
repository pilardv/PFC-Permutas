package es.us.pfc.permuta.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.us.pfc.permuta.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	@Query ("SELECT u FROM Usuario u WHERE u.nombreUsuario = ?")
	 public Usuario findByNombreUsuario (String nombreUsuario);

}


