package es.uniovi.asw.business.impl;

import java.util.List;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.business.impl.citizen.AddCitizen;
import es.uniovi.asw.business.impl.citizen.DeleteAllCitizens;
import es.uniovi.asw.business.impl.citizen.FindAllCitizens;
import es.uniovi.asw.business.impl.citizen.IsCitizenInDatabase;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.*;

public class CitizenServiceImpl implements CitizenService {

	private CommandExecutor executor = new CommandExecutor();
	
	@Override
	public void insertCitizen(Citizen citizen) throws BusinessException {
		executor.execute(new AddCitizen( citizen ));
	}
	
	@Override
	public boolean isCitizenInDatabase(Citizen citizen) throws BusinessException {
		return (Boolean)executor.execute(new IsCitizenInDatabase( citizen ));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Citizen> findAllCitizens() throws BusinessException {
		return (List<Citizen>) executor.execute(new FindAllCitizens());
	}

	@Override
	public void deleteAllCitizens(List<Citizen> citizens) throws BusinessException {
		executor.execute(new DeleteAllCitizens(citizens));
	}
}
