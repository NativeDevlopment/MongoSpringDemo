package com.test.testapp;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.Person;
import com.test.serviceImplementation.PersonServiceImplepentaion;
import com.test.services.PersionServices;

@Controller
public class GetUSerController {
	HashMap<String, Object> response=null;
	@Autowired
	private PersionServices userSignUpService;
	


	private static final Logger logger = LoggerFactory.getLogger(GetUSerController.class);
	@RequestMapping(value="/getUser/{userId}",method=RequestMethod.GET)
	public @ResponseBody HashMap<String , Object > addUser(@PathVariable("userId") String user){
		
		logger.info("/getUser controller called.");		
		response=userSignUpService.getUser(user);
		
		return response;
		 
	}

}
