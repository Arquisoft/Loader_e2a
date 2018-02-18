package es.uniovi.asw.parser;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.business.AgentService;
import es.uniovi.asw.conf.ServicesFactory;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.emailWriter.EmailWriter;
import es.uniovi.asw.parser.emailWriter.TxtEmailWriter;
import es.uniovi.asw.parser.reader.AgentsReader;
import es.uniovi.asw.parser.reader.ExcelAgentsReader;
import es.uniovi.asw.reportWriter.LogWriter;

public class Loader {

	private String formato;
	private String filePathExcel;
	private String filePathCSV = "";

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
		System.out.println(agents.size());
		AgentService agentService = ServicesFactory.getAgentService();
		printAgents(agents, filePathExcel);

		for (Agent agent : agents) {
			if (!agentService.isAgentInDatabase(agent)) {
				sendEmail(agent, new TxtEmailWriter());
				agentService.insertAgent(agent);
			} else {
				String mensaje = "El usuario " + agent.getID()
						+ " ya está registrado.";
				LogWriter.write(mensaje);
			}
		}
	}

	public List<Agent> readAgents(String formato, String filePathExcel) throws IOException 
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
				+ filePathExcel + ":");
		for (Agent agent : agents) {
			System.out.println(agent);
		}
	}
	

}
