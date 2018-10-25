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
    <title>writeInterviewMess</title>
</head>
<body>
    <form action="sendInterview" method="post">
        <table>
            <tr>
                <td>请输入面试地址</td>
                <td><input type="text" name="address" required></td>
            <tr>
                <td>请输入面试日期</td>
                <td><input type="date" name="date" required></td>
            </tr>
            <tr>
                <td>请输入面试时间</td>
                <td><input type="time" name="time" required></td>
            </tr>
            <tr>
                <td><input type="submit" value="确认"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
<div>
    <a href="toHomePage">点我返回主页</a>
</div>
</body>
</html>
