package com.concurrency.chapter1.threadManagement.l5.Sleeping_resuming_thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable {

	
	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{
			System.out.printf("%s\n", new Date());
			try {
				TimeUnit.SECONDS.sleep(1);  // one second sleep time
			}
			catch(InterruptedException e)
			{
				System.out.printf("the fileClock has been interrupted");
				//e.printStackTrace();
				
			}
		}
	}

}
