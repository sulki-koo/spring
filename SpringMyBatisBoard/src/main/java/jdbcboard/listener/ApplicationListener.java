package jdbcboard.listener;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
 
public class ApplicationListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		String commandProp = sce.getServletContext().getInitParameter("commandProp");
		Properties commandProperties = new Properties();
		
		try {
			commandProperties.load(new FileReader(sce.getServletContext().getRealPath(commandProp)));
			sce.getServletContext().setAttribute("commandProperties", commandProperties);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

}








