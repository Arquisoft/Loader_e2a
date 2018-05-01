package es.uniovi.asw.parser.reader;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.reportWriter.emailWriter.EmailWriter;
import es.uniovi.asw.reportWriter.emailWriter.TxtEmailWriter;
import es.uniovi.asw.services.AgentService;



public class Loader implements ReadList 
{

	private String formato;
	private String filePathExcel;
	private String filePathCSV = "";
	@Autowired
	AgentService agentService  ;

	public Loader() {}
	
	public Loader(String formato, String filePathExcel) {
		this.formato = formato;
		this.filePathExcel = filePathExcel;
	}
	
	public Loader(String formato, String filePathExcel, String filePathCSV)
	{
		this( formato, filePathExcel );
		this.filePathCSV = filePathCSV;
	}

	public void readList() throws IOException, BusinessException 
	{	
		List<Agent> agents = readAgents(formato, filePathExcel);
		
		printAgents(agents, filePathExcel);

		for (Agent agent : agents) {
			if (agentService.findById(agent.getId())!=null) {
				sendEmail(agent, new TxtEmailWriter());
			}
		}
	}

	public List<Agent> readAgents(String formato, String filePathExcel) throws IOException, BusinessException 
	{
		return getReader(formato).readAgents(filePathExcel);
	}

	private void sendEmail(Agent agent, EmailWriter... writers)
			throws IOException {
		String email = "To "
				+ agent.getEmail()
				+ ":\nSaludos "
				+ agent.getNombre()
				+ ", le informamos de que ha sido registrado correctamente en el sistema de participación ciudadana.\nSu nombre de usuario es: "
				+ agent.getID();
		for (EmailWriter writer : writers) {
			writer.write(email);
		}

	}

	/**
	 * Crea y devuelve el reader adecuado
	 */
	private AgentsReader getReader(String formato) {
		if ("excel".equals( formato )) {
			return new ExcelAgentsReader( filePathCSV );
		}
		return null;
	}

	public String getFormato() {
		return formato;
	}

	public String getFilePathExcel() {
		return filePathExcel;
	}
	
	
	
	private void printAgents(List<Agent> agents, String filePathExcel) {
		System.out.println("Estos son los usuarios presentes en el fichero "
				+ filePathExcel + ", y que han sido insertados en la BBDD:");
		for (Agent agent : agents) {
			System.out.println(agent);
		}
	}

	
	

}
