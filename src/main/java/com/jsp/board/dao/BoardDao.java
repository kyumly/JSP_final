package com.jsp.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.board.dto.Board;
import com.jsp.board.dto.BoardComment;

public class BoardDao {
	Connection conn = null;
	String sql = null;
	ResultSet rs = null;
	Statement stat = null;
	PreparedStatement pstmt;
	
	
	public BoardDao() {


		String url = "jdbc:mysql://localhost:3306/a202044003?"+
						"useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String user = "root";
		String pw = "rootpw";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
		}catch (Exception e) {
			System.out.println("DB연동 실패 : " + e);;
		}
	
	}
	
	public	List<Board>  getBoardList() {
		List<Board> lists = new ArrayList<>();
		

		sql = "select * FROM board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBoardno(rs.getInt(1)); 
				board.setUserId(rs.getString(2));
				board.setBoardtitle(rs.getString(3));
				board.setBoardDate(rs.getString(4));
				board.setBoardContent(rs.getString(5));
				board.setBoardCount(rs.getInt(6));
				board.setboardSuggestions(rs.getInt(7));
				board.setBoardWriter(rs.getString(8));
				lists.add(board);
			}
		}catch (Exception e) {
			System.out.println("계시판 불러오기 오류 : " + e);
		}
		return lists;
	}
	
	public	List<Board>  getBoardList(String table, int start, int pageCnt) {
		List<Board> lists = new ArrayList<>();
		
		sql = "select * FROM "+table+" order by 1 desc limit ?, ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, pageCnt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBoardno(rs.getInt(1)); 
				board.setUserId(rs.getString(2));
				board.setBoardtitle(rs.getString(3));
				board.setBoardDate(rs.getString(4));
				board.setBoardContent(rs.getString(5));
				board.setBoardCount(rs.getInt(6));
				board.setboardSuggestions(rs.getInt(7));
				board.setBoardWriter(rs.getString(8));
				lists.add(board);
			}
		}catch (Exception e) {
			System.out.println("계시판 불러오기 오류 : " + e);
		}
		return lists;
	}
	
	public	List<Board>  getBoardList(String table, int start, int pageCnt, String kind, String search) {
		List<Board> lists = new ArrayList<>();
		sql = "select * FROM "+table+" where " + kind + " like ? order by 1 desc limit ?, ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, start);
			pstmt.setInt(3, pageCnt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBoardno(rs.getInt(1)); 
				board.setUserId(rs.getString(2));
				board.setBoardtitle(rs.getString(3));
				board.setBoardDate(rs.getString(4));
				board.setBoardContent(rs.getString(5));
				board.setBoardCount(rs.getInt(6));
				board.setboardSuggestions(rs.getInt(7));
				board.setBoardWriter(rs.getString(8));
				lists.add(board);
			}
		}catch (Exception e) {
			System.out.println("계시판 불러오기 오류 : " + e);
		}
		return lists;
	}
	
	public Board getBoardView(String boardno) {
		Board board = new Board();
		Boardcount(boardno);
		
		sql = "select * FROM board where boardNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setBoardno(rs.getInt(1)); 
				board.setUserId(rs.getString(2));
				board.setBoardtitle(rs.getString(3));
				board.setBoardDate(rs.getString(4));
				board.setBoardContent(rs.getString(5));
				board.setBoardCount(rs.getInt(6));
				board.setboardSuggestions(rs.getInt(7));
				board.setBoardWriter(rs.getString(8));
				board.setBoardUrl(rs.getString(9));
				board.setFileName(rs.getString(10));
			}
		}catch (Exception e) {
			System.out.println("게시글 불러오기 오류 : " + e);
		}
		return board;
		
	}

	private void Boardcount(String boardno) {
		sql = "update board set boardCount = boardCount + 1 WHERE boardNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardno);
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("게시글 불러오기 오류 : " + e);
		}
		
	}
	
	public int insertBoard(String userId, String Title, String date, String content, int count, int suggention,  String Uri, String fileName){
		int maxcount =maxCount();
		maxcount = maxcount+1;
		String name = getName(userId);
		sql = "insert into board values (?, ?, ? , ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxcount);
			pstmt.setString(2, userId);
			pstmt.setString(3, Title);
			pstmt.setString(4, date);
			pstmt.setString(5, content);
			pstmt.setInt(6, count);
			pstmt.setInt(7, suggention);
			
			pstmt.setString(8, name);
			pstmt.setString(9, Uri);
			pstmt.setString(10, fileName);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("게시판 추가 오류  : " + e);
		}
		return -1;
	}

	private String getName(String id) {
		sql = "select uesrName FROM members where userId = ?";
		String result = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getNString(1);
			}
		}catch (Exception e) {
			System.out.println("검색오류 : " + e);
		}
		return result;
	}

	private int maxCount() {
		sql = "select max(boardNo) FROM board";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println("최댓값 오류 : " + e);
		}
		return result;
		
		
	}
	
	
	public List<BoardComment> getListComment(String boardNo) {
		List<BoardComment> lists = new ArrayList<>();
		String sql = "select * FROM boardComment where boardNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardComment comment = new BoardComment();
				comment.setCommentContent(rs.getString(1));
				comment.setUserId(rs.getString(2));
				comment.setBoardNo(rs.getInt(3));
				comment.setDate(rs.getString(4));
				comment.setCommentNo(rs.getInt(5));
				lists.add(comment);
			}
		}catch (Exception e) {
			System.out.println("댓글 불러오기 오류 : " + e);
		}
		return lists;
	}
	
	public List<String> getinForm(String boardNo) {
		List<String> lists = new ArrayList<>();
		sql = "select boardTitle, boardContent, boardNo FROM board WHERE boardNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				lists.add(rs.getString(1));
				lists.add(rs.getString(2));
				lists.add(rs.getString(3));
			}
		}catch (Exception e) {
			System.out.println("게시물 수정 오류 1 : " + e);
		}
		return lists;
	}
	
	public int updateBoard(String no, String newTitle, String newContent) {
		sql = "update board set boardTitle = ?, boardContent = ?  WHERE boardNo = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newTitle);
			pstmt.setString(2, newContent);
			pstmt.setString(3, no);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("게시판 업데이트 오류 : "+e);
		}
		return result;
	}
	
	public int deleteBoard(String boardNo) {
		int result = 0;
		sql = "delete FROM board WHERE boardNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("게시판 삭제 오류 : "+e);
		}
		
		sql = "delete FROM boardComment WHERE boardNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			result += pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("댓글 삭제 오류 (게시판) : "+e);
		}
		
		sql = "delete FROM suggestions WHERE boardNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			result += pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("추천 삭제 오류 (게시판) : "+e);
		}
		
		
		return result;
	}
	
	public int insertComment(String comment, String userId, String boardNo, String now){
		int maxCount = maxCountComment();
		maxCount = maxCount+1;
		
		sql = "insert into boardComment values(?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment);
			pstmt.setString(2, userId);
			pstmt.setString(3, boardNo);
			pstmt.setString(4, now);
			pstmt.setInt(5, maxCount);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("댓글오류  : " + e);
		}
		return -1;
	}
	
	private int maxCountComment() {
		sql = "select max(commentno) FROM boardComment";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println("최댓값 오류 : " + e);
		}
		return result;
		
		
	}

	public int deleteComment(String commentNo) {
		sql = "delete FROM boardComment where commentNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commentNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("댓글오류  : " + e);
		}
		return -1;
	}
	
	
	public int totalCount(String table) {
		int result = 0;
		String sql = "select count(*) FROM "+ table;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println("총 갯수 불러오기 오류 : "+e);
		}
		return result;
		
	}
	
	public int totalCount(String table, String kind, String search) {
		int result = 0;
		String sql = "select count(*) FROM "+table+" where " + kind + " like ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,search);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println("총 (선택)갯수 불러오기 오류 : "+e);
		}
		return result;
		
	}

	public int suggentionCheck(String userId, String boardNo) {
		int result = 0;
		String sql = "select suggestion FROM suggestions WHERE userId = ? and boardNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, boardNo);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println("추천수 체크 불러오기 에러 : "+e);
		}
		return result;
		
	}

	public int suggentionUpdate(String userId, String boardNo) {
		int result = 0;
		int suggentionsCount = suggentionCount(boardNo);
		String sql = "insert into suggestions values (?, ?, 1)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, boardNo);
			result =  pstmt.executeUpdate();
			suggestionBoardUpdate(boardNo, (suggentionsCount+1));
			return result;
		}catch (Exception e) {
			System.out.println("추천하기 오류 : "+e);
		}
		return result;
	}

	
	private int suggentionCount(String boardNo) {
		int result = 0;
		String sql = "select count(*) FROM suggestions where boardNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println("총 추천 갯수 오류 : "+e);
		}
		return result;
		
	}

	
	private int suggestionBoardUpdate(String boardNo, int suggentionCount) {
		sql = "update board set boardSuggestions = ? where boardNo = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, suggentionCount);
			pstmt.setString(2, boardNo);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("게시판 업데이트 오류 : "+e);
		}
		return result;
		
	}

	public int suggentiondelete(String userId, String boardNo) {
		int result = 0;
		int suggentionsCount = suggentionCount(boardNo);
		String sql = "delete FROM suggestions where userId = ? and boardNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, boardNo);
			result =  pstmt.executeUpdate();
			suggestionBoardUpdate(boardNo, suggentionsCount-1);
			return result;
		}catch (Exception e) {
			System.out.println("추천하기 오류 : "+e);
		}
		return result;
	}
}
