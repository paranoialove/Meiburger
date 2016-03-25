<%@page import="uuu.meiburger.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%@ page errorPage="/WEB-INF/error.jsp" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Meiburger orderBurger! HOME</title>
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
                $("#user_data").text('');
            }
        </script>
    </head>


    <body>
        <div id="header">
            <jsp:include  page="WEB-INF/header.jsp" >
                <jsp:param name="subtitle" value="Home" /> 
            </jsp:include>
        </div>



        <div id="main">
            <div id="sidebar">
                <div id="sidebarTitle"><h2>側邊欄</h2></div>
                <ul id="sidebarlist" >
                    <li>選擇</li>
                    <li>選擇</li>
                    <li>選擇</li>
                    <li>選擇</li>
                </ul>

                <script>
                    $("#sidebarlist").menu();
                </script>
            </div>
            <div id="content">
                <div id ="article"><h2>標題</h2></div>
                <div id="contentText">內容內容</div>
            </div>

        </div>
        <div id="footer"><%@include  file="/WEB-INF/footer.jsp" %>      </div>
    </body>
</html>
