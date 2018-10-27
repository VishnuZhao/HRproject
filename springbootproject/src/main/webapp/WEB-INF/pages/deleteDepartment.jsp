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
    <title>删除部门</title>
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
    <form action="deleteDepServlet" method="post">
        请选择删除的部门
        <select id="department" name="depName" required>
            <option>--请选择部门--</option>
            <c:forEach items="${sessionScope.departments}" var="temp">
                <option><c:out value="${temp.name}"/></option>
            </c:forEach>
        </select>
        <br/>
        <input type="submit" value="确认提交">
        <input type="reset" value="重新填写">
    </form>
    <span><c:out value="${requestScope.deleteDep}"/></span>
</div>

<div>
    <a href="toManageDep">点我返回主页</a>
</div>
</body>
</html>
