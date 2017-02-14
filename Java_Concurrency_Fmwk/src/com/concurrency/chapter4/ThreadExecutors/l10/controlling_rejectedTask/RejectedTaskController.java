package com.concurrency.chapter4.ThreadExecutors.l10.controlling_rejectedTask;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/*
 *  when we perform executor.shutdown() it then waits for the running tasks to be finished
 *  when you send a task b/w shutdown() and the end of execution of running tasks .. they simple gets rejected
 */
public class RejectedTaskController implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.printf("RejectedTaskController : The Task %s has been rejected\n",r.toString());
		System.out.printf("RejectedTaskController : %s\n",executor.toString());
		System.out.printf("RejectedTaskController : terminating %s\n",executor.isTerminating());
		System.out.printf("RejectedTaskController : terminated %s\n",executor.isTerminated());
	}

}
