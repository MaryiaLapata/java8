package com.epam.jmp.multithreading;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class BufferSP {

	 private Semaphore spProducer = new Semaphore(1);
     private Semaphore spConsumer = new Semaphore(0);
     private LinkedList<Integer> list = new LinkedList<>();
     private int capacity;
     
     public BufferSP(int capacity) {
 		this.capacity = capacity;
 	}
 	
 	public void produce() throws InterruptedException{
 		int value = 0;
 		while(true) {
 			spProducer.acquire();
 				while(list.size() == this.capacity) {
 					System.out.println("Buffer is full.");
 					wait();
 				}
 				
 				System.out.println("Produce value: " + value);
 				list.add(value++);
 				
 				notify();
 				
 				Thread.sleep(500);
 			spConsumer.release();
 		}
 	}
 	
 	public void consume() throws InterruptedException {
 		while(true) {
 			spConsumer.acquire();
 				while(list.size() == 0){
 					System.out.println("Buffer is empty.");
 					wait();
 				}
 				
 				int data = list.removeFirst();
 				System.out.println("Consume value: " + data);
 				
 				notify();
 				
 				Thread.sleep(500);
 			spProducer.release();
 		}
 	}
}
