package com.concurrency.chapter6.concurrentCollections.l3.blocking_threadSafe_priority_List;

public class Event implements Comparable<Event> {

	private int thread; // to store the number of thread to store that has created the event
	public int getThread() {
		return thread;
	}
	public int getPriority() {
		return priority;
	}
	private int priority;
	
	public Event(int thread,int priority)
	{
		this.thread = thread;
		this.priority = priority;
	}
	@Override
	public int compareTo(Event e) {
		if(this.priority>e.getPriority())
		{
			return -1;
		}else if(this.priority<e.getPriority())
		{
			return 1;
		}
		else{
		return 0;
	
		}
	}

	
}

