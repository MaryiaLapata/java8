package com.epam.jmp.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BufferBQ {

	private BlockingQueue<Integer> list;	
	
	public BufferBQ(int capacity) {
		list = new LinkedBlockingQueue<>(capacity);
	}
	
	public void produce() throws InterruptedException{
		int value = 0;
		while(true){		
			Thread.sleep(500);
			System.out.println("Produce value: " + value);
			list.put(value++);
			
		}
	}
	
	public void consume() throws InterruptedException {
		while(true){
			int value = list.take();
			System.out.println("Consume value: " + value);
			
			Thread.sleep(1000);
		}
	}	
	
}
