package com.jsp.member.Logincommand;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jsp.member.dao.*;

public class LoginJoinCommand implements LoginCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("userId");
		String pw = request.getParameter("userPw");
		String name = request.getParameter("userName");
		String email = request.getParameter("userEmail");
		
		memberDao dao = new memberDao();
		int resultJoin =dao.insertMember(id, pw, email, name);
		PrintWriter out;
		try {
			out = response.getWriter();
			if(resultJoin > 0) {
				out.print("<script>");
				out.print("alert('회원가입 성공');");
				out.print("location.href='/202044003_final/index.jsp'");
				out.print("</script>");
				out.close();
			}else if (resultJoin < 0){
				out.print("<script>");
				out.print("alert('아이디 중복');");
				out.print("history.go(-1);");
				out.print("</script>");
				out.close();
			}

		}catch (Exception e) {
			System.err.println("에러발생");
		}
	}
	
}
