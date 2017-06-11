package com.epam.jmp.multithreading;

public class MainBuffer {

	public static void main(String[] args) {
		//final Buffer buffer = new Buffer(5);
		final BufferBQ buffer = new BufferBQ(5);
		
		Runnable producer = () -> {
			try {
				buffer.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable consumer = () -> {
			try {
				buffer.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		startThread(producer);
		startThread(consumer);
	}

	private static void startThread(Runnable threadObject){
		new Thread(threadObject).start();
	}
}
