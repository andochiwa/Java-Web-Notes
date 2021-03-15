<%--
  Created by IntelliJ IDEA.
  User: 10660
  Date: 2021/2/9
  Time: 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/10_filter/">
</head>
<body>
    <%
        Object user = session.getAttribute("user");
        if(user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
    %>
</body>
</html>
