<%--
  Created by IntelliJ IDEA.
  User: 10660
  Date: 2021/2/6
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope2.jsp页面</h1>
    pageContext:<%=pageContext.getAttribute("key")%><br>
    request:<%=request.getAttribute("key")%><br>
    session:<%=session.getAttribute("key")%><br>
    application<%=application.getAttribute("key")%><br>

</body>
</html>
