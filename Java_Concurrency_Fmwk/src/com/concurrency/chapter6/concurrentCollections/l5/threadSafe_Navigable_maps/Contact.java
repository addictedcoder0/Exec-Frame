package com.concurrency.chapter6.concurrentCollections.l5.threadSafe_Navigable_maps;

public class Contact {

	private String name;
	private String phone;
	Contact(String name , String phone)
	{
		this.name = name;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	
}
