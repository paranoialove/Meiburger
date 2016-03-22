<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page errorPage="/WEB-INF/error.jsp"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Meiburger orderBurger! 1.Flavers/Size</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!----------------------------- header style 開始--------------------------------->
        <style type="text/css">
            #header{
                float: left;
                background-color:#ffcccc;
                text-align:center;
                width:95%;
                margin:0 auto;
                _margin:0px auto;
                *margin:0px auto;
                padding:0 0 0 5%;
                height:200px;
                max-height:260px;
                min-height:280px;
                
            }
            #headertext{
                margin-top: -100px;
                inline-box-align:initial;
            }
            #logo{
                width:17%;
                min-width:300px;
                max-width:500px;
                float: left;
                text-align:center;
                margin:0 auto;
                _margin:0px auto;
                *margin:0px auto;
                margin-left:10px;
                padding:0;
            }


            #nav{
                float: top ;
                text-align:left;
                
            }
            #websitename{
                float:top;
                
                margin-top:15em; 
                text-align:left;
            }
            #loginblock{
                float: right;
                text-align:right;
                margin-left: 20px;
            }

        </style>
        <!----------------------------- header style 結束--------------------------------->
        <!----------------------------- BODY 主要style 開始---------------------------->
        <style type="text/css">
            #main {
                width: 100%;
                display:inline-block;
                margin:0 auto;
                text-align:center;
                padding-bottom: 100px;
            }
            #sidebar{
                float:left;
                width:20%;
                height:80%;
                margin:0px 0px;
                text-align: center;
            }
            #sidebar ul{
                padding-left: 0px;
                list-style-type:none;
            }
            #content{

                float:right;
                margin: 0px 0px;
                width:70%;
                height: 80%;
            }
            #content h2{
                background: brown;
                opacity: 0.8;
            }
        </style>
        <!------------------------BODY 主要style 結束--------------------------------->

        <!----------------------------- footer 主要style 開始---------------------------->
        <style type="text/css">
            #footer{
                background:url("#") repeat-x;
                background-color:#cccccc;
                display:block;font-size:80%;
                line-height:140%;margin-top:-10px;
                position:relative;
                text-align:center;
                width:100%;
                min-height:100px;
                padding-top:3%;
            }
        </style>
        <!----------------------------- footer 主要style 結束-------------------------->

    </head>
    <body>
        <div id="header">
            <div><img src="img/logo.jpg" title="logo" id="logo" />            </div>
            <div id ="headertext">
                <div id ="websitename"><h1>綿堡MonsterBurger</h1></div>
                <div id ="loginblock">
                    <a href="login.jsp">登入</a>
                    <a href="register.jsp">註冊</a>
                </div>
                <div id="nav">
                    <a title="回到首頁" href="<%=application.getContextPath() %>/index.jsp">首頁</a> | 
                    <a href="<%=application.getContextPath() %>/aboutus.jsp">關於綿堡</a> | 
                    <a href="<%=application.getContextPath() %>/product.jsp">菜單</a> | 
                    <a href="<%=application.getContextPath() %>/"></a> | 
                    <a href="<%=application.getContextPath() %>/member.jsp">食客服務</a> | 
                    <a href="<%=application.getContextPath() %>/cart.jsp">餐盤</a>
                    <!--<div id ="subNavOrder" ><a href="#ingredient">特選食材</a> | <a href="#topselect">經典組合</a> | <a href="orderNow">立刻訂製</a></div>-->
                </div></div>
        </div>
        <hr>
        <div id="main">
            <div id="sidebar">
                <div id="sidebarTitle"><h2>側邊欄</h2></div>
                <ul id="sidebarlist">
                    <li><img src="#" title="側邊欄" alt="側邊欄" /></li>
                    <li><img src="#" title="側邊欄" alt="側邊欄" /></li>
                    <li><img src="#" title="側邊欄" alt="側邊欄" /></li>
                    <li><img src="#" title="側邊欄" alt="側邊欄" /></li>
                </ul>
            </div>
            <div id="content">
                <div id ="article"><h2>標題</h2></div>
                <div id="contentText">內容內容</div>
            </div>

        </div>
        <div id="footer">
            <p>Made by MeiMei Wu © 2016</p>
            <a href="test/map.html"><address>台北市復興北路1號</address><img src="#" alt="地圖" /></a>
        </div>
    </body>
</html>
