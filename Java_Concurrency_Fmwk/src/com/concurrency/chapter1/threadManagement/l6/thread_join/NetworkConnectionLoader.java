package com.concurrency.chapter1.threadManagement.l6.thread_join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf("Beginning network source loading :%s\n ",new Date());
		try {
			TimeUnit.SECONDS.sleep(6);
		}
		catch(InterruptedException e)
		{
			System.out.printf("network source has been interrupted");
		}
		System.out.printf("network source loading has finished : %s\n",new Date());
		
	}

}
