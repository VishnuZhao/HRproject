<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/8 0008
  Time: 0:00
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
    <title>refucesEmp</title>
</head>
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
<body id="by">
<div class="c1">
    <h3>恭喜，已经成功拒用此人</h3>
</div>
<div>
    <a href="toAcceptInterview">返回</a>
</div>
</body>
</html>
