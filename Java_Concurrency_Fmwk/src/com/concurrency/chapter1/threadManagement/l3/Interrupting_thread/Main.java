package com.concurrency.chapter1.threadManagement.l3.Interrupting_thread;

public class Main {
	public static void main(String[] args)
	{
	
		Thread thread = new PrimeGenerator();
		thread.start();
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		/*
		 * Thread class has a boolean field to indicate the interruption state of a thread 
		 * and by calling the interrupt() we set that field to "true"
		 */
		thread.interrupt();
	}
}
