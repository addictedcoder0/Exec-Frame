package com.concurrency.chapter6.concurrentCollections.l7.atomic_variables;

/*
 *  Atomic Variable : if more than one thread want to perform operation on same variable ... 
 *  the implementation makes sure that it happens in single step , else restart the operation 
 *  
 *  basically , the operation gets the value for the new variable , changes the value in local variable 
 *  and then tries to change the old value for the new one .
 *  
 *   this operation is called "COMPARE AND SET"
 */
public class Main {

	public static void main(String[] args)
	{
		Account account = new Account();
		account.setBalance(1000);
		System.out.printf(" Account : Initial 1000 rs deposited as token money current_Balance : %d \n",account.getBalance());
		Thread companythreads[] = new Thread[3];
		Thread bankthreads[] = new Thread[3];
		
		for(int i=0;i<3;i++)
		{
			
		
		Company company = new Company(account);
		companythreads[i]= new Thread(company);
			
		Bank bank= new Bank(account);
		bankthreads[i]  = new Thread(bank);
		}
		
		for(int i=0;i<3;i++)
		{
			
		companythreads[i].start();
	//	System.out.printf(" Account : Withdrawl [10,000] started Balance : %d \n",account.getBalance());
		bankthreads[i].start();
		}
		// wait for the operations to be finished
		try {
			for(int i=0;i<3;i++)
			{
			companythreads[i].join();
//			System.out.printf(" Account : Deposition finishes Balance : %d \n",account.getBalance());
			bankthreads[i].join();
		//	System.out.printf(" Account : Withdrawl finishes Balance : %d \n",account.getBalance());
			}
			}
		catch(InterruptedException e)
			{
			e.printStackTrace();
			}
		System.out.printf(" Account : Withdrawl finishes current_Balance : %d \n",account.getBalance());
	}
}
