
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>manageTraining</title>
    <style>
        #by{
            background-color: lightpink;
        }
    </style>
</head>
<body id="by">

<div id="d2">
    <input type="button" value="添加培训" onclick="location='toAddTra'">
</div>

<div id="d3">
    <input type="button" value="查看记录" onclick="location='toShowTra'">
</div>

<div id="d8">
    <a href="toAdminPage">返回</a>
</div>
</body>
</html>
