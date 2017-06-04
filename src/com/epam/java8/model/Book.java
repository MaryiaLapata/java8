package com.epam.java8.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Book {

	private String title;
	private List<Author> authors = new ArrayList<>();
	private int numberOfPages;
	
	public Book(){}
	
	public Book(String title, List<Author> authors, int numberOfPages) {
		super();
		this.title = title;
		this.authors = authors;
		this.numberOfPages = numberOfPages;
	}
	
	public Book(String title) {
		super();
		this.title = title;
	}

	public Book(String title, int numberOfPages) {
		super();
		this.title = title;
		this.numberOfPages = numberOfPages;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Override
	public String toString() {
		return "Book [Title=" + this.title + ", authors=" + this.authors.stream().map(Author::getName).collect(Collectors.toList()) + ", numberOfPages=" + this.numberOfPages + "]";
	}
	
	
}
