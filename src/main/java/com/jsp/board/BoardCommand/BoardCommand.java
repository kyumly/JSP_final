package com.jsp.board.BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
