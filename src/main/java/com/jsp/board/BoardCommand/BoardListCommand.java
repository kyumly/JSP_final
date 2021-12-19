package com.jsp.board.BoardCommand;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.dao.BoardDao;
import com.jsp.board.dto.Board;


public class BoardListCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao Dao = new BoardDao();
		List<Board> lists = new ArrayList<>();
		int count = Dao.totalCount("board");
		String tempStart = request.getParameter("page");
		int start = 0;
		int end = 10;
		
		count = (int)Math.ceil((double)count/(double)end);
		if(tempStart != null) {
			start = (Integer.parseInt(tempStart)-1)*end;
		}
		lists = Dao.getBoardList("board", start, end);
		
		request.setAttribute("counts", count);
		request.setAttribute("lists", lists);
		
	}

}
