package com.me.web;

import com.me.pojo.Book;
import com.me.pojo.Page;
import com.me.service.BookService;
import com.me.service.impl.BookServiceImpl;
import com.me.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGESIZE);
        // 2.调用BookService.page(pageNo, pageSize):page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        // 3.保存page对象到request域中
        request.setAttribute("page", page);
        // 4.请求转发到pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGESIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);

        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");

        if(request.getParameter("min") != null) {
            sb.append("&min=").append(min);
        }
        if(request.getParameter("max") != null) {
            sb.append("&max=").append(max);
        }

        page.setUrl(sb.toString());

        request.setAttribute("page", page);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

}
