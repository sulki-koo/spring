package jdbcboard.filter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbcboard.command.Command;

public class ViewResolverFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		try {
			
			Map<String, Object> commandMap = new HashMap<String, Object>();
			Properties commandProperties = (Properties)(request.getServletContext().getAttribute("commandProperties"));
			
			Iterator<Object> it = commandProperties.keySet().iterator();
			
			while (it.hasNext()) {
				String command = (String)it.next();
				String commandClassStr = commandProperties.getProperty(command);
				Class<?> commandClass = Class.forName(commandClassStr);
				@SuppressWarnings("deprecation")
				Command commandObj = (Command)commandClass.newInstance();
				commandMap.put(command, commandObj);
			}
			
			HttpServletRequest hsr = (HttpServletRequest)request;
			String requestURI = hsr.getRequestURI();
			if (requestURI.indexOf(hsr.getContextPath()) == 0) {
				requestURI = requestURI.substring(hsr.getContextPath().length() + 1);
			}
			
			Command cmd = (Command)commandMap.get(requestURI);
			
			hsr.setAttribute("requestURI", requestURI);

			String viewPage 
				= cmd.process((HttpServletRequest)request, (HttpServletResponse)response);
			if (viewPage != null) {
				hsr.setAttribute("viewPage", viewPage);
			}			
			
			chain.doFilter(request, response);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}



