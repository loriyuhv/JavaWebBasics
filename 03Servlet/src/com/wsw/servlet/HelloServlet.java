package com.wsw.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1 构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化方法");
        // 1、可以获取Servlet程序别名servlet-name的值
        System.out.println("HelloServlet程序的别名是：" +
                servletConfig.getServletName());
        // 2、获取初始化参数init-param
        System.out.println("初始化参数username的值是：" +
                servletConfig.getInitParameter("username"));
        // 3. 获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service == Hello Servlet被访问了。");
        // 类型转换（因为它有getMethod()方法）
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 获取请求方式
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)){
            doPost(servletRequest, servletResponse);
        }
    }

    /**
     * 做get请求的操作
     */
    public void doGet() {
        System.out.println("get请求");
        System.out.println("get请求");
    }

    /**
     * 做post请求的操作
     */
    public void doPost(ServletRequest req, ServletResponse resp) throws IOException {
        resp.setCharacterEncoding("GBK");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        if (name.equals("Alan") && pwd.equals("0420"))
            resp.getWriter().write("<h1>欢迎您登录</h1>");
        else
            resp.getWriter().write("<h1>您登录失败，请重新输入</h1>");
        System.out.println("post请求");
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy销毁方法");
    }
}
