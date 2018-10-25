<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/19 0019
  Time: 16:26
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
    <title>index</title>
    <style>

        #d1{
            position: relative;
            left: 300px;
        }
    </style>
</head>
<body>
<div id="d2">
    <a href="toHomePage">${sessionScope.msg}</a>
</div>
                <div id="d3">
                    <a href="toRegister" id="a1">注册</a>
                </div>
                <div id="d4">
                    <a href="toLogin">登录</a>
                </div>
                <div id="d1">
        <h3 style="color: #e10030">招聘信息</h3>
        <c:forEach items="${sessionScope.recruits}" var="temp">
            <table>
            <tr>
                <td colspan="2">岗位名称</td>
                <td colspan="2">${temp.name}</td>
            </tr>
            <tr>
                <td colspan="2">所需学历</td>
                <td colspan="2">${temp.education}</td>
            </tr>
            <tr>
                <td colspan="2">工作地点</td>
                <td colspan="2">${temp.address}</td>
            </tr>
            <tr>
                <td colspan="2">所需学历</td>
                <td colspan="2">${temp.education}</td>
            </tr>
            <tr>
                <td >职业要求</td>
                <td colspan="3">${temp.requirement}</td>
            </tr>
            <tr>
                <td>薪资待遇</td>
                <td colspan="3">${temp.treatment}</td>
            </tr>
                <tr>
                    <td colspan="2"><a href="toChooseResume?rc_id=${temp.id}">我要应聘</a></td>
                </tr>
            </table>
            <hr width="200px" align="left">
        </c:forEach>

</div>
</body>
</html>
