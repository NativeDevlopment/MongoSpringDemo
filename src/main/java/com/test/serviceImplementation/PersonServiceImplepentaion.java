package com.test.serviceImplementation;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.PersonDao;
import com.test.dao.SequenceDao;
import com.test.model.Person;
import com.test.services.PersionServices;

@Service
public class PersonServiceImplepentaion implements PersionServices
{ 
	@Autowired
	PersonDao personDao;
	@Autowired 
	SequenceDao  sequenceDao;
	private static final String USER_SEQ_KEY = "userId";

	@Override
	public HashMap<String, Object> addUser(Person person) {
		// TODO Auto-generated method stub
		
		System.out.println(	"sequenceid "+sequenceDao.getNextSequenceId(USER_SEQ_KEY));
		person.setId(String.valueOf(sequenceDao.getNextSequenceId(USER_SEQ_KEY)));
		return personDao.addUser(person);
	}

	public HashMap<String, Object> getUser(String user) {
		// TODO Auto-generated method stub
		 return personDao.getUser(user);
	}

	@Override
	public HashMap<String, Object> deleteUser(String user) {
		// TODO Auto-generated method stub
		return personDao.deleteUser(user);
	}

	

}
