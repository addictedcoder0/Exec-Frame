package com.concurrency.chapter4.ThreadExecutors.l3.multipletask_processfirstresult;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {

	public TaskValidator(UserValidator validator, String user, String password) {
		super();
		this.validator = validator;
		this.user = user;
		this.password = password;
	}


	private UserValidator validator;
	
	private String user;
	private String password;
	
	
	@Override
	public String call() throws Exception , InterruptedException {
	
		if(!validator.validate(user,password))
		{
			System.out.printf("%s : the user has not been found\n",validator.getName());
			throw new Exception("Error validating user");
		}
		System.out.printf("%s : the user has been found \n",validator.getName());
		
		return validator.getName(); 
	}

}
