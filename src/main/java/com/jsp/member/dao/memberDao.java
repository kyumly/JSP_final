package com.jsp.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.jsp.member.dto.*;


public class memberDao {
	Connection conn = null;
	String sql = null;
	ResultSet rs = null;
	Statement stat = null;
	PreparedStatement pstmt;
	
	
	public memberDao() {


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
	public int insertMember(String id, String pw, String email, String name){
		sql = "insert into members values (?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, email);
			pstmt.setString(4, name);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("회원 추가 오류 : "+e);
		}
		return -1;
	}
	
	
	public int login(String userId, String userPw) {
		String SQL = "SELECT userpw FROM members WHERE userId = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPw)) {
					return 1;
				}
				else {
					return 0; //비밀번호 불일치;
				}
			}
			return -1; // 아이디 없음
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -2;
	}
	
	public Members getMember(String userId) {
 		Members user = new Members();
 		
		String sql = "select * FROM members WHERE userId = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user.setUserId(rs.getString(1));
				user.setUserpw(rs.getString(2));
				user.setEamil(rs.getString(3));
				user.setUserName(rs.getString(4));
			}
		}catch (Exception e) {
			System.out.println("모든 검색 오류 : "+e);
		}
		
		return user;
	}
	
	public int updateForm(String id, String pw, String email,  String name) {
		int result = 0;
		String sql = "update members set userPw = ?, uesrname = ?, usereamil = ? where userid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			result =  pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("회원 정보 업데이트 오류 : "+e);
		}
		return result;
	}
}

	
