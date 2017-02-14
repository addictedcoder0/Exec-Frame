package com.concurrency.chapter5.fork_join.l1.create_fork_join_pool;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Product> products;
	
	// these attributes will decide the block of products this 
	// task has to process
	private int first;
	private int last;
	
	// to store the increment of the product
	
	private double increment;
	
	public Task(List<Product> products,int first, int last,double increment)
	{
		this.products=products;
		this.first=first;
		this.last=last;
		this.increment= increment;
		
	}
	
	/*
	 * compute () : method will implement the logic of the task 
	 */
	@Override
	protected void compute() {
		/* if (last - first)< 10 : increment the price of that set or product
		 * using the updatePrice()
		 * 
		 * if (last - first )>=10 : create 2 new task one to manage the first half
		 * and another to manage the other half of products
		 * and execute them in the fork/join pool using the invokAll()	
		*
		*/
		
		
		if((last-first)<10)
		{
			updatePrices();
		}
		else
		{
			int middle=(last+first)/2;
			System.out.printf("Task : pending tasks : %s\n ",getQueuedTaskCount());
			Task t1=new Task(products,first,middle+1,increment);
			Task t2= new Task(products,middle+1,last,increment);
			invokeAll(t1,t2);
		}
		
	}

	private void updatePrices()
	{
		for(int i=first;i<last;i++)
		{
			Product product=products.get(i);
			product.setPrice(product.getPrice()*(1+increment));
			
		}
	}
}
