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
    <title>showDetails</title>
</head>
<body>
    <table border="1" cellspacing="0">
        <tr>
            <td colspan="2">简历名称</td>
            <td colspan="2">${sessionScope.resume.rename}</td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>${sessionScope.resume.uname}</td>
            <td>性别</td>
            <td>${sessionScope.resume.sex}</td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>${sessionScope.resume.age}</td>
            <td>手机号</td>
            <td>${sessionScope.resume.phone}</td>
        </tr>
        <tr>
            <td>学历</td >
            <td>${sessionScope.resume.education}</td>
        </tr>
        <tr>
            <td>毕业院校</td>
            <td>${sessionScope.resume.school}</td>
            <td>专业</td>
            <td>${sessionScope.resume.major}</td>
        </tr>
        <tr>
            <td>工作年限</td>
            <td>${sessionScope.resume.workyear}</td>
        </tr>
        <tr>
            <td>自我介绍</td>
            <td>${sessionScope.resume.interoduction}</td>
        </tr>

    </table>
<div>
    <a href="toShowDelivery">返回</a>
</div>
</body>
</html>
