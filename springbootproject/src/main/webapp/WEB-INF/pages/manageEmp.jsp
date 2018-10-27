
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>manageDepAndPos</title>
    <style>
        #by{
            background-color: lightpink;
        }
    </style>
</head>
<body id="by">
<div id="d1"><span>用户名：${sessionScope.name}-欢迎回到个人中心！</span><br/></div>

<div id="d3">
    <input type="button" value="试用转正" onclick="location='toCorrection'">
</div>

<div id="d6">
    <input type="button" value="查看（调动）在职人员" onclick="location='toChangePosition'">
</div>

<div id="d7">
    <input type="button" value="员工离职" onclick="location='toDeleteEmp'">
</div>


<div id="d8">
    <a href="toAdminPage">返回</a>
</div>
</body>
</html>
