package com.jsp.vod.VodCommand;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.dao.BoardDao;
import com.jsp.board.dto.Board;
import com.jsp.vod.dao.VodDao;
import com.jsp.vod.dto.Vod;

public class VodListCommand implements VodCommand{
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) {
	VodDao Dao = new VodDao();
	String kind = request.getParameter("movieKind");
	List<Vod> lists = new ArrayList<>();
	
	lists = Dao.getVodList(kind);
	
	int count = Dao.totalCount("movies", kind);
	String tempStart = request.getParameter("page");
	int start = 0;
	int end = 6;
	
	count = (int)Math.ceil((double)count/(double)end);
	if(tempStart != null) {
		start = (Integer.parseInt(tempStart)-1)*end;
	}
	lists = Dao.getVodList("movies", kind, start, end);
	
	request.setAttribute("counts", count);
	request.setAttribute("vodLists", lists);
	request.setAttribute("Kind", kind);
	}
}
