<%--
  Created by IntelliJ IDEA.
  User: 10660
  Date: 2021/2/6
  Time: 5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 往四个域中都保存了相同的key的域
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>
    ${key}<br>
    ${requestScope.key}
</body>
</html>
