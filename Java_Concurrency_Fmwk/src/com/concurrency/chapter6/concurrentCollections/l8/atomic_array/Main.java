package com.concurrency.chapter6.concurrentCollections.l8.atomic_array;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main {

	public static void main(String[] args)
	{
		final int THREADS = 100;
		
		// create an AtomicIntegerArray with 1000 elements
		AtomicIntegerArray vector = new AtomicIntegerArray(1000);
		
		// create an Incrementer task to work with the atomic array
		Incrementer incrementer = new Incrementer(vector);
		
		// create an Decrementer task to work with the atomic array
		Decrementer  decrementer = new Decrementer(vector);
		
		Thread threadIncrementer[] = new Thread[THREADS];
		Thread threadDecrementer[] = new Thread[THREADS];
		
		// create and launch the 100 thread to execute the Incrementer and 100 to Decrementer
		
		for(int i=0;i<100;i++)
		{
			threadIncrementer[i]= new Thread(incrementer);
			threadDecrementer[i]= new Thread(decrementer);
			
			
			threadIncrementer[i].start();
			threadDecrementer[i].start();
		}
		
		// Wait for the finalization of the Threads using the join()
		
		for(int i=0;i<100;i++)
		{
			try {
				threadIncrementer[i].join();
				threadDecrementer[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		for(int i=0;i<vector.length();i++)
		{
			if(vector.get(i)!= 0)
			{
				System.out.printf("Vector ["+i+"] : "+vector.get(i)+"\n");
			}
		}
	
		System.out.println(" MAIN : end of program ");
	}
}
