package com.bigdata.solution.bean;

import java.util.Date;

public class SentimentScoreBean {
	
	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	private String tweetText;
	
	private Integer score;
	
	private String grade;
	
	private String tweetTime;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTweetTime() {
		return tweetTime;
	}

	public void setTweetTime(String tweetTime) {
		this.tweetTime = tweetTime;
	}
}
