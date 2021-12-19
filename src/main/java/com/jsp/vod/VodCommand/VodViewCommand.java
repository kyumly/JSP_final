package com.jsp.vod.VodCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.vod.dao.VodDao;
import com.jsp.vod.dto.Vod;

public class VodViewCommand implements VodCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		VodDao Dao = new VodDao();
		String id = request.getParameter("id");
		Vod vod = new Vod();
		vod = Dao.getVod(id);
		request.setAttribute("vod", vod);
		
	}

}
