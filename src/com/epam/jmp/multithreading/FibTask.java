package com.epam.jmp.multithreading;

import java.util.concurrent.RecursiveTask;

public class FibTask extends RecursiveTask<Integer>{

	private static final long serialVersionUID = 1L;
	
	int number;
	
	public FibTask(int number) {
		this.number = number;
	}

	@Override
	protected Integer compute() {
		if(number <= 1){
			return number;
		} else {
			FibTask taskLeft = new FibTask(number - 1);
			FibTask taskRight = new FibTask(number - 2);
			taskLeft.fork();
			taskRight.fork();
			return taskLeft.join() + taskRight.join();
		}	
	}
}
