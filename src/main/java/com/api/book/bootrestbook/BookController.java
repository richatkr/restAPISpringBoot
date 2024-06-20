package com.api.book.bootrestbook;

import com.api.book.bootrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.dao.BookRepository;


import java.util.List;



//@Controller

@RestController
public class BookController {


    @Autowired
private BookService bookService;
//@RequestMapping(value="/books", method = RequestMethod.GET)
//@ResponseBody
    Book book=new Book();
    //book.setId(3)
    @GetMapping("/books")
    public List<Book> getBooks(){
        //return "This is Testing Book Second";
        return this.bookService.getallBooks();
    }

//    private String args;
//    ApplicationContext context = SpringApplication.run(BootrestbookApplication.class, args);

//    BookRepository bookRepository = context.getBean(BookRepository.class);
//    Iterable<Book> itr = bookRepository.findAll();

     //option 3 using lambda function
//		itr.forEach(user -> {
//			System.out.println(user);
//		});
@GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id){
        return bookService.getBookById(id);
}

@PostMapping("/books")
public Book addBook(@RequestBody Book book) {
    this.bookService.addBook(book);
    return book;
}

}
