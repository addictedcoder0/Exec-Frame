package com.concurrency.chapter4.ThreadExecutors.l8.control_finishingTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String>{

	private String name;
	public ResultTask(Callable<String> callable) {
		super(callable);
		this.name=((ExecutableTask)callable).getName();
		
	}
	
	protected void done()
	{
		if(isCancelled())
		{
			System.out.printf(" %s : Has been cancelled \n ",name);
			
		}else
		{
			System.out.printf(" %s : has finished\n",name);
		}
	}
}
