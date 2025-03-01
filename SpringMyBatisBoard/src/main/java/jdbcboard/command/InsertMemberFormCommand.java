package jdbcboard.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertMemberFormCommand implements Command {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		return "/jsp/member/insertMemberForm.jsp";
	}

}
