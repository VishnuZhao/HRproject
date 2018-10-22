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
    <title>添加地址</title>
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
    <%--<script>
        var trim1 =/^[\u4E00-\u9FA5A-Za-z]+$/;
        var trim2=/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
        var trim3=/^[\u4E00-\u9FA5A-Za-z0-9_]+$/;
        //检查用户名
        function checkUser() {
            var receiver = document.getElementById("p1").value;
            if(receiver==null || receiver==""){
                alert("用户名不能为空");
                return;
            }
            if(!receiver.match(trim1)){
                alert("收件人格式不合法，请重新输入");
            }
        }

        function checkPhone() {
            var phone = document.getElementById("p2").value;
            if(phone==null || phone==""){
                alert("手机号不能为空");
                return;
            }
            if(!phone.match(trim2)){
                alert("手机号输入不合法，请重新输入");
            }
        }
        function checkAdress() {
            var adress = document.getElementById("p3").value;
            if(adress==null || adress==""){
                alert("收货地址不能为空");
                return;
            }
            if(!adress.match(trim3)){
                alert("地址输入不合法，请重新输入");
            }
        }
    </script>--%>
</head>
<body id="by">
<div id="d1">
    <form action="addResumeServlet" method="post">
        <table>
            <tr>
                <td colspan="2">简历名称</td>
                <td colspan="2"><input name="rename" required></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input name="name" required></td>
                <td>性别</td>
                <td><input type="radio" name="sex" value="男" required>男
                    <input type="radio" name="sex" value="女" required>女</td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="number" name="age" min="1" required></td>
                <td>手机号</td>
                <td><input type="number" name="phone" min="11111111111" required></td>
            </tr>
            <tr>
                <td>学历</td >
                <td><select name="education">
                    <option>高中及以下</option>
                    <option>专科</option>
                    <option>全日制本科</option>
                    <option>研究生及以上</option>
                </select></td>
            </tr>
            <tr>
                <td>毕业院校</td>
                <td><input name="school" required></td>
                <td>专业</td>
                <td><input name="major" required></td>
            </tr>
            <tr>
                <td>工作年限</td>
                <td><input type="number" name="workyear" required></td>
            </tr>
            <tr>
                <td>自我介绍</td>
                <td><textarea name="introduction" rows="5" required></textarea> </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="确认提交"></td>
                <td colspan="2"><input type="reset" value="重新填写"></td>
            </tr>
        </table>
        <input name="uid" hidden value="${sessionScope.user.u_id}">
    </form>
    <span><c:out value="${requestScope.mess}"></c:out></span>

</div>
<div>
    <a href="toHomePage">点我返回主页</a>
</div>
</body>
</html>
