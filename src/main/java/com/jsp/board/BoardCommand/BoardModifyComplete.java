package com.jsp.board.BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.dao.BoardDao;

public class BoardModifyComplete implements BoardCommand {
@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("boardNo");
		String newTitle =request.getParameter("boardTitle");
		String newContent =request.getParameter("boardContext");
		BoardDao Dao = new BoardDao();
		int result  = Dao.updateBoard(no, newTitle, newContent);
		
		request.setAttribute("updateResult", result);
	}
}
