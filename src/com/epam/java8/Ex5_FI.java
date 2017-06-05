package com.epam.java8;

public class Ex5_FI {

	public static void main(String[] args) {
		
		ThreeFunction<Integer, Boolean, String> fn1 = (i, b) -> {
			return "Result: " + (b ? i : 0);
		};

		System.out.println(fn1.apply(25, true));
	}

}
