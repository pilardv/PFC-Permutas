package es.us.pfc.permuta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.us.pfc.permuta.entities.Roles;

public interface RolesRepository extends CrudRepository<Roles, Integer> {
	

	@Query ("SELECT r.rol FROM Roles r INNER JOIN r.usuario u WHERE u.nombreUsuario = ?1")
	public List<String> findRolByNombreUsuario (String nombreUsuario);

}