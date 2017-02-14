package com.concurrency.chapter6.concurrentCollections.l5.threadSafe_Navigable_maps;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Main {

	public static void main(String[] args)
	{
	ConcurrentSkipListMap<String, Contact> map;
	map = new ConcurrentSkipListMap<>();
	
	Thread threads[] = new Thread[25];
	int counter =0;
	
	// Creating and launching 25 task objects assigning a capital letter as the ID of each task
	
	for(char i='A';i<'Z';i++)
	{
		Task task = new Task(map,String.valueOf(i));
		threads[counter]= new Thread(task);
		threads[counter].start();
		counter++;
	}
	
	// wait for the finalization of the threads using the join() 
	for(int i=0;i<25;i++)
	{
		try {
			threads[i].join();
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	 
	// upto this point all the data has been feeded into the Map 
	
	/*
	 *  get the first entry using : firstEntry()
	 *  get the last entry using : lastEntry()
	 *  obtain a subMap using : subMap()
	 */
	
	System.out.printf(" MAIN : Size of the map : %d\n",map.size());
	Map.Entry<String , Contact> element;
	Contact contact;
	
	element = map.firstEntry();
	contact= element.getValue();
	System.out.printf(" MAIN : First Entry : %s : %s\n",contact.getName(),contact.getPhone());
	
	element = map.lastEntry();
	contact = element.getValue();
	
	System.out.printf(" MAIN : Last Entry : %s  :%s \n",contact.getName(),contact.getPhone());
	
	// obtain the SUB- MAP from "A1996" to "B1002" 
	
	System.out.printf(" MAIN : Submap from A1996 to B1002 :\n");
	
	ConcurrentNavigableMap<String , Contact> submap = map.subMap("A1996", "B1002");
	
	do{
		element = submap.pollFirstEntry();
		if(element != null)
		{
			contact = element.getValue();
			System.out.printf("%s : %s\n",contact.getName(),contact.getPhone());
		}
	}while(element!=null);
	}
}

	