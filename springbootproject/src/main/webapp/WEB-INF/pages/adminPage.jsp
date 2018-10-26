
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
    <input type="button" value="查看应聘信息" onclick="location='toShowDelivery'">
</div>

<div id="d3">
    <input type="button" value="查看已接受的面试" onclick="location='toAcceptInterview'">
</div>

<div id="d4">
    <input type="button" value="部门职位管理" onclick="location='toManageDepAndPos'">
</div>
</body>
</html>
