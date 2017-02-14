package com.concurrency.chapter6.concurrentCollections.l7.atomic_variables;

import java.util.concurrent.atomic.AtomicLong;

public class Account {

	private AtomicLong balance;
	public Account()
	{
	 balance = new AtomicLong();	
	}
	
	public long getBalance()
	{
		return balance.get();
	}
	
	public void setBalance(long balance)
	{
		this.balance.set(balance);
	}
	public void addAmount(long amount)
	{
		this.balance.getAndAdd(amount);
	}
	public void subtractAmount(long amount)
	{
		this.balance.getAndAdd(-amount);
	}
	
}
