package com.concurrency.chapter6.concurrentCollections.l4.Delayed_threadSafe_List;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws Exception {
		long event_id=0;
		
		DelayQueue<Event> queue = new DelayQueue<>();
		Thread threads[] = new Thread[5];
		for(int i=0;i<threads.length;i++)
		{
			Task task = new Task(i+1,queue);
			threads[i]= new Thread(task);
		}
		
		// launch all the five tasks
		
		for(int i=0;i<5;i++)
		{
			threads[i].start();
		}
		
		// wait for their finalization
		for(int i =0;i<5;i++)
		{
			threads[i].join();
		}
		
		
		// now we will read out the elements from the delayqueue
		do {
			int counter =0;
			Event event;
			 do {
				 event = queue.poll();
				
				 if (event != null)
				 {	
					 event_id = event.getId();
					 counter++;
				 }
			 } while(event != null);
			 System.out.printf("At %s you have read %d events with event ID : %d\n",new Date(),counter,event_id);
			 TimeUnit.MILLISECONDS.sleep(500);
		} while(queue.size()>0);
		
	}

}
