<%--
  Created by IntelliJ IDEA.
  User: 10660
  Date: 2021/2/9
  Time: 3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是登录login.jsp页面。
    <form action="http://localhost:8080/10_filter/loginServlet" method="get">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password">
        <input type="submit"><br>
    </form>
</body>
</html>
