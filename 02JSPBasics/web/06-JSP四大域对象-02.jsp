<%--
  Created by IntelliJ IDEA.
  User: loriyuhv
  Date: 2023/3/24
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--

--%>
<%
    // 获取域对象中的值
    out.print("page范围：" + pageContext.getAttribute("name1") + "<br/>");
    out.println("request范围：" + request.getAttribute("name2") + "<br/>");
    out.println("session范围：" + session.getAttribute("name3") + "<br/>");
    out.println("application范围：" + application.getAttribute("name4") + "<br/>");
%>

</body>
</html>
