<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/27 0027
  Time: 14:46
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
    <title>updateUser</title>
</head>
<body>
<form action="updateUserServlet" method="post">
    密码：<input type="text" name="pass" value="<c:out value="${sessionScope.user.u_pass}"/>"/><br/>
    <input type="hidden" name="name" value="<c:out value="${sessionScope.user.u_name}"/>"/><br/>
    <input type="hidden" name="id" value="<c:out value="${sessionScope.user.u_id}"/>"/>
    <input type="submit">
</form>

<div>
    <a href="toHomePage">点我返回主页</a>
</div>
</body>
</html>
