package com.concurrency.chapter6.concurrentCollections.l4.Delayed_threadSafe_List;

import java.util.Date;
import java.util.concurrent.DelayQueue;

public class Task implements Runnable {
	private int id;
	private DelayQueue<Event> queue;
	public Task(int id,DelayQueue<Event> queue)
	{
		this.id=id;
		this.queue=queue;
	}
	@Override
	public void run() {
		Date now = new Date();
		Date delay = new Date();
		delay.setTime(now.getTime()+(id*1000));
		System.out.printf("Thread %s : currentTime : %s  DelayTime : %s\n",id,new Date(),delay);
		

	// store 100 events in the queue using the add()
		for(int i=0;i<100;i++)
		{
			Event event = new Event(Thread.currentThread().getId(),delay);
			queue.add(event);
			
		}
		System.out.printf(" Thread %s : added events at %s  With event ID :%d \n",id,new Date(),Thread.currentThread().getId());
	}
}
