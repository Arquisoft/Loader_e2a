package es.uniovi.asw;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.parser.reader.Loader;
import es.uniovi.asw.services.AgentService;

@SpringBootApplication
//@EnableScheduling
public class Application implements  ApplicationContextAware {
	
  ApplicationContext cx;
  public static void main(String[] args) throws IOException {
  	SpringApplication.run(Application.class, args);
  	try {
		run(args);
	} catch (BusinessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

	
  
 
//	public static void main(String... args) {
//		try {
//			if (args.length <= 2)
//				throw new IllegalArgumentException("Error en el número de parámetros.");
//			
//			new Application().run( args );
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void run(String... parametros) throws IOException,
			BusinessException {
		String formato = "excel";//parametros[0]; // "excel"
		String filePathExcel = "src/test/resources/test1.xlsx";// parametros[1]; // "src/test/resources/xxx.xlsx"
		String filePathCSV = "src/test/resources/TiposAgentes.csv";//parametros[2]; // "src/test/resources/yyy.csv"
		ReadList loader = new Loader( formato, filePathExcel, filePathCSV );
//		AutowireCapableBeanFactory factory = cx.getAutowireCapableBeanFactory();
//		factory.autowireBean( bean );
//		factory.initializeBean( bean, "bean" );
		
		loader.readList();	
	}




@Override
public void setApplicationContext(ApplicationContext arg0) throws BeansException {
	this.cx= arg0;
	
}

}
