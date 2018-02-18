package es.uniovi.asw.parser.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.reportWriter.LogWriter;

public class ExcelAgentsReader implements AgentsReader {

	private final static int COLUMNA_LOCALIZACION=1;
	private String filePathCSV;
	private Map<Integer, String> tiposAgentes;
	
	public ExcelAgentsReader() {}
	
	public ExcelAgentsReader(String filePathCSV)
	{
		this.filePathCSV = filePathCSV;
	}
	
	@Override
	public List<Agent> readAgents(String filePathExcel) throws IOException {
		boolean agenteValido = true; // por si se lee un campo no válido
		
		List<Agent> citizens = new ArrayList<Agent>();
		
		tiposAgentes = leerCSV();
		
		File file = new File( filePathExcel );
		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		iterator.next(); // Para saltar la primera fila de titulos
		
		while (iterator.hasNext()) {
			
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Agent agent = new Agent();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();
				
				boolean celdaCorrecta = compruebaCeldaValida( nextCell, columnIndex );
				if (!celdaCorrecta)
				{
					agenteValido = false;
					break;
				}
				
				switch (columnIndex) {
				case 0: // nombre
					agent.setNombre( (String) getContenidoCelda( nextCell ) );
					break;
				case 1: // localización
					agent.setLocalizacion( (String) getContenidoCelda( nextCell ) );
					break;
				case 2: // email
					agent.setEmail( (String) getContenidoCelda( nextCell ) );
					break;
				case 3: // identificador
					agent.setID( (String) getContenidoCelda( nextCell ) );
					break;
				case 4: // tipo agente
					celdaCorrecta = compruebaAgenteEnCSV( (String) getContenidoCelda(nextCell) );
					if (!celdaCorrecta)
					{
						agenteValido = false;
						break;
					}
					agent.setTipo( getTipoAgente( (String) getContenidoCelda(nextCell) ) );
					break;
				
				default:
					agenteValido = false;
					break;
				}
			}
			
			if ( comprobacionesFinales( agent ) && agenteValido ) {
				agent.crearContraseña();
				citizens.add(agent);
			}
			
			else
				System.err.println("Agente no insertado.");
			
			agenteValido = true;
		}
		workbook.close();
		inputStream.close();

		return citizens;
	}
	
	private boolean compruebaCeldaValida(Cell celda, int columna)
	{
		try // si es una celda de tipo String...
		{
			String contenidoCelda = celda.getStringCellValue();
			return compruebaCeldaString( contenidoCelda, columna );
		} catch (IllegalStateException ise) // la celda es un entero
		{
			int contenidoCelda = (int) celda.getNumericCellValue();
			return compruebaCeldaNumeric( contenidoCelda, columna );
		}
	}
	
	private Object getContenidoCelda(Cell celda)
	{
		try // si es una celda de tipo String...
		{
			return celda.getStringCellValue();
		} catch (IllegalStateException ise) // la celda es un entero
		{
			return String.valueOf((int) celda.getNumericCellValue());
		}
	}

	private boolean compruebaCeldaString(String contenidoCelda, int columna) 
	{
		if ( columna != COLUMNA_LOCALIZACION 
				&& (contenidoCelda == null || contenidoCelda.equals("")))
			return false;
		
		return true;
	}
	private boolean compruebaCeldaNumeric(double contenidoCelda, int columna) 
	{
		if ( columna != COLUMNA_LOCALIZACION 
				&& (int)contenidoCelda == 0)
			return false;
		
		return true;
	}
	
	private Map<Integer, String> leerCSV() throws IOException
	{
		return new CsvReader().leerCSV( filePathCSV );
	}
	
	private boolean compruebaAgenteEnCSV(String valorCelda) 
	{
		int tipoAgenteNumerico = getTipoAgente( valorCelda );
		String tipoAgente= (String) tiposAgentes.get( tipoAgenteNumerico );
		
		return ( tipoAgente.equals( valorCelda ) ) ? true : false;
	}
	
	private int getTipoAgente(String tipoAgente)
	{
		int tipo = -1;
		
		for(Map.Entry<Integer, String> entrada: tiposAgentes.entrySet()){
            if(tipoAgente.equals(entrada.getValue()))
            {
                tipo = entrada.getKey();
                break;
            }
        }
		
		return tipo;
	}
	
	private boolean comprobacionesFinales(Agent agente) throws IOException
	{
		boolean agenteValido = true;
		if (agente.getID() == null)
		{
			agenteValido = false;
			LogWriter.write( "Usuario sin identificador." );
		}
		else if (agente.getNombre() == null)
		{
			agenteValido = false;
			LogWriter.write( "El usuario " + agente.getID() + " no tiene nombre." );
		}
		else if (agente.getNombre() == null)
		{
			agenteValido = false;
			LogWriter.write( "El usuario " + agente.getID() + " no tiene nombre." );
		}
		else if (agente.getEmail() == null)
		{
			agenteValido = false;
			LogWriter.write( "El usuario " + agente.getID() + " no tiene email." );
		}
		else if (agente.getTipo() == 0)
		{
			agenteValido = false;
			LogWriter.write( "El usuario " + agente.getID() + " no tiene un tipo de agente asignado." );
		}
		else if (!compruebaLocalizacion( agente ))
		{
			agenteValido = false;
			LogWriter.write( "El usuario " + agente.getID() + " tiene una localización incorrecta." );
		}
		
		return agenteValido;
	}
	
	private boolean compruebaLocalizacion(Agent agente)
	{
		return ( (agente.getTipo() == 3 && agente.getLocalizacion() != null) || agente.getTipo() != 3) 
																								? true : false;
	}
}
