package com.concurrency.chapter4.ThreadExecutors.l7.cancelling_executor_task;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args)
	{
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		
		Task task = new Task();
		System.out.printf("Main : executing the Task");
		Future<String> result = executor.submit(task);
		
		try {
			TimeUnit.SECONDS.sleep(2);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.printf("Main : shutting down the Executor service\n");
		result.cancel(true);
		/*
		 * 
		 *=> if task [finished , has been cancelled , can't be cancelled(some reason) : task won't be cancelled]
		 *=> if task [waiting for a thread obj  ]:cancelled and never begins again
		 *=> if task [running ]: cancel(true) : task is cancelled
		 *						 cancel(false): task won't be cancelled	     
		 *		 
		 */
		System.out.printf(" Main: shutdown : %s\n",result.isCancelled());
		System.out.printf(" Main: Done : %s\n",result.isDone());
		executor.shutdown();
		System.out.println("Main : the executor has finished\n");
	}
}
