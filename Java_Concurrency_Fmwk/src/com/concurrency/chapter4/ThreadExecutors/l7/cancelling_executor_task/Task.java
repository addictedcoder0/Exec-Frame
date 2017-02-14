package com.concurrency.chapter4.ThreadExecutors.l7.cancelling_executor_task;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	
	@Override
	public String call() throws Exception {
	
		while(true)
		{
			System.out.printf("Task : test \n");
			Thread.sleep(100);
		}
		//return null;
	}
	

}
