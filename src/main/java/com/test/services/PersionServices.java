package com.test.services;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.test.model.Person;


public interface PersionServices {
	public HashMap<String, Object> addUser(Person person);
	public HashMap<String, Object> getUser(String user);
	public HashMap<String, Object> deleteUser(String user);

}
