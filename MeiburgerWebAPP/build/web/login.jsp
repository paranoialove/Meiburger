<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Meiburger login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript">


            function refresh() {
                var image = document.getElementById("checkcodepic");
                image.src = "img/check_code.jpg?get=" + new Date();
            }
        </script>
        <!----------------------------- header style --------------------------------->
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <!----------------------------- BODY 主要style 開始---------------------------->
        <link href="css/main_body.css" rel="stylesheet" type="text/css"/>
        <!----------------------------- footer 主要style 開始---------------------------->
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>     
        <!---------------------- BODY 本頁特有元素 style 開始-------------------Javay-->

    </head>
    <body>

        <div id="header">            <div><img src="img/logo.jpg" title="logo" id="logo" />            </div>
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
                </div></div></div>
        <div id="main">
            <h1>登入</h1>
            <form method="POST" action="login.do">
                <p><label for="userid">帳號</label>     <input type="text" id="userid" name="id" placeholder="請輸入帳號" required 
                           value="<%= request.getParameter("id")==null?"":request.getParameter("id") %>"></p>            
                <p><label for="userpw">密碼 </label><input type="password" id="userpw" name="pw" placeholder="請輸入密碼" required/></p>
                <p><img id="checkcodepic" src="img/check_code.jpg" alt="檢核圖片" /><br>
                    <label for="checkCode">驗證碼</label> 
                    <input type="button" value="更新" name="updatecode" id="updatecode" onclick="refresh()"/>
                    <input type="text" id="checkCode" name="checkcode" placeholder="請輸入驗證碼" required /></p>
                <input type=submit value="確定" />
            </form>
            <div class="errorarea">
                <% List<String> error1 = (List<String>) request.getAttribute("errors");
                    if (error1 != null && error1.size() > 0) { %>
                <div>
                    
                        <% for (String msg : error1) {%>
                        <p><%= msg%></p>
                            <% } %>
                  
                </div>
                <%}%>
                <div><a href="register.jsp">[新註冊?]</a></div>

            </div>

            <div id="footer"></div>
    </body>
</html>
