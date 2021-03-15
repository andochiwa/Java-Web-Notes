package com.me.service.impl;

import com.me.dao.BookDao;
import com.me.dao.impl.BookDaoImpl;
import com.me.pojo.Book;
import com.me.pojo.Page;
import com.me.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = (pageTotalCount - 1) / pageSize + 1;
        page.setPageTotal(pageTotal);

        int begin = (pageNo - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItem(begin, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = (pageTotalCount - 1) / pageSize + 1;
        page.setPageTotal(pageTotal);

        int begin = (pageNo - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItemByPrice(begin, pageSize, min, max);
        page.setItems(items);
        return page;
    }
}
