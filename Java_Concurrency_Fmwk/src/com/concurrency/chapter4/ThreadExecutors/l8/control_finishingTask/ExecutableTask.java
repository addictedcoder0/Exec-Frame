package com.concurrency.chapter4.ThreadExecutors.l8.control_finishingTask;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExecutableTask implements Callable<String> {

	private String name;
	
	public ExecutableTask(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	@Override
	public String call() throws Exception {
	try {
		long duration=(long)(Math.random()*10);
		System.out.printf("%s : Waiting %d seconds for the results .\n",this.name,duration);
		TimeUnit.SECONDS.sleep(duration);
	}catch(InterruptedException e)
	{
		//e.printStackTrace();
	}
		
		return "Hello ,world . I'm "+name;
	}

	
}
