package com.me.upload;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取要下载的文件名
        String downloadFileName = "1.jpg";

        // 2.读取下载的文件内容(通过ServletContext对象可以读取)
        ServletContext context = getServletContext();
        InputStream rs = context.getResourceAsStream("/file/" + downloadFileName);
        OutputStream os = response.getOutputStream();

        // 3.告诉客户端返回的数据类型
        response.setContentType(context.getMimeType("/file/" + downloadFileName));

        // 4.还要告诉客户端收到的数据是用于下载的
        // Content-Disposition响应头，表示收到的数据怎么处理
        // attachment表示附件，表示下载使用
        // filename= 表示指定下载的文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName);

        // 5.把下载的文件回传给客户端
        // 读取输入流的数据，复制给输出流，输出给客户端
        IOUtils.copy(rs, os);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
