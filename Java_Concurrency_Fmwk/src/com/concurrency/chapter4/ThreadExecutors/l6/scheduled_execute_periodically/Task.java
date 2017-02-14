package com.concurrency.chapter4.ThreadExecutors.l6.scheduled_execute_periodically;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Runnable {

	private String name;
	public Task(String name)
	{
		this.name=name;
	}
	
	//public String call() throws Exception {
		
	
	//return "Hello , world";
	
	//}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s : starting at : %s\n",name,new Date());
	}

}
