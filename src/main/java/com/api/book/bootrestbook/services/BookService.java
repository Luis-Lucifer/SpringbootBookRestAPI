package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;


@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();
    static{
        list.add(new Book(123,"JAVA Program","Nilanjan"));
        list.add(new Book(456,"PYTHON Program","Nilanjan"));
        list.add(new Book(789,"LINUX Program","Nilanjan"));
    }

    //get all books
    public List<Book> getAllBooks(){
        return list;

    }

    //get single book by id
    public Book getBookById(int id){
        Book book = null;
        book = list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
        
    }

    //add book
    public Book addBook(Book b){
        list.add(b);
        return b;
    }


    //delete book
    public void deleteBook(int bid) {
        list = list.stream().filter(book -> book.getId()!=bid).collect(Collectors.toList());
    }
}
