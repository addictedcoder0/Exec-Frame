package com.concurrency.chapter4.ThreadExecutors.l5.scheduled_executor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args)
	{
		ScheduledExecutorService executor = (ScheduledExecutorService)Executors.newScheduledThreadPool(1);
		
		// initialize and start few tasks
		System.out.printf("Main : Starting at : %s\n",new Date());
		for(int i=0;i<5;i++)
		{
			Task task = new Task("Task "+i);
			executor.schedule(task, i+1, TimeUnit.SECONDS);
		}
		executor.shutdown();
		try 
		{
			executor.awaitTermination(1, TimeUnit.DAYS);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.printf("Main : End at : %s\n", new Date());
		/*
		 *  Finally , you can configure the behavior of the ScheduledThreadPoolExecutor
		 * class when you call the shutdown() method and there are pending tasks waiting
		 * for the end of their delay time.
		 * default behavior is that those tasks will be executed despite the finalization
		 * of the executor . 
		 * 
		 *    you can change this behavior using the 
		 *    setExecuteExistingDelayedTaskAfterShutdownPolicy() => to false
		 *    and then at the time of shutdown pending tasks won't get executed.
		 */
	}
}
