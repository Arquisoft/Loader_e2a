package es.uniovi.asw;

import java.io.IOException;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.Loader;

public class Application {

	public static void main(String... args) {
		try {
			new Application().run((String) args[0], (String) args[1]);
			//new Application().run("excel","src/test/resources/test.xlsx");
			// Por si hay problemas con la de arriba
			// new
			// CitizensLoader().load("excel","src/test/resources/test.xlsx");
			// new CitizensLoader().load("texto","src/test/resources/test.txt");
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
