package es.uniovi.asw.business.impl.agent;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import es.uniovi.asw.business.impl.*;
import es.uniovi.asw.model.*;
import es.uniovi.asw.persistence.util.Jpa;

public class AddAgent implements Command {

	private Agent agent;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public AddAgent(Agent agent) {
		this.agent = agent;
	}

	public Object execute() {
		agent.setPassword(bCryptPasswordEncoder.encode(agent.getPassword()));
		Jpa.getManager().persist(agent);
		
		return agent;
	}

}
