package es.uniovi.asw.parser.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class CsvReader {
	
	public static void main(String[] args) throws IOException {
		  final String FICHERO_URL = "src/main/java/util/TiposAgentes.csv";
	      
		  CSVReader reader = null;
	      try {
	         reader = new CSVReader(new FileReader(FICHERO_URL));
	         String[] nextLine=null;
	         
	         while ((nextLine = reader.readNext()) != null) {
	            System.out.println(Arrays.toString(nextLine));
	         }
	         
	      } catch (IOException e) {
	         System.out.println("El fichero no esta en el path correspondiente.");
	      } finally {
	         if (null != reader) {
	            reader.close();
	         } 
	      }
	   }

}
