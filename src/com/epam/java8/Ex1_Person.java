package com.epam.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.epam.java8.model.Person;

public class Ex1_Person {

	public static void main(String[] args){
		/*
		 * 1.	Create:
		•	a Person class with name and age fields;
		•	an array of Persons;
		•	two instances of Comparator<Person> interface using lambda expressions: first one for comparing by name, second one – by age;
		•	Then sort them using these comparators;
		•	Use forEach method for printing information about all the persons. Use the method reference;
		*/
		List<Person> personList = Arrays.asList(
				new Person("Galya", 25), 
				new Person("Vova", 35), 
				new Person("Petja", 18), 
				new Person("Anna", 26),
				new Person("Anna", 22));
		
		Comparator<Person> nameComparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
		Comparator<Person> ageComparator = (p1, p2) -> p1.getAge() - p2.getAge();
		
		personList.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
		personList.forEach(System.out::println);
		/*personList.stream()
			.sorted()
			.forEach(System.out::prinln);*/
	}
	
}
