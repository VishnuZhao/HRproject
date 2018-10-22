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
    <title>showDetails</title>
</head>
<body>

<form action="deleteUdid" method="post">
    <table border="1" cellspacing="0">
        <tr>
            <th>简历编号</th>
            <th>简历名称</th>
            <th>查看详情</th>
            <th>修改简历</th>
            <th>删除简历</th>
        </tr>
        <c:forEach items="${sessionScope.resumeNames}" var="temp" varStatus="loop">
            <tr>
                <td><c:out value="${sessionScope.resumeIds[loop.count-1]}"></c:out></td>
                <td><c:out value="${temp}"></c:out></td>
                <td><a href="toShowResume?re_id=${sessionScope.resumeIds[loop.count-1]}">确认查看</a></td>
                <td><a href="toUpdateResume?re_id=${sessionScope.resumeIds[loop.count-1]}">确认修改</a></td>
                <td><a href="deleteResume?re_id=${sessionScope.resumeIds[loop.count-1]}">确认删除</a></td>
            </tr>
        </c:forEach>
    </table>
</form>

<div>
    <a href="toHomePage">点我返回主页</a>
</div>
</body>
</html>
