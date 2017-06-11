package com.epam.jmp.multithreading;

import java.util.LinkedList;

public class Buffer{

	private LinkedList<Integer> list = new LinkedList<>();
	int capacity;
	
	public Buffer(int capacity) {
		this.capacity = capacity;
	}
	
	public void produce() throws InterruptedException{
		int value = 0;
		while(true) {
			synchronized (this) {
				while(list.size() == this.capacity) {
					System.out.println("Buffer is full.");
					wait();
				}
				
				System.out.println("Produce value: " + value);
				list.add(value++);
				
				notify();
				
				Thread.sleep(500);
			}
		}
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized (this) {
				while(list.size() == 0){
					System.out.println("Buffer is empty.");
					wait();
				}
				
				int data = list.removeFirst();
				System.out.println("Consume value: " + data);
				
				notify();
				
				Thread.sleep(500);
			}
		}
	}
}
