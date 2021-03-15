package com.me.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1.先判断上传的数据是否是多段数据（文件）
        if (ServletFileUpload.isMultipartContent(request)) {
            // 创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建用于解析上传数据的工具类ServletFileUpload
            ServletFileUpload sful = new ServletFileUpload(fileItemFactory);
            try {
                // 解析上传的数据，得到每一个表单项FileItem
                List<FileItem> list = sful.parseRequest(request);
                list.forEach(s -> {
                    if(s.isFormField()) {
                        System.out.println(s + "是普通表单项");
                    } else {
                        System.out.println(s + "是文件");
                        try {
                            s.write(new File("E:\\" +s.getName()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

        }

    }
}
