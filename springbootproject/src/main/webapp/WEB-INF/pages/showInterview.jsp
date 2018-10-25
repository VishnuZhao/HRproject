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
    <title>showInterview</title>
</head>
<body>
    <table border="1" cellspacing="0">
        <tr>
            <td>面试岗位</td>
            <td>${sessionScope.recruit.name}</td>
        </tr>
        <tr>
            <td>面试时间</td>
            <td>${sessionScope.interview.date}</td>
        </tr>
        <tr>
            <td>面试地点</td>
            <td>${sessionScope.interview.address}</td>
        </tr>
        <tr>
            <td><a href="acceptInterview?itid=${sessionScope.interview.id}">接受面试</a> </td>
            <td><a href="refuseInterview?itid=${sessionScope.interview.id}">拒绝面试</a></td>
        </tr>
    </table>
<div>
    <a href="toHomePage">返回</a>
</div>
</body>
</html>
