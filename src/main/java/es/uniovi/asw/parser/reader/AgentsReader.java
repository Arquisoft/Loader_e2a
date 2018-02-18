package es.uniovi.asw.parser.reader;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.model.Agent;

public interface AgentsReader {

	List<Agent> readAgents(String filePath) throws IOException;

}
