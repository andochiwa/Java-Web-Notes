<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%--静态包含base标签，css样式，JQuery--%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        // 给删除的a标签绑定单击事件，用于提示是否删除
        $(function () {
            $("a.deleteClass").click(function () {
                return confirm("确定要删除" + $(this).parent().parent().find("td:first").text() + "吗?");
            });
        });

        $(function () {
            $("#searchPageBtn").click(function () {
                let pageNo = $("#pn_input").val();

                // javascript语言中提供了一个laction地址栏对象
                // 它有一个属性href可以获取浏览器地址栏中的地址
                // 可以赋值直接跳转
                location.href = "http://localhost:8080/book/${requestScope.page.url}&pageNo=" + pageNo;
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <C:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>
            </tr>
        </C:forEach>


        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
        </tr>
    </table>
    <%--静态包含分页条--%>
    <%@include file="/pages/common/page_nav.jsp"%>
</div>

<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
</div>
</body>
</html>