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
    <title>showDelivery</title>
</head>
<body>
    <table border="1" cellspacing="0">
        <c:forEach items="${sessionScope.deliveries}" var="temp" varStatus="loop">
            <tr>
                <td>求职者</td>
                <td colspan="2"><a href="toShowResumeByAdmin?re_id=${temp.re_id}">${sessionScope.userNames[loop.count-1]}</a></td>
            </tr>
            <tr>
                <td>应聘职位</td>
                <td colspan="2"><c:out value="${sessionScope.rc_names[loop.count-1]}"/></td>
            </tr>
            <tr>
                <td><a href="toWriteInterviewMess?uid=${sessionScope.uids[loop.count-1]}&dvid=${temp.id}">发送面试邀请</a></td>
                <td><a href="refuseInterviewByAdmin?dvid=${temp.id}">拒绝</a></td>
            </tr>
        </c:forEach>
    </table>
<div>
    <a href="toAdminPage">返回</a>
</div>
</body>
</html>
