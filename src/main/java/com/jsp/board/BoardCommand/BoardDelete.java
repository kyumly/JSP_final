package com.jsp.board.BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.dao.BoardDao;

public class BoardDelete implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String boardNo = request.getParameter("boradNo");
		BoardDao dao = new BoardDao();
		int result = dao.deleteBoard(boardNo);
		
		request.setAttribute("deleteResult", result);
	}

}
