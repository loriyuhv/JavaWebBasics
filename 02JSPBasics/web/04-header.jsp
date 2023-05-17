<%--
  Created by IntelliJ IDEA.
  User: loriyuhv
  Date: 2023/3/24
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>头部</title>
</head>
<body>
<h2>头部内容</h2>
<%
    int a = 10;
    //获取动态包含传递的参数
    String uname = request.getParameter("uname");
    String msg = request.getParameter("msg");
    out.print(uname + "：" + msg);
%>
</body>
</html>
