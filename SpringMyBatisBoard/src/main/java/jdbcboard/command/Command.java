package jdbcboard.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {
	
	public abstract String process(HttpServletRequest request, HttpServletResponse response);

}
