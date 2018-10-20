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

</head>
<body>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <style>
        .h_top, .h_conter, .h_bottom, .footer, .banner, .map {
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
        .h_top .h_top_r .h_top_icon {
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
        .h_top .h_top_r li .h_top_app {
            background: url(http://iotekcdn.b0.upaiyun.com/php/index/img/icon_i.png) no-repeat -22px -3px;
        }
        .h_top .h_top_r li .h_top_i {
            background: url(http://iotekcdn.b0.upaiyun.com/php/index/img/icon_i.png) no-repeat -97px -3px;
        }
        .h_top .h_top_r li .h_top_q {
            background: url(http://iotekcdn.b0.upaiyun.com/php/index/img/icon_i.png) no-repeat -173px -2px;
        }
        .h_top .h_top_r li .h_top_w {
            background: url(http://iotekcdn.b0.upaiyun.com/php/index/img/icon_i.png) no-repeat -246px -2px;
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
<body><div class="h_top">
    <div class="layout">
        <ul class="h_top_l">
            <li>海同科技，欢迎你！</li>
            <li>
                <a href="">IT知识库</a>
                <p>
                    <a href="http://knowledge.zhizuobiao.com" target="_blank">知识首页</a>
                    <a href="http://program.zhizuobiao.com" target="_blank">编程语言</a>
                    <a href="http://web.zhizuobiao.com" target="_blank">WEB前端</a>
                    <a href="http://shouji.zhizuobiao.com" target="_blank">移动开发</a>
                    <a href="http://design.zhizuobiao.com" target="_blank">设计创作</a>
                    <a href="http://data.zhizuobiao.com" target="_blank">数据库</a>
                    <a href="http://test.zhizuobiao.com" target="_blank">软件测试</a>
                    <a href="http://operation.zhizuobiao.com" target="_blank">系统运维</a>
                    <a href="http://software.zhizuobiao.com" target="_blank">常用软件</a>
                </p>
            </li>
            <li>
                <a href="">IT技能培训</a>
                <p>
                    <a href="http://www.zhizuobiao.com/course/plan" target="_blank">IT岗位培训</a>
                    <a href="http://ban.zhizuobiao.com" target="_blank">就业培训班</a>
                    <a href="http://openclass.zhizuobiao.com" target="_blank">免费公开课</a>
                    <a href="http://course.zhizuobiao.com" target="_blank">IT课程库</a>
                </p>
            </li>
            <li>
                <a href="">IT直通车</a>
                <p>
                    <a href="http://about.zhizuobiao.com/gaoxiao/" target="_blank">高校直通车</a>
                    <a href="http://about.zhizuobiao.com/qiye/" target="_blank">企业直通车</a>
                    <a href="http://about.zhizuobiao.com/zhaopin/" target="_blank">求职直通车</a>
                    <a href="http://university.zhizuobiao.com" target="_blank">项目直通车</a>
                </p>
            </li>
        </ul>
        <ul class="h_top_r">
            <li class="header_login">
                <a href="http://pass.zhizuobiao.com/register/" target="_blank">注册</a>
                <a href="http://pass.zhizuobiao.com/" target="_blank">登录</a>
            </li>
            <li>
                高校登录
            </li>
            <li>
               网站导航
            </li>
        </ul>
    </div>
</div></body>
</html>

</body>
</html>
