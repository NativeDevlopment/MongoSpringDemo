package com.test.testapp;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.test.model.Person;
import com.test.serviceImplementation.PersonServiceImplepentaion;
import com.test.services.PersionServices;

@Controller
public class AddUserController {
	
HashMap<String, Object> response=null;
	
	//** The user sign up service. *//*
	@Autowired
	private PersionServices userSignUpService;
	
	private static final Logger logger = LoggerFactory.getLogger(AddUserController.class);
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public @ResponseBody HashMap<String , Object > addUser(@RequestBody Person userSignUp){
		
		logger.info("/addUser controller called.");		
		response=userSignUpService.addUser(userSignUp);
		
		return response;
		 
	}
}
