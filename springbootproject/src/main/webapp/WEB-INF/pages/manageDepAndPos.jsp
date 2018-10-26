
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

<div id="d2">
    <input type="button" value="添加部门" onclick="location='toAddDepartment'">
</div>

<div id="d3">
    <input type="button" value="删除部门" onclick="location='toDeleteDepartment'">
</div>

<div id="d4">
    <input type="button" value="添加职位" onclick="location='toAddPosition'">
</div>

<div id="d5">
    <input type="button" value="删除职位" onclick="location='toDeletePosition'">
</div>

<div id="d6">
    <input type="button" value="员工职位调动" onclick="location=''">
</div>

<div id="d7">
    <input type="button" value="员工离职" onclick="location=''">
</div>
</body>
</html>
