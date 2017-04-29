package com.bigdata.solution.repository;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import java.util.List;
import java.util.Map;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;

import com.bigdata.solution.bean.TweetBean;
import com.mongodb.DB;
import com.mongodb.MongoClient;



public class TwitterRepository {
	
	public  void save(List<TweetBean> list) {
		
		  try{   
	  		
	          // To connect to mongodb server
	          MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	 			
	          // Now connect to your databases
	          DB db = mongoClient.getDB( "mydb" );
	          System.out.println("Connect to database successfully");
	 			
	          
	                
	          DBCollection coll = db.getCollection("tweet");
	          System.out.println("Collection mycol selected successfully");
	          
	          BasicDBObject dbObject = new BasicDBObject();
	          List<Object> tweetDbList = new BasicDBList();

	          
	         for(TweetBean tweetBean : list) {
	        	 
	        	 DBObject studentDBObject = new BasicDBObject();
	        	 studentDBObject.put("tweetText", tweetBean.getTweetText());
	        	 
	        	 tweetDbList.add(tweetBean);
	        	 
	        	 
	         }
	 		dbObject.put("tweets", tweetDbList);
	        coll.insert(dbObject);
	          
	          System.out.println("Document inserted successfully");
	       }catch(Exception e){
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	       }	
	}
	
	public void saveMapData(Map<String, TweetBean> tweetMap){
		
		try{   
	  		
	          // To connect to mongodb server
	          MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	 			
	          // Now connect to your databases
	          DB db = mongoClient.getDB( "mydb" );
	          System.out.println("Connect to database successfully");

	                
	          DBCollection coll = db.getCollection("tweet");
	          System.out.println("Collection mycol selected successfully");
	          
	          BasicDBObject dbObject = new BasicDBObject(tweetMap);
	         
	          coll.insert(dbObject);
	          
	          System.out.println("Document inserted successfully");
	       }catch(Exception e){
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	       }	
	}
	
	public void saveDataWithMorphia(List<TweetBean> list) {
		
		String dbName = new String("mydb");
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	    Morphia morphia = new Morphia();
	    Datastore datastore = morphia.createDatastore(mongoClient, dbName);     
	    
	    morphia.mapPackage("com.bigdata.solution.bean");
	   
	    for(TweetBean tweetBean : list){
	    	datastore.save(tweetBean);
	    }
	    
	   // Object obj = datastore.save(list);
	 
	}

}
