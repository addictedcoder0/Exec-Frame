package com.concurrency.chapter1.threadManagement.l5.Sleeping_resuming_thread;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args)
	{
	
		FileClock clock = new FileClock();
		Thread thread = new Thread(clock);
		thread.start();
		/*
		 *  it will run the date object per second and then after 5 seconds interruption occurs
		 *  
		 *  when you call sleep() , thread leaves the CPU and stops its execution for
		 *  a period of time . During this time CPU can execute other Task
		 */
		try{
			TimeUnit.SECONDS.sleep(6);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		
		/*
		 * Thread class has a boolean field to indicate the interruption state of a thread 
		 * and by calling the interrupt() we set that field to "true"
		 */
		
		/*
		 * when a thread is sleeping and is interrupted , 
		 * the method throws an InterruptedException immediately without waiting for sleeping 
		 * time to be finished. 
		 */
		thread.interrupt();
	}
}
