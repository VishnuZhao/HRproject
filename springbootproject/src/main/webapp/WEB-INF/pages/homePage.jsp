
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
    <input type="button" value="添加简历" onclick="location='toAdduserdetail'">
</div>
<div id="d3">
    <input type="button" value="查看简历" onclick="location='showUserDetailServlet'">
</div>
<div id="d4">
    <input type="button" value="注销账户" onclick="location='delUserServlet'">
</div>
<div id="d5">
    <input type="button" value="修改信息" onclick="location='toUpdateUser'">
</div>
<div id="d6">
    <input type="button" value="浏览官网" onclick="location='index'">
</div>

</body>
</html>
