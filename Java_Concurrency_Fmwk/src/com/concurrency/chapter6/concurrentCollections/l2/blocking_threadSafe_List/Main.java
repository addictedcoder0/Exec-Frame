package com.concurrency.chapter6.concurrentCollections.l2.blocking_threadSafe_List;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws Exception
	{
		// size must be fixed else there will be no blocking on the resource 
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);
		
		// client has been started
		Client client = new Client(list);
		Thread thread = new Thread(client);
		thread.start();
		
		
		/*
		 * client uses => put() [insert the data , if full then wait untill there is an empty space]
		 */
		
		/*
		 * Main uses => take() [get the data , if empty then wait untill there is an element in list]
		 */
		/*
		 *  get 3 string obj of the list every 300 ms using the take()\
		 *  
		 *  repeat this cycle 5 times
		 */
		
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=3;j++)
			{
				String request_pull = list.take();
				System.out.printf(" Main : request_pull %s at %s . size : %d \n",request_pull,new Date(),list.size());
				
			}
			TimeUnit.MILLISECONDS.sleep(300);
			
			System.out.print(" Main : End \n");
		}
		System.out.printf(" Main : end of the program \n");
	}
}
