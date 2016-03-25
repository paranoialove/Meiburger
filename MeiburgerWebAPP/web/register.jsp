<%@page import="uuu.meiburger.domain.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page errorPage="/WEB-INF/error.jsp"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Meiburger register</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript">
            function refresh() {
                var image = document.getElementById("checkcodepic");
                image.src = "img/reg_check_code.jpg?get=" + new Date();
            }
        </script>
        <!----------------------------- header style --------------------------------->
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <!----------------------------- BODY 主要style 開始---------------------------->
        <link href="css/main_body.css" rel="stylesheet" type="text/css"/>
        <!----------------------------- footer 主要style 開始---------------------------->
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>     
        <!---------------------- BODY 本頁特有元素 style 開始-------------------Javay-->
        <style type="text/css"> 
            #content form{
                float: left;
            }
        </style>
        <!--------------------- BODY 本頁特有元素 style 結束-------------------Javay-->
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

        <div id="main">
            <div id="sidebar">
            </div>
            <div id="content">                
                <h2>註冊</h2>
                <div>
                    <% List<String> error = (List<String>) request.getAttribute("errors");
                        if (error != null && error.size() > 0) { %>
                    <div>
                        
                            <% for (String msg : error) {%>
                            <p><%= msg%></p>
                                <% } %>
                        
                    </div>
                    <%}%>

                </div>
                <form method="POST" action="register.do">
                    <p><label for="userid">帳號</label>
                        <input type="text" id="userid" name="id" placeholder="請輸入帳號" required
                               /></p>
                    <p><label for="username">姓名</label>
                        <input type="text" id="username" name="username" placeholder="請輸入姓名" required 
                              /></p>          
                    <p><label for="email">email</label>
                        <input type="text" id="email" name="email" placeholder="請輸入email" required
                               /></p>
                    <p><label>性別</label>
                        <input type="radio" id="male" name="gender" value="M" /><label for="male" >男</label>
                        <input type="radio" id="female" name="gender" value="F" /><label for="female">女</label>
                    </p>
                    <p><label for="userpw">密碼 </label><input type="password" id="userpw" name="pw" placeholder="請輸入密碼" minlength="6" maxlength="20"  required/></p>
                    <p><label for="userpwck">　　 </label><input type="password" id="userpwck" name="pwck" placeholder="請再次輸入密碼" required/></p>
                    <label for="checkCode">檢核碼</label> 
                    <p><img id="checkcodepic" src="img/check_code.jpg" alt="檢核圖片" /><br>
                        <input type="button" value="更新" name="updatecode" id="updatecode" onclick="refresh()"/>
                        <input type="text" id="checkCode" name="checkcode" placeholder="請輸入檢核碼" required /></p>
                    <input type=submit value="確定" />            
                </form>
            </div>
        </div>

         <div id="footer">
            <p style="font-size:0.5em">Made by MeiMei Wu © 2016 <span style="font-size:0.5em; font-style:italic">台北市復興北路1號</span></p>
                <a href="test/map.html"><img src="#" alt="地圖" /></a>
                
        </div>
    </body>
</html>
