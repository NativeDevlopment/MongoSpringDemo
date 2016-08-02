package com.test.daoImplementation;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.test.dao.MongoDBPersonDAO;
import com.test.dao.PersonDao;
import com.test.dao.SequenceDao;
import com.test.model.DbManager;
import com.test.model.MongoDbConnection;
import com.test.model.Person;
@Repository
public class personDaoImplementation implements PersonDao{
@Autowired
DbManager db;

HashMap<String, Object> response=null;


	@Override
	public HashMap<String, Object> addUser(Person person) {
		// TODO Auto-generated method stub
		response=new HashMap<String, Object>();
		
		if ((person.getName() == null || person.getName().equals(""))
				|| (person.getCountry() == null || person.getCountry().equals(""))) {
			response.put("code", 500);
			response.put("message","Mandatory Parameters Missing");
			return response;
		} else {
			;
			MongoClient mongo = db.getMongoClient();
			MongoDBPersonDAO personDAO = new MongoDBPersonDAO(mongo);
			try {
			
				personDAO.createPerson(person);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*System.out.println("Person Added Successfully with id="+p.getId());
			request.setAttribute("success", "Person Added Successfully");*/
			List<Person> persons = personDAO.readAllPerson();
			
			response.put("code", 200);
			response.put("message", "Person Added Successfully");
			response.put("userList", persons);
			
		}
		
		

		
		return response;
	}
	@Override
		public HashMap<String, Object> getUser(String user) {
			// TODO Auto-generated method stub
	response=new HashMap<String, Object>();
		
		
			MongoClient mongo = db.getMongoClient();
			MongoDBPersonDAO personDAO = new MongoDBPersonDAO(mongo);
			
			/*System.out.println("Person Added Successfully with id="+p.getId());
			request.setAttribute("success", "Person Added Successfully");*/
			response.put("code", 200);
			response.put("message", "Person fetch Successfully");
			response.put("user", personDAO.readPerson(user));
			
			return response;
			
		}
	@Override
	public HashMap<String, Object> deleteUser(String user) {
		// TODO Auto-generated method stub
		response=new HashMap<String, Object>();
		
		
		MongoClient mongo = db.getMongoClient();
		MongoDBPersonDAO personDAO = new MongoDBPersonDAO(mongo);
		
		/*System.out.println("Person Added Successfully with id="+p.getId());
		request.setAttribute("success", "Person Added Successfully");*/
		response.put("code", 200);
		response.put("message",personDAO.deletePerson(user));
		
		
		return response;
	}
		
		

		
		
		

}
