package com.concurrency.chapter1.threadManagement.l6.thread_join;

import java.util.Date;


public class Main {
	public static void main(String[] args)
	{
		DataSourceLoader dataSourceLoader = new DataSourceLoader();
		Thread th1 = new Thread(dataSourceLoader);
		
		NetworkConnectionLoader networkConnectionLoader = new NetworkConnectionLoader();
		Thread th2 = new Thread(networkConnectionLoader);
		
		th1.start();
		th2.start();
		
		// start of the threads could be random , 
		
		try{
		th1.join();
		th2.join();
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.printf("MAIN : conf has been loaded succeefully : %s\n",new Date());
		
		
		/* join() => wait until task is finished
		 * join(long milliseconds) => wait until task finish or time-up
		 * join(long milliseconds , long nanos)
		 */
		
		/*
		 * when a thread is sleeping and is interrupted , 
		 * the method throws an InterruptedException immediately without waiting for sleeping 
		 * time to be finished. 
		 */
		}
}
