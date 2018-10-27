<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/6 0006
  Time: 19:41
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
    <title>添加部门</title>
    <style>
        #by{
            background-color: lightpink;
        }
        #d1{
            position:absolute;
            top: 200px;
            left: 500px;
            border: solid;
            border-width: 2px;
            border-color: deeppink;
        }
    </style>

</head>
<body id="by">
<div id="d1">
    <form action="addDepartmentServlet" method="post">
        部门名称：<input name="name" required>
        <br/>
        <span id="sp1"></span>
        <br/>
        <input type="submit" value="确认">
        <input type="reset" value="重置">
    </form>
    <span><c:out value="${requestScope.addDepartment}"></c:out></span>

</div>
<div>
    <a href="toManageDep">返回</a>
</div>
</body>
</html>
