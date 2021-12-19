package com.jsp.member.Logincommand;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.member.dao.memberDao;

public class mypageUpdateCommand implements LoginCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("userId");
		String pw = request.getParameter("userPw");
		String name = request.getParameter("userName");
		String email = request.getParameter("userEmail");
		
		memberDao dao = new memberDao();
		int result = dao.updateForm(id, pw, email, name);
		PrintWriter out;
		try {
			out = response.getWriter();
			if(result > 0) {
				out.print("<script>");
				out.print("alert('수정 완료');");
				out.print("location.href='/202044003_final/index.jsp'");
				out.print("</script>");
				out.close();
			}else if (result == 0){
				out.print("<script>");
				out.print("alert('수정 에러');");
				out.print("history.go(-1);");
				out.print("</script>");
				out.close();
			}

		}catch (Exception e) {
		}
	}
		//request.setAttribute("member", member);
}

