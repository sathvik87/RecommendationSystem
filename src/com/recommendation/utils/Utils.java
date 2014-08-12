package com.recommendation.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.recommendation.pojo.UserRating;

public class Utils {

	public static void print(String s) {
		System.out.println(s);
	}

	public static void print(int len) {
		System.out.println(len);
	}

	public static String readFile(String path, Charset encoding)
			throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	// Calculate the similarity distance(Euclidean distance)
	public static double similarityDistance(String prefs, String userid1,
			String userid2) {
		try {
			ObjectMapper m = new ObjectMapper();
			JsonNode rootNode = m.readTree(prefs);
			JsonNode usersnode = rootNode.get("users");
			
			HashMap<String, ArrayList<UserRating>> user2Ratings = new HashMap<String, ArrayList<UserRating>>();
			ArrayList<UserRating> user1ratings = new ArrayList<UserRating>();
			ArrayList<UserRating> user2ratings = new ArrayList<UserRating>();
			for( JsonNode user : usersnode) {
				
				if(userid1.equals(user.get("userId")+"")) {
					user1ratings.add(new UserRating(user.get("rating").asInt(), user.get("movieId").asInt()));
				}
				if(userid2.equals(user.get("userId")+"")) {
					user2ratings.add(new UserRating(user.get("rating").asInt(), user.get("movieId").asInt()));
				}
			}
			
			user2Ratings.put(userid1, user1ratings);
			user2Ratings.put(userid2, user2ratings);
			
			//Check if users have ratings for same movies, 
			//square them up and add all of them.
			double sum_of_squares = 0 ;
			for( UserRating user1rating : user1ratings) {
				int movieid1 = user1rating.getMovieId();
				for(UserRating user2rating : user2ratings) {
					if(movieid1 == user2rating.getMovieId() ) {
						sum_of_squares = sum_of_squares + Math.pow((user1rating.getRating() - user2rating.getRating()),2) ;
					}
				}
			}
			
			double normalized_eucl_dist = (1/(1+Math.sqrt(sum_of_squares)));
			print(""+normalized_eucl_dist);
			return normalized_eucl_dist;
			
			//Utils.print(user2Ratings);
			/*Utils.print(new ObjectMapper()
					.writeValueAsString(user2ratings));*/

			//Utils.print(ar.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;

	}

}
