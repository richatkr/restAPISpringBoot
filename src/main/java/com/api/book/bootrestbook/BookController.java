package com.api.book.bootrestbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.dao.BookRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
private BookRepository bookRepository;
    //book.setId(3)
    @GetMapping("/books")
    public List<Book> getBooks(){
        return (List<Book>) bookRepository.findAll();
    }

@GetMapping("/books/{id}")
    public Optional<Book> getBook(@PathVariable("id") int id){
        return bookRepository.findById(id);
}

@PostMapping("/books")
public Book addBook(@RequestBody Book book) {
    Book newBook = this.bookRepository.save(book);
    return newBook;
}

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        Book oldBook = this.bookRepository.findById(id).get();
        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
        Book updatedBook = this.bookRepository.save(oldBook);
        return updatedBook;
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        this.bookRepository.deleteById(id);
    }

}
