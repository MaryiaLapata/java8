package com.epam.java8;

import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
public interface ThreeFunction<T, U, R> extends BiFunction<T, U, R>{

	default Function<U, R> doSmth(T t) {
		return u -> apply(t, u);
	}
}
