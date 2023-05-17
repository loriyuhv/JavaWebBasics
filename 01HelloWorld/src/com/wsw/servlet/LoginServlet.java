package com.wsw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理登录请求
 * 1. 继承HttpServlet，才能够处理HTTP请求
 * 2. 使用@WebServlet，说明他要处理的请求路径
 * 获取username和password
 * 1. 使用req.getParameter()获取
 * 判断是否符合条件
 * 使用sendRedirect()跳转success.jsp或fail.jsp
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        //System.out.println("DoPost----!!!");
        String user = req.getParameter("username");
        String pwd = req.getParameter("password");
        if (user.equals("Alan") && pwd.equals("0420"))
            resp.sendRedirect("/hello/success.jsp");
        else
            resp.sendRedirect("/hello/fail.jsp");
    }
}
