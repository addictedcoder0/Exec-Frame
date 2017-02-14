package com.concurrency.chapter1.threadManagement.l1.create_run;

/*
 *  level 1: creating and executing the Threads
 */

public class Calculator implements Runnable {
	private int number;
	public Calculator(int number)
	{
		this.number=number;
	}
	@Override
	public void run() {
		for(int i=1;i<5;i++)
		{
			System.out.println("[ "+Thread.currentThread().getName()+" ] performing "+number+"*"+i+"result :"+number*i);
		}
	}

}
