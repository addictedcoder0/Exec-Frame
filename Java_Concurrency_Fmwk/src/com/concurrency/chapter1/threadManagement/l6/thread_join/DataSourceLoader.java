package com.concurrency.chapter1.threadManagement.l6.thread_join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf("Beginning data source loading :%s\n ",new Date());
		try {
			TimeUnit.SECONDS.sleep(4);
		}
		catch(InterruptedException e)
		{
			System.out.printf("Data source has been interrupted");
		}
		System.out.printf("Data source loading has finished : %s\n",new Date());
		
	}

}
