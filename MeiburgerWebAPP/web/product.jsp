<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page errorPage="/WEB-INF/error.jsp"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Meiburger product</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!----------------------------- header style 開始--------------------------------->
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
        <!---------------------- BODY 本頁特有元素 style 開始--------------------->
        <style type="text/css">
            .plist{
                display:inline-block;
                padding:25px;
                width:100px;
                height:150px ;
                border:2px solid black;
                margin: 10px;
                box-shadow: 5px 5px 3px  #222;
            }

        </style>
        <!--------------------- BODY 本頁特有元素 style 結束--------------------->
        <!----------------------------- footer 主要style 開始---------------------------->
        <style type="text/css">
            #footer {
                height: 100px;
                position: relative;
                margin-top: -100px;
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
                    <a href="login.html">登入</a>
                    <a href="register.html">註冊</a>
                </div>
                <div id="nav">
                    <a title="回到首頁" href="#home">首頁</a> | <a href="#aboutus">關於綿堡</a> | <a href="#order">訂製</a> | <a href="#other">其他餐點</a> | <a href="#member">食客服務</a> | <a href="#cart">餐盤</a>
                    <div id ="subNavOrder" ><a href="#ingredient">特選食材</a> | <a href="#topselect">經典組合</a> | <a href="orderNow">立刻訂製</a></div>
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

                <div id="selectItemListTitle"><h2>已點項目</h2></div>
                <ul id="selectitemlist">
                    <li><span> 商品名稱</span> | <span>數量</span> | <span>價格</span></li>
                    <li><span> 商品名稱</span> | <span>數量</span> | <span>價格</span></li>
                    <li><span> 商品名稱</span> | <span>數量</span> | <span>價格</span></li>
                    <li><span> 商品名稱</span> | <span>數量</span> | <span>價格</span></li>
                </ul>
            </div>
            <div id="content">
                <div id ="article"><h2>飲品&點心</h2></div>
                <div id ="productlist">
                    <ul>
                        <li class="plist">
                            <img src="#" />
                            <h4>產品1</h4>
                            <p>價格:1221元</p>
                        </li>
                        <li class="plist">
                            <img src="#" />
                            <h4>產品2</h4>
                            <p>價格:123131</p>
                        </li>
                        <li class="plist">
                            <img src="#" />
                            <h4>產品3</h4>
                            <p>價格:132131</p>
                        </li>
                        <li class="plist">
                            <img src="#"/>
                            <h4>產品4</h4>
                            <p>價格</p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="footer"><hr>
            Made by MeiMei Wu © 2016
            <a href="test/map.html"><address>台北市復興北路1號</address></a>
        </div>
    </body>
</html>