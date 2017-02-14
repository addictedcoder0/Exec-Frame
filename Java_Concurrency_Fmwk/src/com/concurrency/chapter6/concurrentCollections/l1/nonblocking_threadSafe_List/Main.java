package com.concurrency.chapter6.concurrentCollections.l1.nonblocking_threadSafe_List;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

	public static void main(String[] args)
	{
		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
		Thread threads[] = new Thread[100];
		
		/*
		 * create 100 Addtask threads , and start them
		 */
		
		for(int i =0;i<threads.length ;i++)
		{
			AddTask task = new AddTask(list);
			threads[i]= new Thread(task);
			threads[i].start();
		}
		System.out.printf(" MAIN : %d AddTask threads have been launched \n",threads.length);
	
		// wait for the completion of the Threads using the join() method
		for(int i=0;i<threads.length;i++)
		{
			try {
				threads[i].join();
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	
		System.out.printf(" Main : Size of the list : %d\n",list.size());
		/*
		 *  create 100 Polltask thread , and start them
		 */
		
		System.out.printf(" MAIN : %d PollTask threads have been launched \n",threads.length);
		
		for(int i=0;i<threads.length ;i++)
		{
			PollTask task = new PollTask(list);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		
		// wair for the finalization of the task
		
		for(int i=0;i<threads.length;i++)
		{
			try{
			threads[i].join();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		System.out.printf(" Main : Size of the list : %d\n",list.size());
	}
}
