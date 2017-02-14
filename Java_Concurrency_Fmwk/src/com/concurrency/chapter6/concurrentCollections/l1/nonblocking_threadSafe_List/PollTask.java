package com.concurrency.chapter6.concurrentCollections.l1.nonblocking_threadSafe_List;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PollTask implements Runnable {

	private ConcurrentLinkedDeque<String> list ;
	
	public PollTask(ConcurrentLinkedDeque<String> list)
	{
		this.list = list;
		
	}
	
	
	@Override
	/*
	 * it takes out 10000 elements of the list in a loop with 5000 steps , 
	 * taking off 2 elements in each step.  
	 * 	 
	 */
	public void run() {
		for(int i=0;i<5000;i++)
		{
			list.pollFirst();
			list.pollLast();
		}

	}

}
