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
四种属性范围：
    属性保存范围：指的是一个设置的对象，可以在多少个页面
        中保存并可以继续使用
    1. page范围
        pageContext:只在一个页面中保存属性，跳转之后无效
    2. request范围
        request：只在一次请求中保存，服务器跳转后依然有效
    2. session范围
        session：在一次会话范围中，无论何种跳转都可以使用
    3. application范围
        application：在整个服务器上保存
    方法          类型      描述
    public void setAttribute(String name, Object o) 普通 设置属性及内容
    public Object getAttribute(String name) 普通 根据属性名称取属性
    public void removeAttribute(String name) 普通 删除指定的属性
验证属性范围的特点
    1. page
        本页面取得服务器端跳转（<jsp:forward>)后无效
    2. request
        服务器跳转有效，客户端跳转无效
        如果是客户端跳转，则相当于发送了两次请求，那么第一次请求
            将不存在了；如果希望不管是客户端还是服务器跳转，都能
            保存的话，就需要继续扩大范围。
    3. session

    问：使用哪个范围呢？
    答：在合理的范围尽可能小 request最多

    page作用域
        在当前页面有效，跳转后无效
    request作用域
        在一次请求中有效，服务端跳转有效，客户端跳转失效
    session作用域
        在一次会话中有效，服务端和客户端跳转都有效
    application作用域
        在整个应用中有效

    JSP跳转方式
        1. 服务端跳转
            <jsp:forward page="06-JSP四大域对象-02.jsp"></jsp:forward>
        2. 客户端跳转
            超链接
--%>
<%
    // 设置page范围的域对象
    pageContext.setAttribute("name1", "Alan");
    // 设置request范围的域对象
    request.setAttribute("name2", "Walker");
    // 设置session范围的域对象
    session.setAttribute("name3", "Jack");
    // 设置application范围的域对象
    application.setAttribute("name4", "Jerry");
%>

<%
    String name = (String) pageContext.getAttribute("name1");
    System.out.println(name);
    out.print(name);

%>
<%=name + "<br/>"%>

<%-- Jsp中服务端跳转--%>
<%--<jsp:forward page="06-JSP四大域对象-02.jsp"></jsp:forward>--%>
<%-- 超链接跳转 --%>
<a href="06-JSP四大域对象-02.jsp">跳转</a>

</body>
</html>
