package com.bigdata.solution.bean;

import org.bson.types.ObjectId;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("tweet")
public class TweetBean {
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	@Id
    @Property("id")
    private ObjectId id;
	
	@Property("searchValue")
	private String serachValue;
	
	@Property("tweetText")
	private String tweetText;
	
	@Property("tweetTime")
	private Date tweetTime;
	
	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public String getSerachValue() {
		return serachValue;
	}

	public void setSerachValue(String serachValue) {
		this.serachValue = serachValue;
	}

	public Date getTweetTime() {
		return tweetTime;
	}

	public void setTweetTime(Date tweetTime) {
		this.tweetTime = tweetTime;
	}
	
	
	

}
