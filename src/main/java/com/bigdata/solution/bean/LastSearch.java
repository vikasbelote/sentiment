package com.bigdata.solution.bean;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("lastSearch")
public class LastSearch {
	
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
	private String searchValue;
	
	@Property("lastSearchTime")
	private DateTime lastSearchTime;

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public DateTime getLastSearchTime() {
		return lastSearchTime;
	}

	public void setLastSearchTime(DateTime lastSearchTime) {
		this.lastSearchTime = lastSearchTime;
	}

}
