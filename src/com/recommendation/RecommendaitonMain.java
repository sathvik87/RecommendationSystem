package com.recommendation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.recommendation.parsers.UserDataParser;
import com.recommendation.utils.Constants;
import com.recommendation.utils.Utils;

public class RecommendaitonMain {
	public static void main(String args[]) {
		System.out.print("Hello World!!");

		
		UserDataParser userdataparser = new UserDataParser(Constants.USER_DATA_SRC);
		userdataparser.convertRawToJSON();
		
		/*UserItemParser useritemparser = new UserItemParser(Constants.USER_ITEM_SRC);
		useritemparser.convertRawToJSON();*/

		try {
			Utils.similarityDistance(Utils.readFile("data/u.json",  StandardCharsets.UTF_8), "196", "22");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
