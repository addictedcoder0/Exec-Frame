package com.concurrency.chapter6.concurrentCollections.l2.blocking_threadSafe_List;

import java.awt.List;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {

	private LinkedBlockingDeque<String> requestList;

	public Client(LinkedBlockingDeque<String> requestList)
	{
		this.requestList = requestList;
	}
	@Override
	public void run() {
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=5;j++)
			{
				StringBuilder request = new StringBuilder();
				request.append(i);
				request.append(" : ");
				request.append(j);
				
				try {
					requestList.put(request.toString());
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.printf("\tClient : %s at %s Size :%d.\n",request,new Date(),requestList.size());
							
			}
			
			try {
				TimeUnit.SECONDS.sleep(2);
				
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		 System.out.printf("\tClient : End\n");
		}
	}

}
