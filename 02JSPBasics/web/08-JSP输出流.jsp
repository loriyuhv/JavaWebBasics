<%--
  Created by IntelliJ IDEA.
  User: loriyuhv
  Date: 2023/5/17
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>08-JSP输出流</title>
</head>
<body>
  <%--
  jsp 中out 输出流和response.getwriter()输出流
  --%>

  <%
    // 1）jsp 中 out 和response 的writer 的区别演示
    // out输出
    out.write("这是 out 的第一次输出<br/>");
    // out flush 之后。会把输出的内容写入 writer 的缓冲区中
    out.flush();
    /*
    * 最后一次的输出，由于没有手动 flush，会在整个页面输出到客户端的时候，
    * 自动写入到writer缓冲区
     */
    out.write("这是 out 的第二次输出<br/>");
    // writer输出
    response.getWriter().write("这是writer第一次输出<br/>");
    response.getWriter().write("这是writer第二次输出<br/>");
  %>
</body>
</html>
