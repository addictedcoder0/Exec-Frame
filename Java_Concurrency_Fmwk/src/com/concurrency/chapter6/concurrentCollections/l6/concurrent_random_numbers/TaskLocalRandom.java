package com.concurrency.chapter6.concurrentCollections.l6.concurrent_random_numbers;

import java.util.concurrent.ThreadLocalRandom;

public class TaskLocalRandom implements Runnable{

	public TaskLocalRandom()
	{
		/*
		 * we are making a call to the current () in the constructor . this is
		 * a static method that returns the ThreadLocalRandom object associated 
		 * with the current thread , so you can generate random numbers using 
		 * that object . if  the thread that makes the call doesn't have any object 
		 * associated yet , the class creates a new one ,In this case , you use this
		 * method to initialize the random number generator associated with this task.
		 */
		ThreadLocalRandom.current();
	}
	@Override
	public void run() {
	String name = Thread.currentThread().getName();
	for(int i=0;i<10;i++)
	{
	 System.out.printf(" %s : %d\n",name,ThreadLocalRandom.current().nextInt(10));
	 
	}
	}

}
