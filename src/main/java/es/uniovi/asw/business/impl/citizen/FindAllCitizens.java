package es.uniovi.asw.business.impl.citizen;

import java.util.List;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.persistence.CitizenFinder;

public class FindAllCitizens implements Command {
	
	public List<Citizen> execute() {
		return CitizenFinder.findAll();	
	}
}
