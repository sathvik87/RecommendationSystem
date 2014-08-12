package com.recommendation;

import java.util.List;

import com.recommendation.pojo.UserDataPOJO;

public class UserData {
	private List<UserDataPOJO> users;
	
	public void setUserData(List<UserDataPOJO> usersdataObj) {
		users = usersdataObj;
	}	
	
	public List<UserDataPOJO> getUsers(){ 
		return users;
	}
}
