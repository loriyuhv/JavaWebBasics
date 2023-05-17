<%--
  Created by IntelliJ IDEA.
  User: loriyuhv
  Date: 2023/3/24
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include动态包含</title>
</head>
<body>
<%--
    include动态包含
        格式：
            <jsp:include page=""></jsp:include>
        特点：
            1. 动态包含相当于方法的调用
            2. 动态包含会生成多个源码文件
            3. 可以定义同名变量
            4. 效率高，耦合度低
        注意：
            当动态包含不需要传递参数时，include双标签之间不要有任何内容，
                包括换行和空格
            使用动态包含传递参数
            <jsp:include page="">
                <jsp:param name="参数名" value="参数值"/>
            </jsp:include>
            注意：name属性不支持表达式，value属性支持表达式
            获取参数：
                request.getParameter(name); 通过指定参数名获取参数值
--%>

<%-- 动态传递参数 --%>
<%
    String str = "Hello World<br/>";
    String url = "04-header.jsp";
%>

<jsp:include page="<%=url%>">
    <jsp:param name="uname" value="admin"/>
    <jsp:param name="msg" value="<%=str%>"/>
</jsp:include>
<h2>主体内容</h2>
<jsp:include page="04-footer.jsp"></jsp:include>
</body>
</html>
