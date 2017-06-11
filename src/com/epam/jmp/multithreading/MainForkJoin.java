package com.epam.jmp.multithreading;

import java.util.concurrent.ForkJoinPool;

public class MainForkJoin {

	public static void main(String[] args) {
		int fibNumber = ForkJoinPool.commonPool().invoke(new FibTask(10));
		
		System.out.println("fibonachi number: " + fibNumber);
	}

}
