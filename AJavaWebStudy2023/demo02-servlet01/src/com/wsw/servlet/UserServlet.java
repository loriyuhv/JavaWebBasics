package com.wsw.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author loriyuhv
 * @date 2025/8/16
 * @description 用户Servlet
 *
 * servlet开发流程
 * 1. 创建JavaWEB项目，同时将Tomcat添加作为当前项目的依赖
 * 2. 重写Service方法，service(HttpServletRequest req, HttpServletResponse resp)
 * 3. 在service方法中，定义业务处理代码
 * 4. 在web.xml中，配置Servlet对应的请求映射路径
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 从req对象中获取请求中的任何信息(username参数)
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");// 根据参数名获取参数值

        // 2. 处理业务代码
        String info = "YES";
        if(username == null || !username.equals("Jerry")){
            info = "你好！！！";
        }

        // 3. 将要响应的数据放入resp
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter(); // 该方法返回的是一个向响应体中打印字符串的打印流
        out.write(info);
    }
}
