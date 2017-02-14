package com.concurrency.chapter6.concurrentCollections.l3.blocking_threadSafe_priority_List;

import java.util.concurrent.PriorityBlockingQueue;

public class Main {

	public static void main(String[] args)
	{
		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
		Thread taskthreads[] = new Thread[5];
		for(int i=0;i<taskthreads.length;i++){
			Task task = new Task(i,queue);
			taskthreads[i] = new Thread(task);
		}

		// start the threads created
		for(int i=0;i<taskthreads.length;i++)
		{
			taskthreads[i].start();
		}

		// wait for the finalization of the threads using join() method .

		for(int i=0;i<taskthreads.length;i++)
		{
			try
			{
				taskthreads[i].join();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		System.out.printf(" MAIN : Queue Size : %d\n",queue.size());
		for(int i=0;i<taskthreads.length*1000;i++)
		{
			Event event = queue.poll();
			System.out.printf(" Thread %s : Priority %d\n",event.getThread(),event.getPriority());

		}
		System.out.printf(" MAIN : Queue Size : %d\n",queue.size());
		System.out.printf(" MAIN : End of the Program \n");
	}
}
