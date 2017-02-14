package com.concurrency.chapter1.threadManagement.l7.creating_daemon_thread;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable {

	public Deque<Event> deque;
	public WriterTask(Deque<Event> deque)
	{
		this.deque = deque;
	}
	
	/*
	 * this method will have a loop with 100 iterations . In each iteration
	 * we create a new event , save it in the queue , and sleep for one second.
	 */
	@Override
	public void run() {
		
		for(int i=1;i<100;i++)
		{
			Event event = new Event();
			event.setDate(new Date());
			event.setEvent(String.format(" the thread %s has generated an event",Thread.currentThread().getId()));
			deque.addFirst(event);
			try {
				TimeUnit.SECONDS.sleep(1);
				
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
