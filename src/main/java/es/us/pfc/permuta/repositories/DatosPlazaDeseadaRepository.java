package es.us.pfc.permuta.repositories;

import org.springframework.data.repository.CrudRepository;

import es.us.pfc.permuta.entities.DatosPlazaDeseada;

public interface DatosPlazaDeseadaRepository extends CrudRepository<DatosPlazaDeseada, Integer> {
	
//	@Query ("SELECT p FROM Persona p INNER JOIN p.usuario u WHERE u.id = ?1")
//	 public List<DatosPlazaDeseada> findPlazasDeseadasByUsuarioId (Integer usuarioId);


}
