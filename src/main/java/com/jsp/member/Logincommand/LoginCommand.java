package com.jsp.member.Logincommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
	
}
