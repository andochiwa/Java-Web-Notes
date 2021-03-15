package com.me.test;

import com.me.pojo.Book;
import com.me.pojo.Page;
import com.me.service.BookService;
import com.me.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "国哥真帅", "191125", new BigDecimal(9999), 11000000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
        bookService.deleteBookById(23);
        bookService.deleteBookById(24);

    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "国哥真的帅", "191125", new BigDecimal(9999), 11000000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(System.out::println);
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, Page.PAGESIZE));
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1, Page.PAGESIZE, 10, 50));
    }
}