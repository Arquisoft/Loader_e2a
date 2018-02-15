package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.business.AgentService;
import es.uniovi.asw.conf.ServicesFactory;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.Loader;

public class AgentsLoaderTest {

    @Test
    public void testLoadFromTxt() throws IOException, BusinessException {
    	
//    	Loader loader = new Loader("texto", "src/test/resources/test.txt");
//		List<agent> agents = loader.readagents(loader.getFormato(), loader.getFilePath());
//		assertEquals(7, agents.size());
//		
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		
//		agent pablo = agents.get(0);
//		assertEquals(pablo.getNombre(), "Pablo");
//		assertEquals(pablo.getApellidos(), "Alonso Gil");
//		assertEquals(pablo.getEmail(), "pablo@example.com");
//		String fechaNacimientoPablo = dateFormat.format(pablo.getFechaNacimiento());
//		assertEquals(fechaNacimientoPablo, "10/10/1985");
//		assertEquals(pablo.getDireccionPostal(), "Calle Mayor 2");
//		assertEquals(pablo.getNacionalidad(), "Noruega");
//		assertEquals(pablo.getDni(), "90500094Y");
//		assertEquals(pablo.getNombreUsuario(), "pablo@example.com");
//		assertEquals(pablo.getContrasena(), "Pablo123");
//		
//		agent eva = agents.get(5);
//		assertEquals(eva.getNombre(), "Eva");
//		assertEquals(eva.getApellidos(), "Belmonte Blanco");
//		assertEquals(eva.getEmail(), "eva@example.com");
//		String fechaNacimientoEva = dateFormat.format(eva.getFechaNacimiento());
//		assertEquals(fechaNacimientoEva, "02/05/1960");
//		assertEquals(eva.getDireccionPostal(), "Avenida del sur 5");
//		assertEquals(eva.getNacionalidad(), "Italiana");
//		assertEquals(eva.getDni(), "59120962S");
//		assertEquals(eva.getNombreUsuario(), "eva@example.com");
//		assertEquals(eva.getContrasena(), "Eva123");
    }
    
    
    @Test
    public void testLoadFromExcel() throws IOException, BusinessException {
//		Loader loader = new Loader("excel", "src/test/resources/test.xlsx");
//		List<agent> agents = loader.readagents(loader.getFormato(), loader.getFilePath());
//		assertEquals(3, agents.size());
//		
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		
//		agent juan = agents.get(0);
//		assertEquals(juan.getNombre(), "Juan");
//		assertEquals(juan.getApellidos(), "Torres Pardo");
//		assertEquals(juan.getEmail(), "juan@example.com");
//		String fechaNacimientoJuan = dateFormat.format(juan.getFechaNacimiento());
//		assertEquals(fechaNacimientoJuan, "10/10/1985");
//		assertEquals(juan.getDireccionPostal(), "C/ Federico García Lorca 2");
//		assertEquals(juan.getNacionalidad(), "Español");
//		assertEquals(juan.getDni(), "90500084Y");
//		assertEquals(juan.getNombreUsuario(), "juan@example.com");
//		assertEquals(juan.getContrasena(), "Juan123");
//		
//		agent ana = agents.get(2);
//		assertEquals(ana.getNombre(), "Ana");
//		assertEquals(ana.getApellidos(), "Torres Pardo");
//		assertEquals(ana.getEmail(), "ana@example.com");
//		String fechaNacimientoAna = dateFormat.format(ana.getFechaNacimiento());
//		assertEquals(fechaNacimientoAna, "01/01/1960");
//		assertEquals(ana.getDireccionPostal(), "Av. De la Constitución 8");
//		assertEquals(ana.getNacionalidad(), "Español");
//		assertEquals(ana.getDni(), "09940449X");
//		assertEquals(ana.getNombreUsuario(), "ana@example.com");
//		assertEquals(ana.getContrasena(), "Ana123");
    }
    
    @Test
    public void testBBDD() throws IOException, BusinessException { 
    	
    	AgentService agentService = ServicesFactory.getAgentService();
    	List<Agent> agents = agentService.findAllAgents();
    	agentService.deleteAllAgents(agents);
    	
    	Loader loader = new Loader("excel", "src/test/resources/test.xlsx");
    	
    	//Load and send emails to all of the new agents
		loader.readList();
		agents = agentService.findAllAgents();
		assertEquals(agents.size(), 3);
		
		//We load all of them again, but all of them are already in the database, so we write the log file
		loader.readList();
		agents = agentService.findAllAgents();
		assertEquals(agents.size(), 3);
		
		agentService.deleteAllAgents(agents);	
    }
    
}
