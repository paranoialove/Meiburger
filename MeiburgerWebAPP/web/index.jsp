<%@page import="uuu.meiburger.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%@ page errorPage="/WEB-INF/error.jsp" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Meiburger orderBurger! 1.Flavers/Size</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!----------------------------- header style --------------------------------->
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <!----------------------------- BODY 主要style 開始---------------------------->
        <link href="css/main_body.css" rel="stylesheet" type="text/css"/>
        <!----------------------------- footer 主要style 開始---------------------------->
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>     

    </head>
    <body>
        <div id="header">
            <div><img src="img/logo.jpg" title="logo" id="logo" />            </div>
            <div id ="headertext">
                <div id ="websitename"><h1>綿堡MonsterBurger</h1></div>
                <div id ="loginblock">
                    <% Customer c = (Customer) session.getAttribute("user"); %>
                    <div>歡迎！
                        <% if ((session.getAttribute("user")) != null) {%>
                        <%= c.getName()%> <%}%>
                    </div>
                    <% if (c == null) { %>
                    <a href="<%=application.getContextPath()%>/login.jsp">登入</a>                            
                    <a href="<%=application.getContextPath()%>/register.jsp">註冊</a>
                    <% } else {%>
                    <a href="<%=application.getContextPath()%>/user/logout.do">登出</a>
                    <%}%>
                </div>
                <div id="nav">
                    <a title="回到首頁" href="<%=application.getContextPath()%>/index.jsp">首頁</a> | 
                    <a href="<%=application.getContextPath()%>/aboutus.jsp">關於綿堡</a> | 
                    <a href="<%=application.getContextPath()%>/product.jsp">菜單</a> | 
                    <a href="<%=application.getContextPath()%>/"></a> | 
                    <a href="<%=application.getContextPath()%>/memberCenter.jsp">食客服務</a> | 
                    <a href="<%=application.getContextPath()%>/cart.jsp">餐盤</a>
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
