package com.concurrency.chapter4.ThreadExecutors.l1.creating_threadexecutor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private Date initDate;
	private String name;
	
	public Task(String name)
	{
		this.initDate = new Date();
		this.name= name;
	}
	
	
	@Override
	public void run() {
	System.out.printf(" Thread : %s  Task : %s created on %s\n",Thread.currentThread().getName(),name,initDate);
	System.out.printf(" Thread : %s  Task : %s started on %s\n",Thread.currentThread().getName(),name,new Date());
	
	try {
		Long duration = (long) (Math.random()*10);
		System.out.printf("%s : Task : %s doing a task during %d\n",Thread.currentThread().getName(),name,duration);
		TimeUnit.SECONDS.sleep(duration);
		}
	catch(InterruptedException e)
		{
		e.printStackTrace();
		}
	
	System.out.printf("%s : task : %s Finished on : %s\n",Thread.currentThread().getName(),name,new Date());
	
	}

}
