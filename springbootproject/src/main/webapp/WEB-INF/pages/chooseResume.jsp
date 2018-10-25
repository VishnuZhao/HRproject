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

    <table border="1" cellspacing="0">
        <tr>
            <th>简历编号</th>
            <th>简历名称</th>
            <th>选择投递</th>
        </tr>
        <c:forEach items="${sessionScope.resumes}" var="temp">
            <tr>
                <td><c:out value="${temp.id}"/></td>
                <td><c:out value="${temp.rename}"/></td>
                <td><a href="sendRecruit?re_id=${temp.id}">选中投递</a></td>
            </tr>
        </c:forEach>
    </table>
<div>
    <a href="toHomePage">点我返回主页</a>
</div>
</body>
</html>
