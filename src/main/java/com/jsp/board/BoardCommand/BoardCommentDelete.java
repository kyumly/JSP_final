package com.jsp.board.BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.dao.BoardDao;

public class BoardCommentDelete  implements BoardCommand{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao Dao = new BoardDao();
		String CommentNo = request.getParameter("commentNo");
		int result = Dao.deleteComment(CommentNo);
		String boardNo = request.getParameter("boardNo");
		
		request.setAttribute("commentResult", result);
		request.setAttribute("boardNo", boardNo);
	}	
}
