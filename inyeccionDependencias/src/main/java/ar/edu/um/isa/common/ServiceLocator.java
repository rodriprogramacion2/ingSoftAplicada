package ar.edu.um.isa.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceLocator {

	private static ServiceLocator _instance;
	
	private static String initialConfigFile = "classpath:app-context.xml";
	
	private ApplicationContext context;
	
	private ServiceLocator() throws Exception {
		try {
			
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(initialConfigFile);
	        context = (ApplicationContext) ctx;
	            
	        }catch (Throwable e) {
	            e.printStackTrace();
	            throw new Exception("Failed to create the context of spring", e);
	        }
	    }

	public static ServiceLocator getInstance() throws Exception {
		if (_instance == null){
			_instance = new ServiceLocator();
		}
	    return _instance;
	}
    
	public static Object getService(String serviceName) throws Exception{
		return ServiceLocator.getInstance().context.getBean(serviceName);
	}
	    
}
