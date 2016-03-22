<%-- 
    Document   : login_ok
    Created on : 2016/3/22, 下午 12:22:38
    Author     : Administrator
--%>

<%@page import="uuu.meiburger.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MeiBurger 已登入</title>
    </head>
    <body>
        

        <div id="main">
            <div id="sidebar">
                <div id="sidebartitle"><h2>食客服務</h2></div>
                <ul>
                    <li><img src="#" title="側邊欄" alt="側邊欄" /></li>
                    <li><img src="#" title="側邊欄" alt="側邊欄" /></li>
                    <li><img src="#" title="側邊欄" alt="側邊欄" /></li>
                    <li><img src="#" title="側邊欄" alt="側邊欄" /></li>
                </ul>
            </div>
            <div id="content">                
                <% Customer c = (Customer)request.getAttribute("user") ; %>
                <h2>登入成功！<%= c.getName() %>   </h2>
                <div>目前線上人數：<%= application.getAttribute("app.login.cunt") %></div>
                
                
            </div>
        </div>
    </body>
</html>
