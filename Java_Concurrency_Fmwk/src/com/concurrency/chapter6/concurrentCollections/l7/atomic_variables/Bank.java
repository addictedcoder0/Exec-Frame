package com.concurrency.chapter6.concurrentCollections.l7.atomic_variables;

public class Bank implements Runnable {

	private Account account;
	public Bank(Account account)
	{
		this.account=account;
	}
	@Override
	public void run() {
		
		System.out.printf(" Account : Amount of 10k withdrawl in process by [%d]  \n",Thread.currentThread().getId());
		for(int i=0;i<10;i++)
		{
			account.subtractAmount(1000);
		}
		System.out.printf(" Account : withdrawl success by [%d] Current_Balance:%d\n",Thread.currentThread().getId(),account.getBalance());
		
	}

}
