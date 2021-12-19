package com.jsp.board.BoardCommand;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.dao.BoardDao;

public class BoardCommentWrite implements BoardCommand{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		String userId = request.getParameter("userId");
		String comment = request.getParameter("boardContent");
		String boardNo = request.getParameter("boardNo");
		String now = sf.format(date);
		
		BoardDao Dao = new BoardDao();
		Dao.insertComment(comment, userId, boardNo, now);
	}
}
