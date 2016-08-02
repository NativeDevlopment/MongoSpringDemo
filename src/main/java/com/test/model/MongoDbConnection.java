package com.test.model;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDbConnection {
	/** The mongo client. */
	
	
	
	public MongoClient mongoClient;
	/** The database. */
	DB database;

	/**
	* Gets the mongo client.
	*
	* @return the mongo client
	*/
	public MongoClient getMongoClient() {
	mongoClient = new MongoClient("localhost", 27017);
	return mongoClient;
	}

	/**
	* Gets the database.
	*
	* @return the database
	*/
	@SuppressWarnings("deprecation")
	public DB getDatabase() {
	database = mongoClient.getDB("Demo");

	return database;
	}

	/**
	* Close.
	*/
	public void close() {
	mongoClient.close();
	}
}

