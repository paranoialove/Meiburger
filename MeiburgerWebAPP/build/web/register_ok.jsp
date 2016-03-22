<%-- 
    Document   : register_ok
    Created on : 2016/3/22, 下午 04:04:14
    Author     : Administrator
--%>

<%@page import="uuu.meiburger.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8" info="註冊成功"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!----------------------------- header style --------------------------------->
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <!----------------------------- BODY 主要style 開始---------------------------->
        <link href="css/main_body.css" rel="stylesheet" type="text/css"/>
        <!----------------------------- footer 主要style 開始---------------------------->
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>     
        <title>註冊成功</title>
        <% Customer c = (Customer) request.getAttribute("customer");%>
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
                    <a title="回到首頁" href="<%=application.getContextPath()%>/index.jsp">首頁</a> | 
                    <a href="<%=application.getContextPath()%>/aboutus.jsp">關於綿堡</a> | 
                    <a href="<%=application.getContextPath()%>/product.jsp">菜單</a> | 
                    <a href="<%=application.getContextPath()%>/"></a> | 
                    <a href="<%=application.getContextPath()%>/member.jsp">食客服務</a> | 
                    <a href="<%=application.getContextPath()%>/cart.jsp">餐盤</a>
                    <!--<div id ="subNavOrder" ><a href="#ingredient">特選食材</a> | <a href="#topselect">經典組合</a> | <a href="orderNow">立刻訂製</a></div>-->
                </div></div>
        </div>

<div id="main">
        <h1>註冊成功</h1>
        <div><%= application.getInitParameter("app-name")%></div>
        <div><%= c == null ? "" : c%></div>
</div>
<div id="footer"></div>
    </body>
</html>
