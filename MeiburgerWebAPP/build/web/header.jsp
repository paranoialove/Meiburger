<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page errorPage="/WEB-INF/error.jsp"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <style type="text/css">
            #header{
                float: left;
                background-color:#ffcccc;
                text-align:center;
                width:100%;
                margin:0 auto;
                _margin:0px auto;
                *margin:0px auto;
            }
            #logo{
                text-align:center;
                margin:0 auto;
                _margin:0px auto;
                *margin:0px auto;
            }
            #loginblock{
                text-align:right;
            }
            #logo{
                width: 307px
            }
        </style>
    </head>
    <body>
        <div><img src="img/logo.jpg" title="logo" id="logo" />            </div>
        <div id ="headertext">
            <div id ="websitename"><h1>綿堡MonsterBurger</h1></div>
            <div id ="loginblock">
                <a href="login.html">登入</a>
                <a href="register.html">註冊</a>
            </div>
            <div id="nav">
                <a title="回到首頁" href="#home">首頁</a> | <a href="#aboutus">關於綿堡</a> | <a href="#order">訂製</a> | <a href="#other">其他餐點</a> | <a href="#member">食客服務</a> | <a href="#cart">餐盤</a>
                <div id ="subNavOrder" ><a href="#ingredient">特選食材</a> | <a href="#topselect">經典組合</a> | <a href="orderNow">立刻訂製</a></div>
            </div></div>
    </body>
</html>