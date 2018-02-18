package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.persistence.util.Jpa;

public class AgentFinder {

	public static boolean isInDatabase(Agent agent) {
		List<Agent> lista = Jpa
				.getManager()
				.createQuery("select a from Agent a where a.ID = ?1",
						Agent.class).setParameter(1, agent.getID())
				.getResultList();
		if (lista.size() > 0) {
			return new Boolean(true);
		} else {
			return new Boolean(false);
		}
	}

	public static List<Agent> findAll() {
		return Jpa.getManager()
				.createQuery("select a from Agent a", Agent.class)
				.getResultList();
	}
}
