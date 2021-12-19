package com.jsp.board.BoardCommand;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.dao.BoardDao;
import com.jsp.board.dto.Board;
import com.jsp.board.dto.BoardComment;

public class BoardViewCommand implements BoardCommand{
@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("boardNo");
		BoardDao Dao = new BoardDao();
		Board board = new Board();
		board= Dao.getBoardView(no);
		
		List<BoardComment> comments = new ArrayList<>();
		comments = Dao.getListComment(no);
		
		request.setAttribute("comments", comments);
		request.setAttribute("board", board);
	
	}
}
