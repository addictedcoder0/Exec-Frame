package com.concurrency.chapter1.threadManagement.l7.creating_daemon_thread;

import java.util.Date;
import java.util.Deque;
/*
 * this class gets the last event and , if it was created more 
 * than 10 seconds ago , it deletes it and checks the next event .
 *  if an event is deleted, it writes the message of the event and new size.
 */

public class CleanerTask extends Thread{
	
	private Deque<Event> deque;
	public CleanerTask(Deque<Event> deque)
	{
		this.deque=deque;
		// mark this thread as a daemon thread; setDemon() must be set before the 
		// start of thread , else after starting we can't change the daemon status 
		
		setDaemon(true);
	}
	public void run(){
		while(true)
		{
			Date date = new Date();
			clean(date);
		}
	}

	private void clean(Date date)
	{
	
		long difference;
		boolean delete;
		if(deque.size()==0)
		{
			return;
		}
		delete =false;
		do{
			Event e = deque.getLast();
			difference = date.getTime()-e.getDate().getTime();
			if(difference > 10000)
			{
				System.out.printf("Cleaner : %s\n",e.getEvent());
				deque.removeLast();
				delete=true;
			}
		}while(difference>10000);
		if(delete)
		{
			System.out.printf("Cleaner : size of the deque : %d\n",deque.size());
		}
	}
}