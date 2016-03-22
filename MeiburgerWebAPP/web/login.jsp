<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page errorPage="/WEB-INF/error.jsp"%>
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
        
        </style>
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
                    <a title="回到首頁" href="<%=application.getContextPath() %>/index.jsp">首頁</a> | 
                    <a href="<%=application.getContextPath() %>/aboutus.jsp">關於綿堡</a> | 
                    <a href="<%=application.getContextPath() %>/product.jsp">菜單</a> | 
                    <a href="<%=application.getContextPath() %>/"></a> | 
                    <a href="<%=application.getContextPath() %>/member.jsp">食客服務</a> | 
                    <a href="<%=application.getContextPath() %>/cart.jsp">餐盤</a>
                    <!--<div id ="subNavOrder" ><a href="#ingredient">特選食材</a> | <a href="#topselect">經典組合</a> | <a href="orderNow">立刻訂製</a></div>-->
                </div></div></div>
        <div id="main">
            <h1>登入</h1>
            <form method="POST" action="login.do">
                <p><label for="userid">帳號</label><input type="text" id="userid" name="id" placeholder="請輸入帳號" required/></p>            
                <p><label for="userpw">密碼 </label><input type="password" id="userpw" name="pw" placeholder="請輸入密碼" required/></p>
                <p><img id="checkcodepic" src="img/check_code.jpg" alt="檢核圖片" /><br>
                    <label for="checkCode">檢核碼</label> 
                    <input type="button" value="更新" name="updatecode" id="updatecode" onclick="refresh()"/>
                    <input type="text" id="checkCode" name="checkcode" placeholder="請輸入檢核碼" required /></p>
                <input type=submit value="確定" />
            </form>
            <div id="demo"></div>
        </div>

        <div id="footer"></div>
    </body>
</html>
