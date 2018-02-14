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

	@Override
	public List<Citizen> readCitizens(String filePath) throws IOException {
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

				switch (columnIndex) {
				case 0:
					citizen.setNombre(nextCell.getStringCellValue());
					break;
				case 1:
					citizen.setLocalizacion(nextCell.getStringCellValue());
					break;
				case 2:
					citizen.setEmail(nextCell.getStringCellValue());
					break;
				case 3:
					citizen.setID((long)nextCell.getNumericCellValue());
					break;
				case 4:
					citizen.setTipo((int)nextCell.getNumericCellValue());
					break;
				
				default:
					break;
				}
			}
			
			citizens.add(citizen);
		}
		workbook.close();
		inputStream.close();

		return citizens;
	}

}
