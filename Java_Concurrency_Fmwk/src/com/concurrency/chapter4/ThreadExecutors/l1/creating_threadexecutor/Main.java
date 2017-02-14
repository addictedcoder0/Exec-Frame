package com.concurrency.chapter4.ThreadExecutors.l1.creating_threadexecutor;

public class Main {

	public static void main(String[] args)
	{
		Server server= new Server();

		for(int i=0;i<10;i++)
		{
		Task task = new Task("Task_"+i);
		server.executeTask(task);
		}
		server.endServer();
	}
}
