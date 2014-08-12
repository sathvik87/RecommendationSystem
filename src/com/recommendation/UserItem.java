package com.recommendation;

import java.util.List;

import com.recommendation.pojo.UserItemPOJO;

public class UserItem {
	private List<UserItemPOJO> user_items;

	public UserItem(List<UserItemPOJO> useritemObj) {
		user_items = useritemObj;
	}

	public List<UserItemPOJO> getUserItems() {
		return user_items;
	}
}
