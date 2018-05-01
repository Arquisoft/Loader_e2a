package es.uniovi.asw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.model.Agent;



@Repository
public interface AgentRepository extends CrudRepository<Agent, Long> {

	Agent findById(Long id);
	Agent findByNombre(String nombre);
}
