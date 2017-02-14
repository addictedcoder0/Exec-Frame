package com.concurrency.chapter4.ThreadExecutors.l6.scheduled_execute_periodically;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args)
	{
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		System.out.printf("Main : starting at : %s\n",new Date());
		Task task = new Task("Task");
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
		
		for(int i=0;i<10;i++)
		{
			System.out.printf("Main : Delay : %d\n",result.getDelay(TimeUnit.MILLISECONDS));
			
			// sleep the thread for 500 milliseconds
			try {
				TimeUnit.MILLISECONDS.sleep(500);
				
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
		executor.shutdown();
		try {
			TimeUnit.SECONDS.sleep(5);
			}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.printf("Main : finished at : %s\n",new Date());
		
	}
}
