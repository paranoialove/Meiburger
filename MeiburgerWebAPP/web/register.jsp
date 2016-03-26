<%@page import="uuu.meiburger.domain.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%-------------------------- header段落  --------------------------%>
<jsp:include  page="WEB-INF/header.jsp" >
    <jsp:param name="subtitle" value="Register" />
</jsp:include>

<%-------------------------- 中間版面  --------------------------%>
<script type="text/javascript">
    function refresh() {
        var image = document.getElementById("checkcodepic");
        image.src = "img/reg_check_code.jpg?get=" + new Date();
    }
</script>

<!---------------------- BODY 本頁特有元素 style 開始-------------------Javay-->
<style type="text/css">
    #content form{
        float: left;
    }
</style>
<!--------------------- BODY 本頁特有元素 style 結束-------------------Javay-->


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

<div id="footer"><%@include  file="/WEB-INF/footer.jsp" %>      </div>
</body>
</html>
