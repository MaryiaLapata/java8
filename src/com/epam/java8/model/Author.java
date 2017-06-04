package com.epam.java8.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Author {

	private String name;
	private short age;
	private List<Book> books = new ArrayList<>();
	
	public Author(){}
	
	public Author(String name, short age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Author(String name, short age, List<Book> books) {
		super();
		this.name = name;
		this.age = age;
		this.books = books;
	}

	public Author(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author: name: " + this.name + "; age: " + this.age + "; books: " + this.books.stream().map(Book::getTitle).collect(Collectors.toList());
	}
}
