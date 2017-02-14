package com.concurrency.chapter6.concurrentCollections.l7.atomic_variables;

public class Company implements Runnable{

	private Account account;
	public Company(Account account)
	{
		this.account= account;
	}
	@Override
	public void run() {

		System.out.printf(" Account : Amount of 10k deposit is in process by [%d] \n",Thread.currentThread().getId());
		for(int i=0;i<10;i++)
		{
			account.addAmount(1000);
		}
		System.out.printf(" Account :  Deposit success by [%d] Current_Balance:%d\n",Thread.currentThread().getId(),account.getBalance());
	}

}
