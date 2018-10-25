<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/5 0005
  Time: 23:19
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
    <title>register</title>
    <style>
        #by{
            background-color: lightpink;
        }
        .c2{
            position: absolute;
            top: 200px;
            left: 500px;
            border: solid;
            border-width: 2px;
            border-color: deeppink;
            width: 600px;
            height: 200px;
        }
        .c1{
            width: 200px;
            height: 20px;
        }

    </style>
    <script src="resource/js/jquery-3.2.1.js"></script>
    <script>
        var trim1 =/^[\u4E00-\u9FA5A-Za-z]+$/;
        var trim2=/^[A-Za-z0-9]{3,20}$/;

       $(function () {
           $("input[name='name']").blur(function () {
               var username=$("input[name='name']").val();
               if(!username.match(trim1)){
                   $("#sp1").html("<span>用户名不合法!</span>");
               }else{
                   $("#sp1").html("<span>用户名合法~</span>");
                   checkname();
               }
           })
           $("input[name='pass']")  .blur(function () {
               var pass=$("input[name='pass']").val();
               if(!pass.match(trim2)){
                   $("#sp5").html("<span>密码不合法!请输入3-20位字母或数字</span>");
               }else{
                   $("#sp5").html("<span>密码合法~</span>");
               }
           })
           $("input[name='pass1']")  .blur(function () {
               var pass1=$("input[name='pass1']").val();
               var pass=$("input[name='pass']").val();
               if(pass==pass1){
                   $("#sp3").html("<span>两次密码相同</span>");
               }else{
                   $("#sp3").html("<span>两次输入密码不相同！</span>");
               }
           })
           $("#bt1").click(function () {
               var username=$("input[name='name']").val();
               var pass=$("input[name='pass']").val();
               var pass1=$("input[name='pass1']").val();
               if(username.match(trim1)&&pass.match(trim2)&&pass==pass1){
                   $("form[name='f1']").submit();
                   $("#sp2").html("<span>提交成功</span>")
               }else{
                   $("#sp2").html("<span>信息有误，请重新填写</span>")
               }
           })
           function checkname() {
               $.ajax({type:"get",
                   url:"checkNameServlet",
                   date:{username:$("input[name='name']").val()},
                   success:function (obj) {
                       $("#sp1").text(obj);
                   }})
           }
       })
    </script>
</head>
<body id="by">
<div class="c2">
    <form name="f1" action="addUserServlet" method="post">
        用户名：<input name="name" class="c1" required="required"><span id="sp1"></span><br/>
        密&nbsp;&nbsp;&nbsp;码：<input name="pass" type="password" class="c1" required="required"><span id="sp5"></span><br/>
        确认密码：<input name="pass1" type="password" class="c1" required/><span id="sp3"></span><br>
        <input type="button" id="bt1" value="确认注册">&nbsp;
        <input type="reset" value="重新输入"><br/>
        <span id="sp2"></span>
    </form>
    <div>

        <span><c:out value="${requestScope.msg}"></c:out></span>

    </div>
</div>
<div>
    <a href="index">点我返回欢迎页</a>
</div>
</body>
</html>
