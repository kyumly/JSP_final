package com.jsp.board.BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.dao.BoardDao;

public class BoardAddSuggention implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userId = (String)request.getSession().getAttribute("userId");
		String boardNo = request.getParameter("boradNo");
		int suggestionResult = 0;
		
		BoardDao dao = new BoardDao();
		int result = dao.suggentionCheck(userId, boardNo);
		if(result == 0) {
			suggestionResult = dao.suggentionUpdate(userId, boardNo);

		}
		else if(result == 1){
			suggestionResult = dao.suggentiondelete(userId, boardNo);
			if (suggestionResult == 1) suggestionResult = 0;

		}
		else {
			System.out.println("디비에서 오류가 발생했습니다.");
		}
		request.setAttribute("suggestionResult", suggestionResult);
		request.setAttribute("boardNo", boardNo);
	}

}
