
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>homePage</title>
    <style>
        #by{
            background-color: lightpink;
        }
    </style>
</head>
<body id="by">
<div id="d1"><span>用户名：${sessionScope.name}-欢迎回到个人中心！</span><br/></div>

<div id="d2">
    <input type="button" value="应聘管理" onclick="location='toShowDelivery'">
</div>

<div id="d3">
    <input type="button" value="面试管理" onclick="location='toAcceptInterview'">
</div>

<div id="d4">
    <input type="button" value="部门管理" onclick="location='toManageDep'">
</div>

<div id="d6">
    <input type="button" value="职位管理" onclick="location='toManagePos'">
</div>

<div id="d5">
    <input type="button" value="员工管理" onclick="location='toManageEmp'">
</div>

<div id="d7">
    <input type="button" value="员工管理" onclick="location='toManageTra'">
</div>

</body>
</html>
