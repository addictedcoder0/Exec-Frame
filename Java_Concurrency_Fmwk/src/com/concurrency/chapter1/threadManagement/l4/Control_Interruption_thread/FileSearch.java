package com.concurrency.chapter1.threadManagement.l4.Control_Interruption_thread;

import java.io.File;

public class FileSearch implements Runnable {
	private String initpath;
	private String fileName;
	
	public FileSearch(String initpath,String fileName)
	{
		this.initpath=initpath;
		this.fileName = fileName;
	}
	@Override
	public void run() {
		File file = new File(initpath);
		if (file.isDirectory())
		{
			try{
				directoryProcess(file);
			}catch(InterruptedException e)
			{
				System.out.printf("%s : the search has been interrupted",Thread.currentThread().getName());
				
			}
		}
	}
	private void directoryProcess(File file)throws InterruptedException
	{
		File list[] = file.listFiles();
		if(list != null)
		{
			for(int i=0;i<list.length;i++)
			{
				if(list[i].isDirectory())
				{
					directoryProcess(list[i]);
				}
				else
				{
					fileProcess(list[i]);
				}
			}
		}
		if(Thread.interrupted())
		{
			throw new InterruptedException();
		}
	}
	
	private void fileProcess(File file) throws InterruptedException
	{
		if(file.getName().equals(fileName))
		{
			System.out.printf("%s : %s \n",Thread.currentThread().getName(),file.getAbsolutePath());
		}
		if(Thread.interrupted())
		{
			throw new InterruptedException();
		}
	}
}
