package es.uniovi.asw.parser.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Citizen;

public class ExcelCitizensReader implements CitizensReader {

	private final static int COLUMNA_LOCALIZACION=1;
	
	@Override
	public List<Citizen> readCitizens(String filePath) throws IOException {
		boolean agenteValido = true;
		
		List<Citizen> citizens = new ArrayList<Citizen>();
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		iterator.next(); // Para saltar la primera fila de titulos

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Citizen citizen = new Citizen();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();
				
				boolean celdaCorrecta = true;
				
				switch (columnIndex) {
				case 0:
					celdaCorrecta = compruebaCeldaString( nextCell.getStringCellValue(), columnIndex );
					citizen.setNombre(nextCell.getStringCellValue());
					break;
				case 1:
					celdaCorrecta = compruebaCeldaString( nextCell.getStringCellValue(), columnIndex );
					citizen.setLocalizacion(nextCell.getStringCellValue());
					break;
				case 2:
					celdaCorrecta = compruebaCeldaString( nextCell.getStringCellValue(), columnIndex );
					citizen.setEmail(nextCell.getStringCellValue());
					break;
				case 3:
					celdaCorrecta = compruebaCeldaNumeric( nextCell.getNumericCellValue(), columnIndex );
					citizen.setID((long)nextCell.getNumericCellValue());
					break;
				case 4:
					celdaCorrecta = compruebaCeldaNumeric( nextCell.getNumericCellValue(), columnIndex );
					citizen.setTipo((int)nextCell.getNumericCellValue());
					break;
				
				default:
					break;
				}
				
				if (!celdaCorrecta)
				{
					agenteValido = false;
					break;
				}
			}
			
			if (agenteValido)
				citizens.add(citizen);
			
			agenteValido = true;
		}
		workbook.close();
		inputStream.close();

		return citizens;
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
}
