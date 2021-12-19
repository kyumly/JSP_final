package com.jsp.board.BoardCommand;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.dao.BoardDao;
import com.jsp.board.dto.Board;

public class BoardListSearch implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao Dao = new BoardDao();
		List<Board> lists = new ArrayList<>();
		String searchKind = request.getParameter("searchKind");
		String search = request.getParameter("search");
		int count = Dao.totalCount("board", searchKind, "%"+search+"%");
		String tempStart = request.getParameter("page");
		int start = 0;
		int end = 10;
		
		count = (int)Math.ceil((double)count/(double)end);
		if(tempStart != null) {
			start = (Integer.parseInt(tempStart)-1)*end;
		}
		
		lists = Dao.getBoardList("board", start, end, searchKind, "%"+search+"%");
		
		request.setAttribute("counts", count);
		request.setAttribute("lists", lists);
		request.setAttribute("kind", searchKind);
		request.setAttribute("content", search);

		
		//�˻������� ����¡��, �׳� ����Ʈ ����¡ �����ϱ� ���� �ñ׳��� �������
		request.setAttribute("searchCnt", 1);
	}
}
