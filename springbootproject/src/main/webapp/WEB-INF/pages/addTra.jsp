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
    <title>添加培训</title>
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
    <form action="addTraServlet" method="post">
        <table>
            <tr>
                <td>输入主题：</td>
                <td colspan="3"><input name="name" required></td>
            </tr>
            <tr>
                <td rowspan="2">输入内容：</td>
                <td rowspan="2" colspan="3"><input name="text" required></td>
            </tr>
            <tr>
                <td>输入地点：</td>
                <td colspan="3"><input name="address" required></td>
            </tr>
            <tr>
                <td>开始日期：</td>
                <td colspan="3"><input name="startDate" required type="date"></td>
            </tr>
            <tr>
                <td>结束日期：</td>
                <td colspan="3"><input name="endDate" required type="date"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
                <td colspan="2"><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
    <span><c:out value="${requestScope.addTra}"></c:out></span>

</div>
<div>
    <a href="toManageTra">返回</a>
</div>
</body>
</html>
