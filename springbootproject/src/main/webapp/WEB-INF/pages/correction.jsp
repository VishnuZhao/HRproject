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
    <title>转正</title>
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
    <script src="js/jquery-3.2.1.js"></script>
    <script>
        $(function () {
            $("#department").change(function () {
                var name=$("#department").val();
                $.ajax({
                    type:"get",
                    url:"getPositionByDepName?name="+name,
                    success:function (obj) {
                        $("#position").empty();
                        var tx="<option>"+"请选择"+"</option>";
                        $("#position").append(tx);
                        for (var i=0;i<obj.length;i++){
                            var posName="<option>"+obj[i].name+"</option>";
                            $("#position").append(posName);
                        }
                    }
                })
            })
            $("#position").change(function () {
                var posName=$("#position").val();
                var name=$("#department").val();
                $.ajax({
                    type:"get",
                    url:"getEmpByPosNameCorr?name="+name+"&posName="+posName,
                    success:function (obj) {
                        $("#employee").empty();
                        var tx="<option>"+"请选择"+"</option>";
                        $("#employee").append(tx);
                        for (var i=0;i<obj.length;i++){
                            var empName="<option>"+obj[i].uname+":"+obj[i].name+"</option>";
                            $("#employee").append(empName);
                        }
                    }
                })
            })
        })
    </script>
</head>
<body id="by">
<div id="d1">
    <form action="correctEmp" method="post">
        请选择部门
        <select id="department" name="depName" required>
            <option>--请选择部门--</option>
            <c:forEach items="${sessionScope.departments}" var="temp">
                <option><c:out value="${temp.name}"/></option>
            </c:forEach>
        </select>
        <br/>
        请选择职位
        <select id="position" name="posName" required>
            <option>--请选择职位--</option>
        </select>
        <br/>
        待转正员工
        <select id="employee" name="empInf" required>
            <option>--请选择员工(冒号后为员工账号)--</option>
        </select>
        <br/>
        <span>${requestScope.correctEmp}</span>
        <br/>
        <input type="submit" value="点击转正">
    </form>
</div>

<div>
    <a href="toManageEmp">返回</a>
</div>
</body>
</html>
