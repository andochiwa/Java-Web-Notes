<%--
  Created by IntelliJ IDEA.
  User: 10660
  Date: 2021/2/6
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/08_jsp/">
</head>
<body>
<form action="uploadServlet" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"><br>
    头像：<input type="file" name="photo"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
