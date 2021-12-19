package com.jsp.board.BoardCommand;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.dao.BoardDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteCommand implements BoardCommand{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		
		/*파일처리 부분  */
		String dir = "/resource/movieImage";
		String path = request.getRealPath(dir);
		
		int max = 1024 * 1024 * 10;
		
		MultipartRequest mr = null;
		try {
			mr =
					new MultipartRequest(request, path, max, "utf-8",
							new DefaultFileRenamePolicy());
		} catch (IOException e) {
			System.out.println("파일 업로드 오류 : " + e);
		}
		
		String title = mr.getParameter("boardName");
		String now  = sf.format(date);
		String context = mr.getParameter("boardContext");
		int BoardCount = 0;
		int suggestions = 0;
		String  id = mr.getParameter("userId");
		String fileName = mr.getFilesystemName("file");
		String Url = path+"\\"+fileName;
		
		
		
		BoardDao Dao = new BoardDao();
		Dao.insertBoard(id, title, now, context, BoardCount, suggestions, Url, fileName);
	
		//request.setAttribute("board", board);
	}
}
