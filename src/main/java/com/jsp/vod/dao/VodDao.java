package com.jsp.vod.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.vod.dto.Vod;

public class VodDao {

	Connection conn = null;
	String sql = null;
	ResultSet rs = null;
	Statement stat = null;
	PreparedStatement pstmt;
	
	
	public VodDao() {


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
	
	public	List<Vod>  getVodList(String kind) {
		List<Vod> lists = new ArrayList<>();
		

		sql = "select * FROM movies where movieKind = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vod vod = new Vod();
				vod.setMovieId(rs.getString(1));
				vod.setMovieContnet(rs.getString(2));
				vod.setMovieYear(rs.getString(3));
				vod.setMovieFileName(rs.getString(4));
				vod.setMovieKind(rs.getString(5));
				vod.setMovieName(rs.getString(6));
				lists.add(vod);
			}
		}catch (Exception e) {
			System.out.println(" : " + e);
		}
		return lists;
	}
	
	public Vod getVod(String vodId) {
		Vod vod = new Vod();
		sql = "select * FROM movies where movieId = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vodId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vod.setMovieId(rs.getString(1));
				vod.setMovieContnet(rs.getString(2));
				vod.setMovieYear(rs.getString(3));
				vod.setMovieFileName(rs.getString(4));
				vod.setMovieKind(rs.getString(5));
				vod.setMovieName(rs.getString(6));
			}
		}catch (Exception e) {
			System.out.println(" : " + e);
		}
		return vod;
	}
	
	public	List<Vod>  getVodList() {
		List<Vod> lists = new ArrayList<>();
		
		sql = "select * FROM movies order by cast(movieId as unsigned) desc limit 0, 4";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vod vod = new Vod();
				vod.setMovieId(rs.getString(1));
				vod.setMovieContnet(rs.getString(2));
				vod.setMovieYear(rs.getString(3));
				vod.setMovieFileName(rs.getString(4));
				vod.setMovieKind(rs.getString(5));
				vod.setMovieName(rs.getString(6));
				lists.add(vod);
			}
		}catch (Exception e) {
			System.out.println(" : " + e);
		}
		return lists;
	}

	public int totalCount(String table, String kind) {
		int result = 0;
		String sql = "select count(*) FROM "+ table+ " where movieKind = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println("VOD 페이징 오류 : "+e);
		}
		return result;
	}
	public	List<Vod>  getVodList(String table, String kind, int start, int pageCnt) {
		List<Vod> lists = new ArrayList<>();
		

		sql = "select * FROM "+table+" where movieKind = ? order by 1 limit ?, ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			pstmt.setInt(2, start);
			pstmt.setInt(3, pageCnt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vod vod = new Vod();
				vod.setMovieId(rs.getString(1));
				vod.setMovieContnet(rs.getString(2));
				vod.setMovieYear(rs.getString(3));
				vod.setMovieFileName(rs.getString(4));
				vod.setMovieKind(rs.getString(5));
				vod.setMovieName(rs.getString(6));
				lists.add(vod);
			}
		}catch (Exception e) {
			System.out.println(" : " + e);
		}
		return lists;
	}
}
