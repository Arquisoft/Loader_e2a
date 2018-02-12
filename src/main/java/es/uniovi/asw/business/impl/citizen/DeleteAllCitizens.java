package es.uniovi.asw.business.impl.citizen;

import java.util.List;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.persistence.util.Jpa;

public class DeleteAllCitizens implements Command {
	
	List<Citizen> citizens;

	public DeleteAllCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}

	@Override
	public Object execute() throws BusinessException {
		
		for(Citizen citizen : citizens) {
			Citizen citizenPersistent = Jpa.getManager().find(Citizen.class, citizen.getID());
			Jpa.getManager().remove(citizenPersistent);
		}
		
		return null;
	}
	
}
