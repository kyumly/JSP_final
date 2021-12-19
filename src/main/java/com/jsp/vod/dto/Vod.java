package com.jsp.vod.dto;

public class Vod {
	private String movieId;
	private String movieContnet;
	private String movieYear;
	private String movieFileName;
	private String movieKind;
	private String movieName;
	
	public String getMovieContnet() {
		return movieContnet;
	}
	public String getMovieFileName() {
		return movieFileName;
	}
	public String getMovieId() {
		return movieId;
	}
	public String getMovieKind() {
		return movieKind;
	}
	public String getMovieName() {
		return movieName;
	}
	public String getMovieYear() {
		return movieYear;
	}
	public void setMovieContnet(String movieContnet) {
		this.movieContnet = movieContnet;
	}
	public void setMovieFileName(String movieFileName) {
		this.movieFileName = movieFileName;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public void setMovieKind(String movieKind) {
		this.movieKind = movieKind;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public void setMovieYear(String movieYear) {
		this.movieYear = movieYear;
	}

}
