package com.concurrency.chapter1.threadManagement.l2.thread_info;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Main {
	public static void main(String[] args)
	{
		/*
		 * Create an array of 10 threads and an array of 10 Thread.State to store the threads
		 */
		
		
		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];
		
		/*
		 * Create 10 objects of calculator class , each initialized with a different number 
		 * and 10 threads to run them .
		 * 
		 */
		for(int i=0;i<10;i++)
		{
		
		
		
			threads[i] = new Thread(new Calculator(i));
			
			/*
			 * setting up the properties of the Threads
			 */
			
	
			if ((i%2)==0)
			{
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}
			else
			{
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread :"+i);
		}

		try(	
			FileWriter file = new FileWriter("/home/local/ZOHOCORP/abhishek-2863/Applications/logy.txt");
			PrintWriter pw = new PrintWriter(file);)
			// write the status of these 10 Threads on this file .
			{	for(int i=0;i<10;i++)
				{
					pw.println("MAIN : Status Of Thread "+i+" : "+threads[i].getState());
					status[i]=threads[i].getState();
				}
				
			// Start the execution of the 10 Threads
				
				for(int i=0;i<10;i++)
				{
					threads[i].start();
				}
			
			// Untill these 10 Threads end , we will detect and write the change in their Status
				
				boolean finish = false ;
				while(!finish)
				{
					for (int i=0;i<10;i++)
					{
						if (threads[i].getState()!= status[i])
						{
							//pw.printf(threads[i].getName()+" => status : %s", threads[i].getState());
							writeThreadInfo(pw,threads[i],status[i]);
							status[i]=threads[i].getState();
						}
					}
					finish = true;
					// testing if all the threads has been terminated .. else continue the job
					for(int i=0;i<10;i++)
				{
					finish = finish && (threads[i].getState()== State.TERMINATED);
				}
				}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	private static void writeThreadInfo(PrintWriter pw , Thread thread,State state)
	{
		// there is no way to modify the ID and Status of a Thread. JVM only manages these things 
		pw.printf("MAIN : Id %d - %s\n", thread.getId(),thread.getName());
		pw.printf("MAIN : Priority : %d \n", thread.getPriority());
		pw.printf("MAIN : Old State :%s\n", state);
		pw.printf("MAIN : New State : %s\n", thread.getState());
		pw.printf("MAIN : **********************************************************\n");
	}
}
