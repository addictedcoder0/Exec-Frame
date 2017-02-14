package com.concurrency.chapter1.threadManagement.l3.Interrupting_thread;

public class PrimeGenerator extends Thread{
	
public void run()
{
	long number = 1L;
	while(true)
	{
		if(isPrime(number))
		{
			System.out.printf(" number %d is a prime number",number);
			System.out.println();
		}
		/*
		 * after processing a number check if the thread has been interrupted or not 
		 * method : isInterrupted()  => only checks the state of the thread (interrupted or not) #preferred
		 * method : interrupted() => checks the state and once again set the value "false" for state
		 *
		 */
		
		if(isInterrupted())
		{
			System.out.println("the prime generator has been interrupted");
			return ;
		}
		number ++;
		
	}
	
}

private boolean isPrime(long number)
{
	if(number <=2)
		return true;
	
	for(long i=2;i<(number/2);i++)
	{ if((number%i)==0)
	{
		return false;
	}
		
	}
	return true;
}


}
