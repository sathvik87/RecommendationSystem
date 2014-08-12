package com.recommendation.pojo;

public class UserRating {
	private int rating;
	private int movieId;
	
	public UserRating(int rate, int mid) {
		rating = rate;
		movieId = mid;
	}
	
	public int getRating() {
		return rating;
	}
	
	public int getMovieId() {
		return movieId;
	}
}
