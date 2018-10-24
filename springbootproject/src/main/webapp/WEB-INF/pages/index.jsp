<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/19 0019
  Time: 16:26
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
    <title>index</title>
    <style>
        .h_top {
            width: 100%;
            min-width: 1200px;
            font-family: "微软雅黑";
            font-size: 12px;
        }
        .h_top {
            height: 30px;
            line-height: 30px;
            background: #f2f2f2;
            float: left;
        }
        html, body, ul, li, ol, dl, dd, dt, table, tbody, thead, tr, td, p, h1, h2, h3, h4, h5, h6, form, img, button, select, option, textarea {
            margin: 0;
            padding: 0;
        }
        body, html {
            background: #f2f2f2;
        }
        .layout, .main {
            width: 1200px;
            margin: 0 auto;
            height: 100%;
        }
        ul, li, dt, dd {
            list-style: none;
        }
        .h_top .h_top_l {
            float: left;
        }
        .h_top .h_top_r {
            float: right;
        }
        .h_top .h_top_r li {
            padding: 0 13px 0 10px;
            display: inline-block;
            color: #7c7c7c;
            overflow: hidden;
            background: url(http://iotekcdn.b0.upaiyun.com/php/index/img/icon_s.png) no-repeat right 8px;
        }
        .h_top .h_top_r {
            background: none;
            padding-right: 0px;
            overflow: visible;
        }
        a {
            text-decoration: none;
        }
        .h_top .h_top_r li a {
            color: #7c7c7c;
            padding: 7px 0;
        }
        .h_top .h_top_r .h_top_icon a {
            padding: 15px 15px;
            float: left;
            position: relative;
        }

        .h_top .h_top_r .h_top_icon a span {
            position: absolute;
            right: 0px;
            top: 30px;
            width: 88px;
            z-index: 5;
            height: 105px;
            background: #fff;
            border: 1px #000 solid;
            display: none;
        }
        img {
            border: none;
            vertical-align: center;
        }
        .h_top .h_top_r .h_top_icon a span img {
            width: 100%;
            overflow: hidden;
            line-height: 0;
            font-size: 0px;
        }
        .h_top .h_top_r .h_top_icon a span em {
            display: block;
            text-align: center;
            font-style: normal;
            position: absolute;
            top: 80px;
            left: 8px;
        }
        .h_top .h_top_r li:first-child a {
            color: #e10030;
        }
        .h_top .h_top_r li:nth-child(1) a {
            color: #e10030;
        }
        .h_top .h_top_r li:first-child a + a {
            color: #7c7c7c;
        }
        .h_top .h_top_r li:nth-child(1) a + a {
            color: #7c7c7c;
        }
        .h_top .h_top_l li {
            color: #7c7c7c;
            padding-right: 12px;
            float: left;
        }
        .h_top .h_top_l li + li {
            padding-left: 20px;
            position: relative;
            background: url(http://iotekcdn.b0.upaiyun.com/php/index/img/icon_01.png) no-repeat right 11px;
        }
        .h_top .h_top_l li a {
            color: #7c7c7c;
        }
        .h_top .h_top_l li p {
            position: absolute;
            left: 0px;
            top: 30px;
            display: none;
            width: 240px;
            background: #fff;
            border: 1px #eee solid;
            z-index: 4;
        }
        .h_top .h_top_l li + li + li p {
            width: 160px;
        }
        .h_top .h_top_l li p a {
            display: block;
            float: left;
            width: 65px;
            height: 30px;
            line-height: 30px;
            text-align: left;
            padding-left: 15px;
        }
    </style>
</head>
<body>
<div class="h_top">
    <div class="layout">
        <ul class="h_top_l">
            <li>海同科技，欢迎你！</li>
            <li>
                <a href="">IT知识库</a>
            </li>
            <li>
                <a href="">IT技能培训</a>
            </li>
            <li>
                <a href="">IT直通车</a>
            </li>
        </ul>
        <ul class="h_top_r">
            <li class="header_login">
                <a href="toHomePage">${sessionScope.msg}</a>
                <a href="toRegister" id="a1">注册</a>
                <a href="index" id="a2" hidden>${sessionScope.name}</a>
                <a href="toLogin">登录</a>
            </li>
            <li>
                高校登录
            </li>
            <li>
               网站导航
            </li>
        </ul>
    </div>
</div>
<div>
    <c:forEach items="${sessionScope.recruits}" var="temp">
        <c:out value="${temp.name}"/>
    </c:forEach>
</div>
</body>
</html>
