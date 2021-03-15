package com.me.test;

import com.me.dao.BookDao;
import com.me.dao.impl.BookDaoImpl;
import com.me.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao book = new BookDaoImpl();

    @Test
    public void addBook() {
        book.addBook(new Book(null, "国哥真帅", "191125", new BigDecimal(9999), 11000000, 0, null));

    }

    @Test
    public void deleteBookById() {
        book.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        book.updateBook(new Book(21, "国哥真的帅", "191125", new BigDecimal(9999), 11000000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(book.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        var list = book.queryBooks();
        list.forEach(System.out::println);
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(book.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItem() {
        List<Book> books = book.queryForPageItem(8, 4);
        books.forEach(System.out::println);
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(book.queryForPageTotalCountByPrice(10, 50));
    }

    @Test
    public void queryForPageItemByPrice() {
        List<Book> books = book.queryForPageItemByPrice(4, 4, 10, 50);
        books.forEach(System.out::println);
    }
}