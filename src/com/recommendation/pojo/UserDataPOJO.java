package com.recommendation.pojo;

public class UserDataPOJO {
	private int userid;
	private int movieid;
	private int rating;
	private String timestamp;

	public UserDataPOJO(int id, int mid, int rate) {
		userid = id;
		movieid = mid;
		rating = rate;
		//timestamp = stamp;
	}

	public int getUserId() {
		return userid;
	}

	public int getMovieId() {
		return movieid;
	}

	public int getRating() {
		return rating;
	}

	//public String getTimeStamp() {
		//return timestamp;
	//}

}
