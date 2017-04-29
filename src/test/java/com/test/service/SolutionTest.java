package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bigdata.solution.app.SolutionConfig;
import com.bigdata.solution.bean.SentimentScoreBean;
import com.bigdata.solution.bean.TweetBean;
import com.bigdata.solution.service.SentimentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SolutionConfig.class})
@WebAppConfiguration
public class SolutionTest {
	
	@Autowired
	private SentimentService sentimentService;
	
	@Test
	public void testSentiment() {
		 
		List<TweetBean> tweetBeanList = new ArrayList<TweetBean>();
		
		TweetBean tweetBean = new TweetBean();
		tweetBean.setTweetText("I like google");
		tweetBeanList.add(tweetBean);
		
		TweetBean tweetBean1 = new TweetBean();
		tweetBean1.setTweetText("I do  like google and it is good site to search");
		tweetBeanList.add(tweetBean1);
		
		TweetBean tweetBean2 = new TweetBean();
		tweetBean2.setTweetText("Nature is very nice");
		tweetBeanList.add(tweetBean2);
		
		TweetBean tweetBean3 = new TweetBean();
		tweetBean3.setTweetText("I hate bollywood and it is very bad movies");
		tweetBeanList.add(tweetBean3);
		
		List<SentimentScoreBean> list = sentimentService.processTweets(tweetBeanList);
		
		for(SentimentScoreBean sentimentScoreBean : list)
			System.out.println(sentimentScoreBean.getTweetText()+ "=>" + sentimentScoreBean.getScore() );
	}
}
