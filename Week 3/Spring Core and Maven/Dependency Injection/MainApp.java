package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring application context from XML
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean from context
        BookService bookService = (BookService) context.getBean("bookService");

        // Test adding a book
        bookService.addBook("Pride and Prejudice");
    }
}
