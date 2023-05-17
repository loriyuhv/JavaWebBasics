<%--
  Created by IntelliJ IDEA.
  User: loriyuhv
  Date: 2023/5/18
  Time: 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="http://localhost:8080/03Servlet/hello" method="post">
    <input type="hidden" name="action" value="login" />
    <input type="hidden" name="username" value="root" />
    <input type="submit">
  </form>
</body>
</html>
