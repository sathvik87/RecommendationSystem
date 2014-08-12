package com.recommendation.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

import com.recommendation.UserData;
import com.recommendation.pojo.UserDataPOJO;
import com.recommendation.utils.Constants;

public class UserDataParser {
	private String filepath;
	public UserDataParser(String path) {
		filepath = path;
	}
	
	public void convertRawToJSON() {
		String line;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filepath));
			
			UserData userdata = new UserData();
			ArrayList<UserDataPOJO> users_data = new ArrayList<UserDataPOJO>();

			while ((line = br.readLine()) != null) {
				String[] items = line.split("\\t");
				users_data.add(new UserDataPOJO(Integer.parseInt(items[0]), Integer.parseInt(items[1]),
						Integer.parseInt(items[2])));
			}
			br.close();
			userdata.setUserData(users_data);
			//String jsonstr = new ObjectMapper()
			//		.writeValueAsString(userdata);
			
			File resultfile = new File(Constants.USER_DATA_DEST);
			resultfile.createNewFile();
			
			new ObjectMapper()
			.writeValue(resultfile, userdata);
			
			//print(jsonstr);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e1) {
			e1.printStackTrace();
		} 
	}
}
