# 搭建Java服务器开发环境

**必装工具**

- JDK 17.0.16
- Tomcat 10
- IntelliJ IDEA ULtimate 2025

## 准备工作

### 1. IDEA配置JDK17

**首先打开IDEA**

1）点击File -->Project Structure；

![001](.\images\ReadyWork\ConfigureJDK\001.png)

2）点击左侧标签页SDKs选项，再点击左上角“+”，选择Add JDK；

![001](.\images\ReadyWork\ConfigureJDK\002.png)

3）在弹出框选择JDK安装路径，点击OK即可配置成功。

![001](.\images\ReadyWork\ConfigureJDK\003.png)

![001](.\images\ReadyWork\ConfigureJDK\004.png)

### 2. Idea配置Tomcat

1）单击”File“-”Settings"，在“Settings"对话框中，选择“Build,Execution,Deployment"-“Application Servers”，在右侧菜单栏中进行操作。单击“+”，在打开的对话框中选择“Tomcat Server"即可。

![001](.\images\ReadyWork\ConfigureTomcat\001.png)

2）选择Tomcat安装目录，单击”OK"-"OK"即可。

![002](.\images\ReadyWork\ConfigureTomcat\002.png)



## 一、在IDEA新建项目

### 1.1 新建项目

**1）单击"File"-"New"-"Project"。**

![001](.\images\newproject\001.png)

**2）选择"Empty Project"，更改项目名称和地址，单击“create”即可。**

![002](.\images\newproject\002.png)

### 1.2 添加模块

**描述：添加模块，例如JavaWebStudy模块**

1）点击“File” -->“Project Structure”；

2）在“Project Settings"选择“Modules”，单击“+”-"New Module"。

![003](.\images\newproject\003.png)

3）在“New Module"对话框中，进行图中配置。

![004](.\images\newproject\004.png)

4）单击“applay"->"ok"即可。

![005](.\images\newproject\005.png)

### 1.3 成功

**1）创建成功之后如图**

![006](.\images\newproject\006.png)

注意：src是source，存放Java源代码的目录

**测试**

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world\n");
    }
}
```

## 二、增加Web框架

### 2.1 添加Tomcat依赖

Tomcat10版本

1）在“Project Structure“对话框中“Project Settings"的“Modules"下，选中“JavaWebStudy"模块，在右侧操作栏中，选择“Dependencies"，单击“+”，打开对话框，选择2 Libray。在打开的对话框中，选择Tomcat 10.1.44，单击“Add Selected“即可，最后单击”Apply“-”OK“即可。

![000](.\images\CreatedWebFramework\000.png)

**2）Ctrl+Shift+A，打开搜索Actions对话框，搜索Add Framework Support，选中结果即可。**

![001](.\images\CreatedWebFramework\001.png)

**3）选择Web**

![001](.\images\CreatedWebFramework\002.png)

**3）移除Web框架**

在“Project Structure“对话框中“Project Settings"的“Modules"下，选择需要移除Web框架的模块，单击“>"展开，选中"Web"，单击”—”即可。

### 2.2 成功

**添加成功如图**

![003](.\images\CreatedWebFramework\003.png)

**注意**

web目录下放的是你想给客户端提供的一些资源，例如index.jsp。



**问：客户端如何访问你的资源呢？**

启动Tomcat，然后把项目部署到Tomcat，通过```http://localhost:8080/```访问。

## 三、配置Tomcat运行环境

### 3.1 集成Tomcat环境

**1.打开**

![001](.\images\DeployedTomcat\001.png)

![001](.\images\DeployedTomcat\002.png)

**2. 集成Tomcat环境**

![001](.\images\DeployedTomcat\003.png)

![001](.\images\DeployedTomcat\004.png)

### 3.2 部署项目

![001](.\images\DeployedTomcat\005.png)

![001](.\images\DeployedTomcat\006.png)

![001](.\images\DeployedTomcat\007.png)

**把这里改成”为什么要部署项目呢？“最好**

图中Application context里/01hello代表了什么呢？

当用户访问项目的时候，是通过```http://IP地址:端口号/资源路径```这种方式访问的，访问例如这个路径```http://127.0.0.1:8080/hello/```表示的是访问如图目录（红线标记）下的资源。也就是说，/01hello代表了web这个目录。

![001](.\images\DeployedTomcat\008.png)

### 3.3 运行

**1.运行**

![001](.\images\DeployedTomcat\009.png)

**2.成功**

![001](.\images\DeployedTomcat\010.png)

![001](.\images\DeployedTomcat\011.png)

## 四、Servlet简单运用

### 4.1 需求

需求，我想将我的用户名和密码发给自己的服务器而不是百度。

**1. 发给百度实现**

**代码**

```jsp
<body>
  <form action="https://www.baidu.com">
      <label>
          用户：<input type="text" name="username"><br/>
          密码：<input type="password" name="password"><br/>
          <input type="submit" value="提交">
      </label>
  </form>
</body>
```

**效果图**

![001](.\images\useServlet\002.png)

**2. 发给01hello项目**

**代码**

```jsp
<body>
  <form action="/hello">
      <label>
          用户：<input type="text" name="username"><br/>
          密码：<input type="password" name="password"><br/>
          <input type="submit" value="提交">
      </label>
  </form>
</body>
```

**效果图**

![001](.\images\useServlet\001.png)

需求：我（客户端）想把用户名和密码发送给01hello(服务器)，01hello处理数据并返回登录成功或失败页面（success.jsp/fail.jsp)，这个时候就需要用到Servlet了。

### 4.2 使用Servlet

#### 4.2.1 使用Servlet前提

使用Servlet前提：引用Tomcat里面某些库如图：

![001](.\images\useServlet\003.png)

 **导入过程**

**1.导入**

![001](.\images\useServlet\004.png)

![001](.\images\useServlet\005.png)

![001](.\images\useServlet\006.png)

![001](.\images\useServlet\007.png)

**2.成功**

![001](.\images\useServlet\008.png)

#### 4.2.2 使用

注意：在Java里面要有包的概念，如图：

![001](.\images\useServlet\009.png)

代码中的一些概念问题：

1. 为什么要写@WebServlet("/login")?

   ![001](.\images\useServlet\010.png)

2. 

**项目目录结构**

![001](.\images\useServlet\011.png)

**jsp代码**

accessHello.jsp

```jsp
<body>
<form action="/hello/login" method="post">
    <label>
        用户：<input type="text" name="username"><br/>
        密码：<input type="password" name="password"><br/>
        <input type="submit" value="提交">
    </label>
</form>
</body>
```

success.jsp

```jsp
<body>
<h1>登录成功！！！</h1>
</body>
```

fail.jsp

```jsp
<body>
<h1>登录失败！！！</h1>
</body>
```

**Servlet代码**

```java
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
```

#### 4.2.3 效果图

**成功**

![001](.\images\useServlet\012.png)

**失败**

![001](.\images\useServlet\013.png)



# 添加模块

## 1、添加

### 1.1 项目结构图

![001](.\images\addModules\001.png)

### 1.2 添加

![001](.\images\addModules\002.png)

![001](.\images\addModules\003.png)

![001](.\images\addModules\004.png)

### 1.3 项目结构图（完成）

![001](.\images\addModules\005.png)