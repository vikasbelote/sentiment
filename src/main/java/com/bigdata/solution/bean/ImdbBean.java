package com.bigdata.solution.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbBean {
	
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Year")
	private String year;
	
	@JsonProperty("imdbRating")
	private String rating;
	
	@JsonProperty("Response")
	private Boolean response;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Boolean getResponse() {
		return response;
	}

	public void setResponse(Boolean response) {
		this.response = response;
	}
	
}
