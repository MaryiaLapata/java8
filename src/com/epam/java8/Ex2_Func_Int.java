package com.epam.java8;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.epam.java8.model.Person;

public class Ex2_Func_Int {

	public static void main(String[] args) {
		/*
		 2.	Implement each of main Java Standard Library functional interfaces (supplier, predicate etc.) using lambda expressions.
		 */
		Person person = new Person("Vasya", 24);
		
		Supplier<String> supplier = () -> person.getName();		
		System.out.println(supplier.get());
		
		Predicate<Person> predicate = (p) -> p.getAge() > 18;
		System.out.println(predicate.test(person));
		
		Consumer<Person> consumer = p -> System.out.println(p);
		consumer.accept(person);
		
//		Function<String, Person> personConstruct = name -> new Person(name);
		Function<String, Person> personConstruct = Person::new;
		System.out.println(personConstruct.apply("Kolya"));
		
		BiFunction<String, Integer, Person> personConstruct2 = Person::new;
		System.out.println(personConstruct2.apply("Lev", 52));
	}

}
