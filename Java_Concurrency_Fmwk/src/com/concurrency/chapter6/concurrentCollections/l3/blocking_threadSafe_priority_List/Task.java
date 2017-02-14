package com.concurrency.chapter6.concurrentCollections.l3.blocking_threadSafe_priority_List;

import java.util.concurrent.PriorityBlockingQueue;

public class Task implements Runnable {

	private int id;
	private PriorityBlockingQueue<Event> queue;
	
	public Task(int id , PriorityBlockingQueue<Event> queue)
	{
		this.id=id;
		this.queue=queue;
		
	}
	/*
	 * run() : it stores 1000 events in the queue , using its ID to identify the task 
	 * that creates the event and giving to them as priority an increasing number.
	 * use the add() method to store the events in the queue.
	 */
	public void run() {
		for(int i=0;i<1000;i++)
		{
			Event event = new Event(id, i);
			queue.add(event);
		}
	}

}
