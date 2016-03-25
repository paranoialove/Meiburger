<%@page import="uuu.meiburger.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%@ page errorPage="/WEB-INF/error.jsp" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Meiburger orderBurger! Cart</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!----------------------------- header style --------------------------------->
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <!----------------------------- BODY 主要style 開始---------------------------->
        <link href="css/main_body.css" rel="stylesheet" type="text/css"/>
        <!----------------------------- footer 主要style 開始 ----------------------------->
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>     
        <!----------------------------- inport jQuery ----------------------------->
        <script src="js/jquery.js" type="text/javascript"></script>

        <!-------------------------inport  jquery UI ----------------------------->
        <script src="js/jquery-ui-1.11.4/external/jquery/jquery.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.11.4/jquery-ui.js" type="text/javascript"></script>
        <link href="js/jquery-ui-1.11.4/jquery-ui.css" rel="stylesheet" type="text/css"/>

        <!-----------------------------  登出ajax ----------------------------->
        <script type="text/javascript">
            function logout() {
                $.ajax({
                    method: "POST",
                    url: "<%=application.getContextPath()%>/user/logout.do"
                }).done(doneHandler);
            }


            function doneHandler(msg) {
                alert(msg);
                $("#userSpan").html('<a href="<%=application.getContextPath()%>/login.jsp">登入</a> ' +
                        '<a href="<%=application.getContextPath()%>/register.jsp">註冊</a>');
//                $("#user_data").text('');
            }
        </script>


    </head>
    <body>
        <div id="header">
            <div id="logo_area"><img id="logo" src="img/logo.jpg" alt=""/></div>
            <div id ="headertext">
                <div id ="websitename">綿堡MonsterBurger</div>
                <div id ="loginblock">
                    <% Customer c = (Customer) session.getAttribute("user"); %>
                    <div>歡迎！
                        <% if ((session.getAttribute("user")) != null) {%>
                        <%= c.getName()%> <%}%>
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
        </div>
        <hr>
        <div id="main">
            <div id="sidebar">
                <div id="sidebarTitle"><h2>側邊欄</h2></div>
                <ul id="sidebarlist">
                    <li>選擇</li>
                    <li>選則</li>
                    <li>選擇</li>
                    <li>選擇</li>
                </ul>

                <script>
                    $("#sidebarlist").menu();
                </script>
            </div>
            <div id="content">
                <div id ="article"><h2>餐盤</h2></div>
                <div id="contentText">內容內容</div>
            </div>

        </div>
        <div id="footer"><%@include  file="/WEB-INF/footer.jsp" %>      </div>
    </body>
</html>
