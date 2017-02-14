package com.concurrency.chapter6.concurrentCollections.l6.concurrent_random_numbers;

public class Main {

	public static void main(String[] args)
	{
		Thread thread[] = new Thread[3];
		
		for(int i=0;i<3;i++)
		{
			TaskLocalRandom task = new TaskLocalRandom();
			thread[i] = new Thread(task);
			thread[i].start();
		}
	}
}
