package es.us.pfc.permuta.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.us.pfc.permuta.entities.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {
	
	@Query ("SELECT p FROM Persona p INNER JOIN p.usuario u WHERE u.id = ?1")
	 public Persona findByUsuarioId (Integer usuarioId);

}
