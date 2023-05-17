<%--
  Created by IntelliJ IDEA.
  User: loriyuhv
  Date: 2023/5/17
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/hello/login" method="post">
    <label>
        用户：<input type="text" name="username"><br/>
        密码：<input type="password" name="password"><br/>
        <input type="submit" value="提交">
    </label>
</form>
</body>
</html>
