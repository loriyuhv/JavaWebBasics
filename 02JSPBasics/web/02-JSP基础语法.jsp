<%--
  Created by IntelliJ IDEA.
  User: loriyuhv
  Date: 2023/3/24
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基础语法</title>
</head>
<body>
显式注释<br/>
1.继承HTML风格的注释 &lt;!-- HTML注释 --&gt;<br/>
<!-- Hello world -->
隐式注释<br/>
1. JSP自己的注释 &lt; %-- JSP注释 --%&gt;<br/>
<%--快捷键：Ctrl+/ --%>

2. 继承Java风格的注释 <br/>
    //单行注释 <br/>
    /* 多行注释 */ <br/>
<%
    String name = "<h1>Alan</h1>";
    out.println(name);
    // out对象
%>

</body>
</html>
