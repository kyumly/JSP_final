package com.jsp.member.Logincommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.jsp.member.dao.*;
public class LoginActionCommand implements LoginCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		memberDao dao = new memberDao();
		int result = dao.login(id, pw);
		PrintWriter out;
		try {
			out = response.getWriter();
			if(result == 1) {
				request.setAttribute("�α��� ����", "pwSu");
				request.getSession().setAttribute("userId", id);
				out.print("<script>");
				out.print("alert('�α��� ����');");
				out.print("location.href='/202044003_final/index.jsp'");
				out.print("</script>");
				out.close();
			}
			else if(result == 0) {
				out.print("<script>");
				out.print("alert('��й�ȣ Ʋ��');");
				out.print("location.href='/202044003_final/index.jsp'");
				out.print("</script>");
				out.close();
			}
			else {
				out.print("<script>");
				out.print("alert('���̵� Ʋ��');");
				out.print("location.href='/202044003_final/index.jsp'");
				out.print("</script>");
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
