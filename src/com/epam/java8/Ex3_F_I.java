package com.epam.java8;

import java.util.Arrays;
import java.util.function.Predicate;

public class Ex3_F_I {

	public static void main(String[] args) {
		// 3.	Create your own functional interface and add several its implementations using both lambda expressions 
		// and inner anonymous classes.
		
		MyFunctionalInterface fI = (value) -> value > 0;
		
		MyFunctionalInterface fI2 = new MyFunctionalInterface(){

			@Override
			public boolean test(int value) {
				return value < 0;
			}
			
		};

		System.out.println(fI.test(2));
		System.out.println(fI2.test(2));
		
		
		//4.	Add few default methods to it and use them.
		
		Arrays.asList(fI, fI2).forEach(f -> f.print());
		
		//5.	Add few static methods to it and use them.
		
		Predicate<Integer> predicate = MyFunctionalInterface::isMoreThenFive;
		System.out.println(predicate.test(6));
	}

}

@FunctionalInterface
interface MyFunctionalInterface {
	boolean test(int value);
	
	default void print() {
		System.out.println("It is a default method");
	}
	
	static boolean isMoreThenFive(int value){
		System.out.println("It is a static method");
		return value > 5;
	}
}