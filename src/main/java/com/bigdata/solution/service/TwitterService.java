package com.bigdata.solution.service;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;

import com.bigdata.solution.bean.TweetBean;
import com.bigdata.solution.repository.TwitterRepository;



@Component
public class TwitterService {

	
	public List<TweetBean> getTwitterResponse(String searchKey) {
		
		List<TweetBean> list = new ArrayList<TweetBean>();
		
		String consumerKey = "fOmjY6ch8VoTSHHy8PulNgrTE"; // The application's consumer key
		String consumerSecret = "7EjouPuIDPQsh0Tf7z93ZXetVGs0niXqrWmUyL5vT613q8acwL"; // The application's consumer secret
		String accessToken = "839846074730737665-hKDIaB0RjaN1KZSwZ8MSUbNWMzD3FKc"; // The access token granted after OAuth authorization
		String accessTokenSecret = "MmGxyg8m8Bk8h2cwIY1jQinD3qU2BtnBt24Cup7yeh6RN"; // The access token secret granted after OAuth authorization
		
		Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		SearchResults results = twitter.searchOperations().search("#" + searchKey, 50);
		
		
		
		
		if(results != null) {
		
			for(Tweet tweet : results.getTweets()) {
				TweetBean tweetBean = new TweetBean();
				tweetBean.setSerachValue(searchKey);
				
				String tweetText = tweet.getText().replace("@", "");
				tweetText = tweetText.replace("#", "");
				tweetText = tweetText.replace("❤️", "");
				tweetText = tweetText.replace("…", "");
				
				//tweetText = tweetText.replaceAll("[ ](?=[ ])|[^-_,A-Za-z0-9 ]+", "");
				
				tweetBean.setTweetTime(tweet.getCreatedAt());
				
				tweetBean.setTweetText(tweetText);
				
				list.add(tweetBean);
			}
			
			//Map<String, TweetBean> tweetMap = this.getTwitterMap(list);
			//save to database
			TwitterRepository repository = new TwitterRepository();
			repository.saveDataWithMorphia(list);
		}
		return list;
	}
	
//	public Map<String, TweetBean> getTwitterMap(List<TweetBean> list) {
//		
//		Map<String, TweetBean> tweetMap = new HashMap<String, TweetBean>();
//		
//		Integer counter = new Integer(0);
//		for(TweetBean tweetBean : list) {
//			
//			String index = String.valueOf(counter);
//			tweetMap.put(index, tweetBean);
//			counter = counter + 1;
//		}
//		
//		return tweetMap;
//		
//	}

}
