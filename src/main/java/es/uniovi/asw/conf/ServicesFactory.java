package es.uniovi.asw.conf;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.business.impl.CitizenServiceImpl;

public class ServicesFactory {

	public static CitizenService getCitizenService() {
		return new CitizenServiceImpl();
	}
}
