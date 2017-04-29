package com.bigdata.solution.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Component;

import com.bigdata.solution.bean.ImdbBean;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class IMDBService {

	
	public ImdbBean getMoviesRating(String movieName) {
		
		ImdbBean imdbBean = null;
		
		try {
			
			String url = "http://www.omdbapi.com/?t=" + movieName;
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			//con.setRequestProperty("User-Agent", USER_AGENT);
			
			int responseCode = con.getResponseCode();
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());			
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			imdbBean = mapper.readValue(response.toString(), ImdbBean.class);
			
			

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		return imdbBean;
	}
	
	
	
}
