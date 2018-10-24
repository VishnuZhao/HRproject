<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/5 0005
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>login</title>
    <style>
        #by{
            background-color: lightpink;
        }
        .c1{
            position:absolute;
            top: 200px;
            left: 500px;
            border: dotted;
            border-width: 2px;
            border-color: deeppink;
        }
    </style>
</head>
<body id="by">
    <div class="c1">
        <legend>用户登陆</legend>
        <form action="loginServlet" method="post">
            用户名：<input name="name" required/><br>
            密&nbsp;&nbsp;&nbsp;码：<input name="pass" type="password" required/><br>
            <input type="checkbox" name="log">记住用户名密码<br/>
            <input type="submit" value="确认登陆">&nbsp;
            <input type="reset" value="重新输入">
        </form>
        <input type="button" value="自动登陆" onclick="location='autoLogin'">
        <span><c:out value="${requestScope.msg}"/></span>
    </div>

    <div id="d1">
        <c:forEach items="${sessionScope.recruits}" var="temp">
            <a href="showRecruit">${temp.name}</a>
        </c:forEach>
    </div>
    <div>
        <a href="index">点我返回欢迎页</a>
    </div>
</body>
</html>
