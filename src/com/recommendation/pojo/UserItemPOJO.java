package com.recommendation.pojo;

public class UserItemPOJO {
	private String movieid;
	private String mtitle;
	private String imdburl;
	public UserItemPOJO(String id, String title , String url) {
		movieid = id;
		mtitle = title;
		imdburl = url;
	}
	
	public String getMovieId() {
		return movieid;
	}
	
	public String getMovieTitle() {
		return mtitle;
	}
	
	public String getImdbUrl() {
		return imdburl;
	}
}
