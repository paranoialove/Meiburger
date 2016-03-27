<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%-------------------------- header段落  --------------------------%>
<jsp:include  page="WEB-INF/header.jsp" >
    <jsp:param name="subtitle" value="Login" />
</jsp:include>

<%-------------------------- 中間版面  --------------------------%>

<script type="text/javascript">
    function refresh() {
        var image = document.getElementById("checkcodepic");
        image.src = "img/check_code.jpg?get=" + new Date();
    }
</script>
<style type="text/css">
    #contentText>div{
        float: top;
    }
    #contentText>div>form{
        float: top;
        margin-left: 20px;
        height: 250px;
        text-align: left;
        padding-top: 5px;
    }
    #errorarea{
        background-color: rgba(255,247,63,0.6);
        line-height: 3em;
    }


</style>

<div id="main">
    <div id="sidebar"></div>
    <div id="content">
        <div id ="article"><h2>登入</h2></div>




        <div id="contentText" >
            <div>
                <form method="POST" action="login.do">
                    <p><label for="userid">帳號</label><input type="text" id="userid" name="id" placeholder="請輸入帳號" required
                                                            value="<%= request.getParameter("id") == null ? "" : request.getParameter("id")%>"></p>
                    <p><label for="userpw">密碼 </label><input type="password" id="userpw" name="pw" placeholder="請輸入密碼" required/></p>
                    <p><img id="checkcodepic" src="img/check_code.jpg" alt="檢核圖片" /><br>
                        <label for="checkCode">驗證碼</label>
                        <input type="button" value="更新" name="updatecode" id="updatecode" onclick="refresh()"/>
                        <input type="text" id="checkCode" name="checkcode" placeholder="請輸入驗證碼" required /></p>
                    <input type=submit value="確定" />
                </form></div>

            <div id="errorarea">
                <% List<String> error1 = (List<String>) request.getAttribute("errors");
                    if (error1 != null && error1.size() > 0) { %>
                <% for (String msg : error1) {%>
                <%= msg%> <a href="<%=application.getContextPath()%>/register.jsp">[新註冊?]</a>
                <% } %>
                <%}%>
            </div>
        </div>
    </div>
</div>

<div id="footer"><%@include  file="/WEB-INF/footer.jsp" %>      </div>
</body>
</html>
