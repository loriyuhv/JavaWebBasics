<%--
  Created by IntelliJ IDEA.
  User: loriyuhv
  Date: 2023/3/24
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scriptlet</title>
</head>
<body>
Scriptlet(脚本小程序） <br/>
第一种：&lt;%  %&gt;:java脚本段 可以定义局部变量编写语句 <br/>
第二种：&lt;%! %&gt;:声明，可以定义全局变量、方法、类 <br/>
第三种：&lt;%= %&gt;:表达式，数据一个变量或具体的内容 <br/>

<%--第一种：--%>
<%
    // 定义局部变量
    String str = "Hello JSP";
    // 输出内容到控制台
    System.out.println(str);
    // 输出内容到浏览器
    out.println(str);
    out.write("<br/>全局变量：" + num);
%>
<%--第二种：--%>
<%!
    //声明全局变量
    int num = 10;
%>

<%--第三种：--%>
<%="<br/>" + str%>
</body>
</html>
