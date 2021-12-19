package com.jsp.member.Logincommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.member.dao.memberDao;
import com.jsp.member.dto.Members;

public class myUpdateCommand implements LoginCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userId = (String)request.getSession().getAttribute("userId");
		memberDao dao = new memberDao();
		Members member = new Members();
		member =dao.getMember(userId);
		request.setAttribute("member", member);
	}

}
