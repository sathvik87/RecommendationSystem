package com.recommendation.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

import com.recommendation.UserItem;
import com.recommendation.pojo.UserItemPOJO;
import com.recommendation.utils.Constants;
import com.recommendation.utils.Utils;

public class UserItemParser {
	private String filepath;
	public UserItemParser(String path) {
		filepath = path;
	}
	
	public void convertRawToJSON() {
		String line;
		BufferedReader br;
		try {
			ArrayList<UserItemPOJO> user_items = new ArrayList<UserItemPOJO>();
			br = new BufferedReader(new FileReader(filepath));
			
			while ((line = br.readLine()) != null) {
				String[] items1 = line.split("\\|");
				user_items.add(new UserItemPOJO(items1[0], items1[1],
						items1[4]));
			}
			br.close();
			UserItem useritem = new UserItem(user_items);
			String jsonstr = new ObjectMapper()
					.writeValueAsString(useritem);
			
			File uifile = new File(Constants.USER_ITEM_DEST);
			uifile.createNewFile();
			
			new ObjectMapper()
			.writeValue(uifile, useritem);
			
			Utils.print(jsonstr);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e1) {
			e1.printStackTrace();
		} 
	}
}
