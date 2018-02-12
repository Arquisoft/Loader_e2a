package es.uniovi.asw.parser;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.conf.ServicesFactory;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.emailWriter.EmailWriter;
import es.uniovi.asw.parser.emailWriter.TxtEmailWriter;
import es.uniovi.asw.parser.reader.CitizensReader;
import es.uniovi.asw.parser.reader.ExcelCitizensReader;
import es.uniovi.asw.parser.reader.TextCitizensReader;
import es.uniovi.asw.reportWriter.LogWriter;

public class Loader {

	private String formato;
	private String filePath;

	public Loader(String formato, String filePath) {
		this.formato = formato;
		this.filePath = filePath;
	}

	public void readList() throws IOException, BusinessException {
		
		List<Citizen> citizens = readCitizens(formato, filePath);

		CitizenService citizenService = ServicesFactory.getCitizenService();

		printCitizens(citizens, filePath);

		for (Citizen citizen : citizens) {
			if (!citizenService.isCitizenInDatabase(citizen)) {
				sendEmail(citizen, new TxtEmailWriter());
				citizenService.insertCitizen(citizen);
			} else {
				String mensaje = "El usuario " + citizen.getNombreUsuario()
						+ " ya está registrado.";
				LogWriter.write(mensaje);
			}
		}
	}

	public List<Citizen> readCitizens(String formato, String filePath) throws IOException {
		return getReader(formato).readCitizens(filePath);
	}

	private void sendEmail(Citizen citizen, EmailWriter... writers)
			throws IOException {
		String email = "To "
				+ citizen.getEmail()
				+ ":\nSaludos "
				+ citizen.getNombre()
				+ ", le informamos de que ha sido registrado correctamente en el sistema de participación ciudadana.\nSu nombre de usuario es: "
				+ citizen.getNombreUsuario();
		for (EmailWriter writer : writers) {
			writer.write(email);
		}

	}

	/**
	 * Crea y devuelve el reader adecuado
	 */
	private CitizensReader getReader(String formato) {
		if ("excel".equals(formato)) {
			return new ExcelCitizensReader();
		} else if ("texto".equals(formato)) {
			return new TextCitizensReader();
		}
		return null;
	}

	public String getFormato() {
		return formato;
	}

	public String getFilePath() {
		return filePath;
	}
	
	
	
	private void printCitizens(List<Citizen> citizens, String filePath) {
		System.out.println("Estos son los usuarios presentes en el fichero "
				+ filePath + ":");
		for (Citizen citizen : citizens) {
			System.out.println(citizen);
		}
	}
	

}
