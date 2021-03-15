package com.me.dao;

import com.me.pojo.Book;

import java.util.List;

public interface BookDao {

    int addBook(Book book);

    int deleteBookById(int id);

    int updateBook(Book book);

    Book queryBookById(int id);

    List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItem(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemByPrice(int begin, int pageSize, int min, int max);
}
