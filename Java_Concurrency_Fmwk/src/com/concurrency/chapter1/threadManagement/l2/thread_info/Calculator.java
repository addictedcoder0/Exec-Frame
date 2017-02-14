package com.concurrency.chapter1.threadManagement.l2.thread_info;

/*
 *  level 2: getting and setting Threads' Info 
 *  		[ID , Name ,Priority ,Status]
 *   
 */

public class Calculator implements Runnable {
	private int number;
	public Calculator(int number)
	{
		this.number=number;
	}
	@Override
	public void run() {
		for(int i=0;i<15;i++)
		{
			System.out.println("[ "+Thread.currentThread().getName()+" ] performing "+number+"*"+i+"result :"+number*i);
		}
	}

}
