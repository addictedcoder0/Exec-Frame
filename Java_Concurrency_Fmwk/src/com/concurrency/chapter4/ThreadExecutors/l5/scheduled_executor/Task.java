package com.concurrency.chapter4.ThreadExecutors.l5.scheduled_executor;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	private String name;
	public Task(String name)
	{
		this.name=name;
	}
	@Override
	public String call() throws Exception {
		System.out.printf(" %s : starting at : %s\n",name,new Date());
		
		return "hello , world";
	}

}
