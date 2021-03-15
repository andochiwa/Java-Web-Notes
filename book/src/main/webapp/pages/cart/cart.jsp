<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%--静态包含base标签，css样式，JQuery--%>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%--静态包含登陆成功的菜单--%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteItem").click(function() {
               return confirm("确定要删除[" + $(this).parent().parent().find("td:first").text() + "]吗?")
            });

            $("a.clear").click(function() {
                return confirm("确定要清空购物车吗？");
            });

            $(".updateCount").change(function() {

                var name = $(this).parent().parent().find("td:first").text();
                var count = this.value;
                var bookId = $(this).attr("bookId");

                if(confirm("确定要将[" + name + "]商品修改为数量为：" + count + "吗？")) {
                    location.href = "cartServlet?action=updateCount&count=" + count + "&id=" + bookId;
                } else {
                    this.value = this.defaultValue;
                }
            });
        })
    </script>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">当前购物车为空, 快去首页购物吧！</a></td>
            </tr>
        </c:if>
        <c:if test="${not empty sessionScope.cart.items}">

        </c:if>

        <c:forEach items="${sessionScope.cart.items}" var="entry">
            <tr>
                <td>${entry.value.name}</td>
                <td>
                    <input class="updateCount" style="width: 80px"
                           bookId="${entry.value.id}"
                           type="text" value="${entry.value.count}">
                </td>
                <td>${entry.value.price}</td>
                <td>${entry.value.totalPrice}</td>
                <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a class="clear" href="cartServlet?action=clearItem">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>


</div>

<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
</div>
</body>
</html>