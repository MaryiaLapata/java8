package com.epam.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.epam.java8.model.Author;
import com.epam.java8.model.Book;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;

public class Ex4_Books {

	public static void main(String[] args) {
		Book book1 = new Book("title1", 250);
		Book book2 = new Book("title2", 200);
		Book book3 = new Book("title3", 100);
		
		Author author1 = new Author("Author1", (short)29);
		Author author2 = new Author("Author2", (short)19);
		Author author3 = new Author("Author3", (short)39);
		
		author1.getBooks().add(book1);
		author1.getBooks().add(book2);
		book1.getAuthors().add(author1);
		book2.getAuthors().add(author1);
		
		author2.getBooks().add(book3);
		book3.getAuthors().add(author2);
		
		author3.getBooks().add(book2);
		book2.getAuthors().add(author3);
		
		List<Author> authors = Arrays.asList(author1, author2, author3);
		
		List<Book> books = Arrays.asList(book1, book2, book3);		
		
		/*3.	Create a stream of books and then:
			•	check if some/all book(s) have more than 200 pages;
			•	find the books with max and min number of pages;
			•	filter books with only single author;
			•	sort the books by number of pages/title;
			•	get list of all titles;
			•	print them using forEach method;
			•	get distinct list of all authors
			4.	Use peek method for debugging intermediate streams during execution the previous task.
			5.	Use parallel stream with subtask #3.
			6.	Use the Option type for determining the title of the biggest book of some author.*/
		
		System.out.println(books.stream().anyMatch(b -> b.getNumberOfPages() > 200));
		
		Optional<Book> result = books.stream()
			.collect(maxBy(comparing(Book::getNumberOfPages)));		
		System.out.println(result.get());
		
		Optional<Book> result1 = books.stream()
				.collect(minBy(comparing(Book::getNumberOfPages)));		
		System.out.println(result1.get());
		
		System.out.println("filter books with only single author");
		books.stream()
			.filter(b -> b.getAuthors().size() == 1)
			.peek(System.out::println)
			.sorted(comparing(Book::getNumberOfPages))
			.forEach(System.out::println);
		
		System.out.println("get list of all titles");
		System.out.println(books.stream()
			.map(Book::getTitle)
			.collect(toList()));
		
		
		System.out.println("get distinct list of all authors");
		/*books.stream()
		//.parallel()
			.map(Book::getAuthors)
			.flatMap(a -> a.stream())
			//.peek(System.out::println)
			.map(a -> a.getName())
			.distinct()
			.forEach(System.out::println);*/
		
		books.stream()
		.parallel()
			.flatMap(b -> b.getAuthors().stream())
			.map(a -> a.getName())
			.distinct()
			.forEach(System.out::println);
	}

}
