# 搭建Java服务器开发环境

**必装工具**

- JDK 17.0.16
- Maven 3.9.11
- Tomcat 10.1.44
- IntelliJ IDEA ULtimate 2025

## 准备工作

### 1. IDEA新建空项目

**1）单击"File"-"New"-"Project"。**

![001](.\images\ReadyWork\CreateEmptyProject\001.png)

**2）选择"Empty Project"，更改项目名称和地址，单击"Create"即可。**

![002](.\images\ReadyWork\CreateEmptyProject\002.png)

**3）创建成功**

![003](.\images\ReadyWork\CreateEmptyProject\003.png)

### 2. IDEA配置JDK17

#### 2.1 导入JDK17

**1）单击"File" -->"Project Structure"；**

![001](.\images\ReadyWork\ConfigureJDK\001.png)

**2）单击左侧标签页"SDKs"选项，再点击左上角"+"，选择"Add JDK from disk..."；**

![001](.\images\ReadyWork\ConfigureJDK\002.png)

**3）在弹出框选择JDK安装路径，点击OK即可导入成功。**

![001](.\images\ReadyWork\ConfigureJDK\003.png)

![004](.\images\ReadyWork\ConfigureJDK\004.png)

#### 2.2 配置JDK17

**1）单击"Project"，在右侧栏中进行设置，单击"Apply"-->"OK"即可。**

![005](.\images\ReadyWork\ConfigureJDK\005.png)

### 3. IDEA配置Maven

**1）单击"File"-"Settings"，在"Settings"对话框中，选择"Build,Execution,Deployment"-->"Build Tools"-->"Maven"，在右侧菜单栏中进行图中操作。**

![001](.\images\ReadyWork\ConfigureMaven\001.png)

**2）新建模块时使用本地模板。**

```cmd
-DarchetypeCatalog=internal
```

![002](.\images\ReadyWork\ConfigureMaven\002.png)

可以解决这个问题：[WARNING] No archetype found in remote catalog. Defaulting to internal catalog

参考链接：https://blog.51cto.com/xdr630/5104498

### 4. Idea配置Tomcat

**1）单击"File"-"Settings"，在"Settings"对话框中，选择"Build,Execution,Deployment"-"Application Servers"，在右侧菜单栏中进行操作。单击"+"，在打开的对话框中选择"Tomcat Server"即可。**

![001](.\images\ReadyWork\ConfigureTomcat\001.png)

**2）选择Tomcat安装目录，单击"OK"-"OK"即可。**

![002](.\images\ReadyWork\ConfigureTomcat\002.png)

## 一、创建JavaSE项目

描述：在空项目 **SpringMVCReview**中创建一个 JavaSE 模块，命名为 **springmvc_01_quickstart**。

### 1.1 添加模块

**1）点击"File" -->"Project Structure"；**

**2）在"Project Settings"选择"Modules"，单击"+"-->"New Module"。打开"New Module"对话框，进行图中操作。**

![001](.\images\CreateJavaSEProject\001.png)

**注意：**红色框中的 `springmvc_01_quickstart` 和黄色框中的 `springmvc_01_quickstart` 是不同的。如果需要从本地计算机文件中查找，请使用红色框中的路径；如果需要从 Maven 仓库中查找，请使用黄色框中的路径。

**4）单击"Applay"-->"OK"即可。**

### 1.2 完善模块

**1）添加成功之后需要完善模块，如图**

![002](.\images\CreateJavaSEProject\002.png)

**注意：**src是source，存放Java源代码的目录；pom.xml是Maven核心配置文件

**测试**

```java

```

## 二、创建JavaWeb项目

### 2.1 添加模块

**1）点击"File" -->"Project Structure"；**

**2）在"Project Settings"选择"Modules"，单击"+"-->"New Module"。打开"New Module"对话框，进行图中操作。**

![001](.\images\CreateJavaWebProject\001.png)

**3）精简pom.xml，并且查看成功标志。**

![002](.\images\CreateJavaWebProject\002.png)

### 2.2 完善模块

**1）补齐缺失目录：右击"src"-->"New"-->"Directory"，在打开的"New Directory"对话框一次选择图中目录即可。**

![003](.\images\CreateJavaWebProject\003.png)

**2）完整目录结构。**

![004](.\images\CreateJavaWebProject\004.png)

### 2.3 修改pom.xml

**1）删除远程访问的名称**

```
<name>springmvc_02_bean_load Maven Webapp</name>
<url>http://maven.apache.org</url>
```

**2）添加依赖**

```xml
<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.0.0</version>
    <scope>provided</scope>
</dependency>
```

**3）删除项目构建名称**

```xml
<build>
  <finalName>springmvc_02_bean_load</finalName>
</build>
```

### 2.4 修改web.xml

描述：为什么需要修改web.xml，因为版本过低，导致与主流的Tomcat不兼容。

**1）删除原先的web.xml。**

> 注意：一定要Aplly，不能无法生效。

![005](.\images\CreateJavaWebProject\005.png)

**2）单击"Apply"，使操作生效。**

![006](.\images\CreateJavaWebProject\006.png)

**3）添加Tomcat10.1.44对应版本的web.xml。**

![007](.\images\CreateJavaWebProject\007.png)

**4）确认好之后单击"OK"。**

![008](.\images\CreateJavaWebProject\008.png)

**5）成功**

![009](.\images\CreateJavaWebProject\009.png)

### 2.5 测试项目

1）DemoServlet.java

```java
package com.wsw.controller;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo is running ...");
        req.getRequestDispatcher("/main.jsp").forward(req,resp);
    }
}
```

2）index.jsp和main.jsp代码

```jsp
<%-- index.jsp 核心代码 --%>
<a href="${pageContext.request.contextPath}/demo">跳转页面</a>

<%-- main.jsp 核心代码 --%>
<h1>Hello world!!!</h1>
```

注意：web目录下放的是你想给客户端提供的一些资源，例如index.jsp。

**问：客户端如何访问你的资源呢？**

启动Tomcat，然后把项目部署到Tomcat，通过```http://localhost:8080/```访问。

## 三、配置Tomcat运行环境

### 3.1 集成Tomcat环境

**1）打开"Run/Debug Configurations"对话框。**

![001](.\images\DeployTomcat10\001.png)

**2）单击"+"，选择"Tomcat Server"-"Local"。**

![002](.\images\DeployTomcat10\002.png)

**3）配置Tomcat版本，选择之后，依次单击"OK"即可**

![003](.\images\DeployTomcat10\003.png)

**4）选择"Tomcat 10.1.44"版本**

![004](.\images\DeployTomcat10\004.png)

### 3.2 部署项目

**1）添加项目部署**

![005](.\images\DeployTomcat10\005.png)

2）简化项目访问路径

![006](.\images\DeployTomcat10\006.png)

**把这里改成”为什么要部署项目呢？“最好**

图中Application context里/01hello代表了什么呢？

当用户访问项目的时候，是通过```http://IP地址:端口号/资源路径```这种方式访问的，访问例如这个路径```http://127.0.0.1:8080/springmvc01/```表示的是访问如图目录（红线标记）下的资源。也就是说，/springmvc01代表了web这个目录。如图所示。

![007](.\images\DeployTomcat10\007.png)

### 3.3 运行

**1）运行项目springmvc02。**

![008](.\images\DeployTomcat10\008.png)

**2）访问默认页面**

![009](.\images\DeployTomcat10\009.png)

**3）单击"跳转页面"，前端展示结果如图。**

![010](.\images\DeployTomcat10\010.png)

**4）单击"跳转页面"，后端展示结果如图。**

![011](.\images\DeployTomcat10\011.png)


