package com.me.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Dom4JTest {

    @Test
    public void test1() throws DocumentException {
        // 创建一个SaxReader输入流，读取xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();

        Document read = saxReader.read("xml/books.xml");

        System.out.println(read);
    }

    /**
     * 读取books.xml文件生成Book类
     */
    @Test
    public void test2() throws DocumentException {
        // 1.读取books.xml文件
        SAXReader reader = new SAXReader();
        Document document = reader.read("xml/books.xml");
        // 2.通过Document对象获取根元素
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
        // 3.通过根元素获取boos标签对象
        // element()和elements()都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        // 4.遍历，处理每个book标签转换为Book类
        for(var book : books) {
            // 间接获取标签名文本内容
//            Element name = book.element("name");
//            System.out.println(name.asXML());
            // 直接获取标签名文本内容
//            System.out.println(book.elementText("name"));
        }
    }
}
