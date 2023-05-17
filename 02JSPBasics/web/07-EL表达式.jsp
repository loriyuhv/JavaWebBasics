<%--
  Created by IntelliJ IDEA.
  User: loriyuhv
  Date: 2023/3/24
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    语法：${expression}
    EL表达式一般操作的都是域对象中的数据，操作不了局部变量。

    注意：
        1. 如果EL表达式获取域对象的值为空，默认显示空字符串
        2. EL表达式默认从小到大范围去找，找到即可，如果四个
            范围都未找到，则显示空字符串

--%>
<%--设置数据--%>
<%
    // 设置page范围的域对象
    pageContext.setAttribute("name", "Alan");
    // 设置request范围的域对象
    request.setAttribute("name", "Walker");
    // 设置session范围的域对象
    session.setAttribute("name", "Jack");
    // 设置application范围的域对象
    application.setAttribute("name", "Jerry");
%>
<%-- 获取数据 --%>
${name}
${pageScope.name}
${sessionScope.name}
${requestScope.name}
${applicationScope.name}

</body>
</html>
