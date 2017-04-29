package com.bigdata.solution.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bigdata.solution.bean.SentimentScoreBean;
import com.bigdata.solution.bean.SentimentScoreCountPercent;
import com.bigdata.solution.bean.TweetBean;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

@Component
public class SentimentService {
	
	
	StanfordCoreNLP pipeline;
	
	@PostConstruct
	public void init() {
        Properties prop = new Properties();
        prop.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        pipeline = new StanfordCoreNLP(prop);
	}
	
	public int findSentiment(String tweet) {

		int mainSentiment = 0;
		if (tweet != null && tweet.length() > 0) {
			int longest = 0;
			Annotation annotation = pipeline.process(tweet);
			for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
				
				Tree tree = sentence.get(SentimentAnnotatedTree.class);
				int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
				
				String partText = sentence.toString();
				if (partText.length() > longest) {
					mainSentiment = sentiment;
					longest = partText.length();
				}

			}
		}
		return mainSentiment;
	}
	
	public  List<SentimentScoreBean> processTweets(List<TweetBean> tweetBeanList){
		
		List<SentimentScoreBean> list = new ArrayList<SentimentScoreBean>();
		//init();
		for(TweetBean tweetBean : tweetBeanList){
			
			int score = findSentiment(tweetBean.getTweetText());
			
			SentimentScoreBean sentimentScoreBean = new SentimentScoreBean();
			sentimentScoreBean.setScore(score);
			
			if(score == 1){
				sentimentScoreBean.setGrade("NEUTRAL");
			} else if(score == 2) {
				sentimentScoreBean.setGrade("NEGATIVE");
			}else if(score >= 3 ) {
				sentimentScoreBean.setGrade("POSITIVE");
			}
			
			sentimentScoreBean.setTweetText(tweetBean.getTweetText());
			
			SimpleDateFormat expectedFormat = new SimpleDateFormat("dd-MM-yy :HH:mm:SS"); 
			
			String dt = expectedFormat.format(tweetBean.getTweetTime());
			sentimentScoreBean.setTweetTime(dt);
			
			list.add(sentimentScoreBean);
		}
		return list;
		
	}

	
	public List<SentimentScoreCountPercent> tweetAnalysis(List<SentimentScoreBean> sentimentScoreBeanList) {
		
		Map<Integer, Integer> scoreCountMap = new HashMap<Integer, Integer>();
		for(SentimentScoreBean sentimentScoreBean : sentimentScoreBeanList) {
			
			Integer score = sentimentScoreBean.getScore();
			
			Integer scoreCount = scoreCountMap.get(score);
			if(scoreCount == null) {
				scoreCountMap.put(score, 1);
			}
			else {
				scoreCountMap.put(score, scoreCount + 1);
			}
		}
		
		Integer totalTweetBeanCount = sentimentScoreBeanList.size();
		
		List<SentimentScoreCountPercent> sentimentScoreCountPercentList = new ArrayList<SentimentScoreCountPercent>();
		for(Map.Entry<Integer, Integer> entry : scoreCountMap.entrySet()) {
			
			SentimentScoreCountPercent sentimentScoreCountPercent = new SentimentScoreCountPercent();
			
			sentimentScoreCountPercent.setScore(entry.getKey()); 
			sentimentScoreCountPercent.setCount(entry.getValue());
			
			Integer percentageCount = (100 * sentimentScoreCountPercent.getCount())/totalTweetBeanCount;
			sentimentScoreCountPercent.setPercent(percentageCount);
			
			sentimentScoreCountPercentList.add(sentimentScoreCountPercent);
		}
		
		return sentimentScoreCountPercentList;
	}

}
