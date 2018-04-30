package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.reader.Loader;

public class AgentsLoaderTest {

	Loader loader;
	
	@Before
	public void setUp()
	{
		loader = new Loader("excel", 
				"src/test/resources/test.xlsx", 
				"src/test/resources/TiposAgentes.csv");
	}
    
    
    @Test
    public void testLoadFromExcel() throws IOException, BusinessException 
    {
    	// Saca la lista de agentes del fichero Excel
		List<Agent> Agents = loader.readAgents(loader.getFormato(), loader.getFilePathExcel());
		assertEquals(7, Agents.size());
				
		Agent juan = Agents.get(0);
		assertEquals(juan.getNombre(), "Juan");
		assertEquals(juan.getEmail(), "juan@example.com");
		//assertEquals(juan.getLocalizacion(), "105.70.56");
		assertEquals(juan.getNombreUsuario(), "59019237X");
		
		Agent pablo = Agents.get(3);
		assertEquals(pablo.getNombre(), "Pablo Díaz");
		assertEquals(pablo.getEmail(), "uo251017@uniovi.es");
		//assertEquals(pablo.getLocalizacion(), null);
		assertEquals(pablo.getNombreUsuario(), "58429367Y");
    }
    
    /*
    @Test
    public void testBBDD() throws IOException, BusinessException { 
    	
    	AgentService AgentService = ServicesFactory.getAgentService();
    	List<Agent> agents = AgentService.findAllAgents();
    	AgentService.deleteAllAgents(agents);
    	assertEquals(agents.size(), 0);
    	
    	Loader loader = new Loader("excel", "src/test/resources/test.xlsx", "src/test/resources/TiposAgentes.csv");
    	
    	//Load and send emails to all of the new Agents
		loader.readList();
		agents = AgentService.findAllAgents();
		assertEquals(agents.size(), 7);
		
		//We load all of them again, but all of them are already in the database, so we write the log file
		loader.readList();
		agents = AgentService.findAllAgents();
		assertEquals(agents.size(), 7);
		
		AgentService.deleteAllAgents(agents);	
    }
    */
    
}
