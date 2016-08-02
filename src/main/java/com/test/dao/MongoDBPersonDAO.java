package com.test.dao;


import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.print.DocFlavor.STRING;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.test.converter.PersonConverter;
import com.test.model.Person;

//DAO class for different MongoDB CRUD operations
//take special note of "id" String to ObjectId conversion and vice versa
//also take note of "_id" key for primary key
public class MongoDBPersonDAO {

	private DBCollection col ,colCounters;
	
	
	public MongoDBPersonDAO(MongoClient mongo) {
		this.col = mongo.getDB("testMongo").getCollection("Persons");
		this.colCounters = mongo.getDB("testMongo").getCollection("counters");
	
	}

	
	public Person createPerson(Person p )  {
			
		DBObject doc = PersonConverter.toDBObject(p);
		
		this.col.insert(doc);
		String id = (String) doc.get("_id");
		p.setId(id.toString());
		return p;
	}


	
	public void updatePerson(Person p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getId())).get();
		this.col.update(query, PersonConverter.toDBObject(p));
	}

	public List<Person> readAllPerson() {
		List<Person> data = new ArrayList<Person>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			Person p = PersonConverter.toPerson(doc);
			data.add(p);
		}
		return data;
	}

	public void deletePerson(Person p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getId())).get();
		this.col.remove(query);
	}
	public String deletePerson(String id) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", id).get();
		this.col.remove(query);
		return "user Deleted  sucessfully";
	}

	public Person readPerson(Person p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getId())).get();
		DBObject data = this.col.findOne(query);
		return PersonConverter.toPerson(data);
	}

	public Person readPerson(String userId) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", userId).get();
		DBObject data = this.col.findOne(query);
		return PersonConverter.toPerson(data);
	}
}
