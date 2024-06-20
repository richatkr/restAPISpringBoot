package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import com.api.book.bootrestbook.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    public static List<Book> list=new ArrayList<>();

    static {
        list.add(new  Book(3,"Java Complete Reference","XYZ"));
        list.add(new  Book(4,"Python Complete Reference","abc"));
        list.add(new  Book(5,"C++ Complete Reference","lmn"));

    }

    //get by book
    public List<Book> getallBooks(){
        return list;
    }

    //get one book by id
    public Book getBookById(int id){

        Book book=null;
        book = (Book) list.stream().filter(e-> (e.getId()==id));
//        book = list.foreach(id->{
//            if(id=id1){
//                return book;
//            }
//        })

        return book;


    }

    public Book addBook(Book book){
        list.add(book);
        return book;
    }



}
