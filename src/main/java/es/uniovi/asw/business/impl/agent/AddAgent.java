package es.uniovi.asw.business.impl.agent;

import es.uniovi.asw.business.impl.*;
import es.uniovi.asw.model.*;
import es.uniovi.asw.persistence.util.Jpa;

public class AddAgent implements Command {

	private Agent agent;

	public AddAgent(Agent agent) {
		this.agent = agent;
	}

	public Object execute() {
		
		Jpa.getManager().persist(agent);
		
		return agent;
	}

}
