package es.uniovi.asw.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.repository.AgentRepository;



@Service
@Configurable
public class AgentService {
	
	@Autowired
	AgentRepository agentRepo ;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Agent findById(long id) {
		return agentRepo.findById(id);
	}
	public Agent findByNombre(String nombre) {
		return agentRepo.findByNombre(nombre);
	}
		
//	public void addAgents(List<Agent> lista) {
//		for(Agent a : lista) {
//			if(agentRepo.findByNombre(a.getNombre())!=null) {
//				addAgent(a);
//			}
//		}
//	}
	public void addAgent(Agent agent) {
		agent.setPassword(bCryptPasswordEncoder.encode(agent.getPassword()));
		agentRepo.save(agent);
	}
	
}
	
