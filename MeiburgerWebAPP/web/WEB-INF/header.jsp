<%@page import="uuu.meiburger.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%@ page errorPage="/WEB-INF/error.jsp" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Meiburger orderBurger! <%=request.getParameter("subtitle") != null ? request.getParameter("subtitle") : ""%></title>
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


        <script type="text/javascript">
            //<!-----------------------------  登出ajax ----------------------------->
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
            <div id="logo_area"><img id="logo" src="img/logo2.jpg" alt=""/></div>
            <div id ="headertext">

                <div id ="loginblock">
                    <% Customer c = (Customer) session.getAttribute("user"); %>
                    <div>歡迎！
                        <% if ((session.getAttribute("user")) != null) {%>
                        <div id="user_data"><%= c.getName()%></div> <%}%>
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
                    <div id ="websitename">系帛系帛 の バーガー  </div>
                    <ul id="nav">
                        <li><a title="回到首頁" href="<%=application.getContextPath()%>/index.jsp">首頁</a> </li>
                        <li><a href="<%=application.getContextPath()%>/aboutus.jsp">關於綿堡</a></li>
                        <li><a href="<%=application.getContextPath()%>/product.jsp">菜單</a>
                            <ul id="">
                                <li><a href="<%=application.getContextPath()%>/#ingredient">特選食材</a></li>
                                <li><a href="<%=application.getContextPath()%>/#topselect">經典組合</a></li>
                                <li><a href="<%=application.getContextPath()%>/#orderNow">立刻訂製</a></li>
                            </ul>
                        </li>

                        <li><a href="<%=application.getContextPath()%>/memberCenter.jsp">食客服務</a> </li>
                        <li><a href="<%=application.getContextPath()%>/cart.jsp">餐盤</a></li>

                    </ul></div>

                <script>
                    $(function () {
                        // 幫 #menu li 加上 hover 事件
                        $('#nav li').hover(function () {
                            // 先找到 li 中的子選單
                            var _this = $(this),
                                    _subnav = _this.children('ul');
                            // 變更目前母選項的背景顏色
                            // 同時淡入子選單(如果有的話)
                            _this.css('backgroundColor', 'rgba(15,60,6,1)');
                            _subnav.stop(true, true).fadeIn(400);
                        }, function () {
                            // 變更目前母選項的背景顏色
                            // 同時淡出子選單(如果有的話)
                            // 也可以把整句拆成上面的寫法
                            $(this).css('backgroundColor', '').children('ul').stop(true, true).fadeOut(400);
                        });
                        // 取消超連結的虛線框
                        $('a').focus(function () {
                            this.blur();
                        });
                    });
                </script>



            </div>


        </div>
