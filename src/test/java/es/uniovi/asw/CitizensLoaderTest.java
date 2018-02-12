package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.conf.ServicesFactory;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.Loader;

public class CitizensLoaderTest {

    @Test
    public void testLoadFromTxt() throws IOException, BusinessException {
    	
    	Loader loader = new Loader("texto", "src/test/resources/test.txt");
		List<Citizen> citizens = loader.readCitizens(loader.getFormato(), loader.getFilePath());
		assertEquals(7, citizens.size());
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Citizen pablo = citizens.get(0);
		assertEquals(pablo.getNombre(), "Pablo");
		assertEquals(pablo.getApellidos(), "Alonso Gil");
		assertEquals(pablo.getEmail(), "pablo@example.com");
		String fechaNacimientoPablo = dateFormat.format(pablo.getFechaNacimiento());
		assertEquals(fechaNacimientoPablo, "10/10/1985");
		assertEquals(pablo.getDireccionPostal(), "Calle Mayor 2");
		assertEquals(pablo.getNacionalidad(), "Noruega");
		assertEquals(pablo.getDni(), "90500094Y");
		assertEquals(pablo.getNombreUsuario(), "pablo@example.com");
		assertEquals(pablo.getContrasena(), "Pablo123");
		
		Citizen eva = citizens.get(5);
		assertEquals(eva.getNombre(), "Eva");
		assertEquals(eva.getApellidos(), "Belmonte Blanco");
		assertEquals(eva.getEmail(), "eva@example.com");
		String fechaNacimientoEva = dateFormat.format(eva.getFechaNacimiento());
		assertEquals(fechaNacimientoEva, "02/05/1960");
		assertEquals(eva.getDireccionPostal(), "Avenida del sur 5");
		assertEquals(eva.getNacionalidad(), "Italiana");
		assertEquals(eva.getDni(), "59120962S");
		assertEquals(eva.getNombreUsuario(), "eva@example.com");
		assertEquals(eva.getContrasena(), "Eva123");
    }
    
    
    @Test
    public void testLoadFromExcel() throws IOException, BusinessException {
		Loader loader = new Loader("excel", "src/test/resources/test.xlsx");
		List<Citizen> citizens = loader.readCitizens(loader.getFormato(), loader.getFilePath());
		assertEquals(3, citizens.size());
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Citizen juan = citizens.get(0);
		assertEquals(juan.getNombre(), "Juan");
		assertEquals(juan.getApellidos(), "Torres Pardo");
		assertEquals(juan.getEmail(), "juan@example.com");
		String fechaNacimientoJuan = dateFormat.format(juan.getFechaNacimiento());
		assertEquals(fechaNacimientoJuan, "10/10/1985");
		assertEquals(juan.getDireccionPostal(), "C/ Federico García Lorca 2");
		assertEquals(juan.getNacionalidad(), "Español");
		assertEquals(juan.getDni(), "90500084Y");
		assertEquals(juan.getNombreUsuario(), "juan@example.com");
		assertEquals(juan.getContrasena(), "Juan123");
		
		Citizen ana = citizens.get(2);
		assertEquals(ana.getNombre(), "Ana");
		assertEquals(ana.getApellidos(), "Torres Pardo");
		assertEquals(ana.getEmail(), "ana@example.com");
		String fechaNacimientoAna = dateFormat.format(ana.getFechaNacimiento());
		assertEquals(fechaNacimientoAna, "01/01/1960");
		assertEquals(ana.getDireccionPostal(), "Av. De la Constitución 8");
		assertEquals(ana.getNacionalidad(), "Español");
		assertEquals(ana.getDni(), "09940449X");
		assertEquals(ana.getNombreUsuario(), "ana@example.com");
		assertEquals(ana.getContrasena(), "Ana123");
    }
    /*
    @Test
    public void testBBDD() throws IOException, BusinessException { 
    	
    	CitizenService citizenService = ServicesFactory.getCitizenService();
    	List<Citizen> citizens = citizenService.findAllCitizens();
    	citizenService.deleteAllCitizens(citizens);
    	
    	Loader loader = new Loader("excel", "src/test/resources/test.xlsx");
    	
    	//Load and send emails to all of the new Citizens
		loader.readList();
		citizens = citizenService.findAllCitizens();
		assertEquals(citizens.size(), 3);
		
		//We load all of them again, but all of them are already in the database, so we write the log file
		loader.readList();
		citizens = citizenService.findAllCitizens();
		assertEquals(citizens.size(), 3);
		
		citizenService.deleteAllCitizens(citizens);	
    }
    */ 
}
