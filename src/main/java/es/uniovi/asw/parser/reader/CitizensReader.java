package es.uniovi.asw.parser.reader;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.model.Citizen;

public interface CitizensReader {

	List<Citizen> readCitizens(String filePath) throws IOException;

}
