package es.uniovi.asw;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.Loader;

public class Application {

	public static void main(String... args) {
		try {
			System.out.println(args[0]);
			if (args.length != 2)
				throw new IllegalArgumentException("Error en el número de parámetros.");
			//new Application().run((String) args[0], (String) args[1]);
			//new Application().run("excel","src/test/resources/test.xlsx");
			Loader loader = new Loader(args[0], args[1]);
			loader.readList();
			//List<Citizen> lista = new Loader().readCitizens("excel", args[0]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run(String formato, String filePath) throws IOException,
			BusinessException {
		Loader loader = new Loader(formato, filePath);
		loader.readList();	
	}

}
