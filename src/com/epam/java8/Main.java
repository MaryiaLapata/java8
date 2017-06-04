package com.epam.java8;

public class Main {

	public static void main(String[] args) {
		
		//Create several instances of Runnable interface with different implementation using lambda expressions. Use them with threads.

		Runnable task1 = () -> {
			try {
				Thread.sleep(1000);
				System.out.println("Task1 fulfilled in 1 sec");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable task2 = () -> {
			System.out.println("Task2 fulfilled immediately");
		};
		
		startThread(task1);
		startThread(task2);
		startThread(() -> {
			try {
				Thread.sleep(2000);
				System.out.println("Anonymous task3 fulfilled in 2 sec");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}

	private static void startThread(Runnable threadObject){
		new Thread(threadObject).start();
	}
}
