package com.jsp.board.BoardCommand;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.dao.BoardDao;

public class BoardModifyCommand implements BoardCommand{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) {
		String boardNo = request.getParameter("boradNo");
		BoardDao dao = new BoardDao();
		
		List<String> inform = dao.getinForm(boardNo);
		
		request.setAttribute("inform", inform);
		request.setAttribute("boardNo", boardNo);
		
	}
}
