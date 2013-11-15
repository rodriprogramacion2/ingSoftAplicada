package ar.edu.um.isa.facade;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.edu.um.isa.common.ServiceLocator;
import ar.edu.um.isa.dao.PublicationDao;
import ar.edu.um.isa.model.Publication;
import ar.edu.um.isa.model.Publisher;

public class MicrobloggingFacadeTest {
	Publication publication = new Publication();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		try{
		
		PublicationDao pd = (PublicationDao) ServiceLocator.getService("publicationDao");
		
		pd.deletePublication(publication);
		}
		catch(Exception e){
			e.printStackTrace();
			fail("No se pudo iniciar el contexto");
		}
	}

	@Test
	public void test() {
		try{
			
			Publisher publicador = new Publisher();
			 Date fecha = new java.util.Date();
			publicador.setIdPublisher(1);
			publication.setDate(fecha);
			publicador.setName("nombre");
			publication.setPublisher(publicador);
			publication.setContent("contenido de la publicacion");
			PublicationDao pd = (PublicationDao) ServiceLocator.getService("publicationDao");
			pd.insertPublication(publication);
		}
		catch(Exception e){
			e.printStackTrace();
			fail("No se pudo iniciar el contexto");
		}
		
	}

}
