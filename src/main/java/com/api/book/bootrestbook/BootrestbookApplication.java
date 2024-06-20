package com.api.book.bootrestbook;

import com.api.book.bootrestbook.dao.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.api.book.bootrestbook.entities.Book;
import java.util.List;


@SpringBootApplication
public class BootrestbookApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(BootrestbookApplication.class, args);

	BookRepository bookRepository = context.getBean(BookRepository.class);
	Book book1 = new Book();
	book1.setTitle("Learn Python");
	book1.setAuthor("MNOP");

	Book book2 = new Book();
	book2.setTitle("Learn Java");
	book2.setAuthor("ABCD");

	List<Book> books = List.of(book1,book2);

	Iterable<Book> result=bookRepository.saveAll(books);

	result.forEach(book->{
		System.out.println(book);
	});


	Iterable<Book> itr = bookRepository.findAll();

	itr.forEach(book -> {
		System.out.println(book);
	});


	}

}
