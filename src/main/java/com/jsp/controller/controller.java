package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.member.Logincommand.*;
import com.jsp.board.BoardCommand.BoardAddSuggention;
import com.jsp.board.BoardCommand.BoardCommand;
import com.jsp.board.BoardCommand.BoardCommentDelete;
import com.jsp.board.BoardCommand.BoardCommentWrite;
import com.jsp.board.BoardCommand.BoardDelete;
import com.jsp.board.BoardCommand.BoardListCommand;
import com.jsp.board.BoardCommand.BoardListSearch;
import com.jsp.board.BoardCommand.BoardModifyCommand;
import com.jsp.board.BoardCommand.BoardModifyComplete;
import com.jsp.board.BoardCommand.BoardViewCommand;
import com.jsp.board.BoardCommand.BoardWriteCommand;
import com.jsp.vod.VodCommand.VodCommand;
import com.jsp.vod.VodCommand.VodListCommand;
import com.jsp.vod.VodCommand.VodViewCommand;

/**
 * Servlet implementation class controller
 */
@WebServlet("*.do")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqController(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqController(request, response);
	}
	
	protected void reqController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=EUC-KR");

		String view = null;
		BoardCommand Bocommand = null;
		LoginCommand Lgcommand = null;	
		VodCommand vCommand = null;
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String com = uri.substring(path.length());
		
		int selectKind = 0;
		
		if(com.contains("/list.do")) {
			Bocommand = new BoardListCommand();
			Bocommand.execute(request, response);
			view = "/board/movieBoard.jsp";
			selectKind = 1;

		}
		if(com.contains("/listSearch.do")) {
			Bocommand = new BoardListSearch();
			Bocommand.execute(request, response);
			view = "/board/movieBoard.jsp";
			selectKind = 1;
		}
		if(com.contains("/contentView.do")) {
			Bocommand = new BoardViewCommand();
			Bocommand.execute(request, response);
			view = "/board/contentView.jsp";
			selectKind = 1;
		}
		if(com.contains("/boardSuggestions.do")) {
			Bocommand = new BoardAddSuggention();
			Bocommand.execute(request, response);
			view = "/board/BoardResult.jsp";
			selectKind = 2;
		}
		if(com.contains("/boardWrited.do")) {
			view = "/board/boardWrite.jsp";
			selectKind = 2;
		}
		if(com.contains("/boardWrite.do")) {
			Bocommand = new BoardWriteCommand();
			Bocommand.execute(request, response);
			view = "/board/movieBoard.jsp";
			selectKind = 2;
		}
		if(com.contains("/boardModify.do")) {
			Bocommand = new BoardModifyCommand();
			Bocommand.execute(request, response);
			view = "/board/boardModify.jsp";
			selectKind = 2;
		}
		if(com.contains("/boardModifyComplete.do")) {
			Bocommand = new BoardModifyComplete();
			Bocommand.execute(request, response);
			view = "/board/movieBoard.jsp";
			selectKind = 2;
		}
		if(com.contains("/boardDelete.do")) {
			Bocommand = new BoardDelete();
			Bocommand.execute(request, response);
			view = "/board/movieBoard.jsp";
			selectKind = 2;
		}
		if(com.contains("/boardCommentWrite.do")) {
			String no = request.getParameter("boardNo");
			Bocommand = new BoardCommentWrite();
			Bocommand.execute(request, response);
			response.sendRedirect("contentView.do?boardNo="+no);
			return;
		}
		if(com.contains("/CommentDelete.do")) {
			Bocommand = new BoardCommentDelete();
			Bocommand.execute(request, response);
			view = "/board/BoardResult.jsp";
			selectKind = 2;
		}
		
		if(com.contains("/vodList.do")) {
			vCommand = new VodListCommand();
			vCommand.execute(request, response);
			view = "/vodList/vodlist.jsp";
			selectKind = 1;
		}
		if(com.contains("/vodView.do")) {
			vCommand = new VodViewCommand();
			vCommand.execute(request, response);
			view = "/vodList/vodPopup.jsp";
			selectKind = 1;
		}
		
		if(com.contains("/mylist.do")) {
			Lgcommand = new myUpdateCommand();
			Lgcommand.execute(request, response);
			view = "/login/mypage.jsp";
			selectKind = 1;
		}
		
		if(com.contains("/mypageUpdate.do")) {
			Lgcommand = new mypageUpdateCommand();
			Lgcommand.execute(request, response);
			return;
		}
		if(com.contains("/insert.do")) {
			Lgcommand = new LoginJoinCommand();
			Lgcommand.execute(request, response);
			return;
			//view = "/202044003_final/index.jsp";
			//selectKind = 1;
			
		}
		
		if(com.contains("/loginAction.do")) {
			Lgcommand  = new LoginActionCommand();
			Lgcommand.execute(request, response);
			return;
		}
		
		if(com.contains("/logoutAction.do")) {
			Lgcommand = new LogoutActionCommand();
			Lgcommand.execute(request, response);
			view = "/202044003_final/index.jsp";
			response.sendRedirect(view);
			return;
			
		}
		
		if(selectKind == 1) {
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.include(request, response);
		}else if(selectKind == 2) {
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}

	}

}
