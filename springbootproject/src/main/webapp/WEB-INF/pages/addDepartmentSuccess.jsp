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
    <title>addDepartmentSuccess</title>
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
        <h3>恭喜，部门添加成功</h3>
    </div>

    <div>
        <a href="toManageDepAndPos">返回</a>
    </div>
</body>
</html>
