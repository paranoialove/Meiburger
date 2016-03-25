<%@page import="uuu.meiburger.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

    <div id="logo_area"><img id="logo" src="img/logo.jpg" alt=""/></div>
    <div id ="headertext">
        <div id ="websitename">綿堡MonsterBurger | <%=request.getParameter("subtitle")!=null?request.getParameter("subtitle"):"HOME" %></div>
        <div id ="loginblock">
            <% Customer c = (Customer) session.getAttribute("user"); %>
            <div>歡迎！
                <% if ((session.getAttribute("user")) != null) {%><span id="user_data">
                    <%= c.getName()%></span> <%}%>
            </div>
            <span id = userSpan>
                <% if (c == null) {%>
                <a href="<%=application.getContextPath()%>/login.jsp">登入</a>                            
                <a href="<%=application.getContextPath()%>/register.jsp">註冊</a>
                <% } else {%>
                <!--<a href="<%=application.getContextPath()%>/us //er/logout.do">登出</a>-->
                <a href="javascript:logout()">登出</a>
                <%}%>
            </span>
        </div>
        <div id="nav_area">
            <ul id="nav">                    
                <a title="回到首頁" href="<%=application.getContextPath()%>/index.jsp">首頁</a> | 
                <a href="<%=application.getContextPath()%>/aboutus.jsp">關於綿堡</a> | 
                <a href="<%=application.getContextPath()%>/product.jsp">菜單</a> | 
                <a href="<%=application.getContextPath()%>/"></a> | 
                <a href="<%=application.getContextPath()%>/memberCenter.jsp">食客服務</a> | 
                <a href="<%=application.getContextPath()%>/cart.jsp">餐盤</a>
                <!--<div id ="subNavOrder" ><a href="#ingredient">特選食材</a> | <a href="#topselect">經典組合</a> | <a href="orderNow">立刻訂製</a></div>-->
            </ul></div>
    </div>