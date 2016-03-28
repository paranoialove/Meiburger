<%@page import="uuu.meiburger.domain.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%-------------------------- header段落  --------------------------%>
<jsp:include  page="WEB-INF/header.jsp" >
    <jsp:param name="subtitle" value="edit" />
</jsp:include>

<%-------------------------- 中間版面  --------------------------%>

<script>
    $(function () {
        $("#birthday").datepicker({
            changeMonth: true,
            changeYear: true
        });
    });
    //更新驗證碼
    function refresh() {
        var image = document.getElementById("check_image");
        image.src = "img/check_code.jpg?get=" + new Date();
    }
</script>

<% //if (session != null) {        response.sendRedirect(request.getContextPath() + "/login.jsp");    } else {%>



<div id="main">
    <div id="content">
        <div ></div>
        <div id="contentText">


            <%
                List<String> errors = (List<String>) request.getAttribute("errors");
                if (errors != null && errors.size() > 0) {
            %>
            <div id="errorarea">
                <% for (String msg : errors) {%>
                <li><%=msg%></li>
                    <% } %>
            </div>
            <% }%>

            <%
                Customer c = (Customer) session.getAttribute("user");
            %>

            <form method="POST" action="update.do">
                <p>
                    <label for="userid" > 會員帳號 : </label>  <!--身分證字號當帳號-->
                    <label > <%= c != null ? c.getId() : ""%> </label>
                </p>
                <p>
                    <label for="pwd1" > 修改密碼 : </label>
                    <input type="password" id="pwd1" name="password1" minlength="6" maxlength="20" placeholder="原密碼"  >
                </p>
                <p>
                    <label for="pwd2" > 確認密碼 : </label>
                    <input type="password" id="pwd2" name="password2" minlength="6" maxlength="20" placeholder="原密碼" >
                </p>
                <p>
                    <label for="name" > 修改姓名 : </label>
                    <input type="text" id="name" name="name" placeholder="<%= c != null ? c.getName() : ""%>"
                           value="<%= request.getMethod().equalsIgnoreCase("post") ? request.getParameter("name") : ""%>">
                </p>
                <p>
                    <label for="email" > 修改 E-mail : </label>
                    <input type="email" id="email" name="email" placeholder="<%= c != null ? c.getEmail() : ""%>"
                           value="<%= request.getMethod().equalsIgnoreCase("post") ? request.getParameter("email") : ""%>">
                </p>
                <p>
                    <label for="gender" > 修改性別 : </label>
                    <input type="radio" id="male" name="gender" value="M" required
                           <%--<%= c != null ? c.getGender() : ""%>--%>
                           <% if (c != null && c.getGender() == 'M') {%>
                           checked
                           <%}%>
                           <%= request.getParameter("gender") != null && request.getParameter("gender").charAt(0) == Customer.MALE ? "checked" : ""%>
                           > <label for="male" > 男 </label>
                    <input type="radio" id="female" name="gender" value="F" required
                           <%--<%= c != null ? c.getGender() : ""%>--%>
                           <% if (c != null && c.getGender() == 'F') {%>
                           checked
                           <%}%>
                           <%= request.getParameter("gender") != null && request.getParameter("gender").charAt(0) == Customer.FEMALE ? "checked" : ""%>
                           > <label for="female" > 女 </label>
                </p>
                <p>
                    <label for="birthday" > 修改生日 : </label>
                    <!--用預設date的這邊可以不用理我 -->
                    <input type="text" id="birthday" name="birthday" placeholder="<% if (c != null)%><%= c.getBirthday() !=null?c.getBirthday():"" %> "

                           value="<%= request.getMethod().equalsIgnoreCase("post") ? request.getParameter("birthday") : ""%>">
                </p>
                <p>
                    <label for="phone">修改電話</label>
                    <input type="tel" id="phone" name="phone" placeholder="<% if (c != null)%><%= String.valueOf(c.getPhone())!=null?c.getPhone():"" %> "
                           value="<%= request.getMethod().equalsIgnoreCase("post") ? request.getParameter("phone") : ""%>">
                </p>
                <p>
                    <label for="address">修改地址</label>
                    <input id="address" name="address" placeholder="<% if (c != null)%><%= c.getAddress()!=null?c.getAddress():"" %>"
                           value="<%= request.getMethod().equalsIgnoreCase("post") ? request.getParameter("address") : ""%>">
                </p>

                <p>
                    <img src="img/echeck_code.jpg" alt="" id="check_image"/> <a href="javascript:refresh()"> 更新圖片</a> <br>
                    <label for="check_code" > 檢核碼 : </label> <br>
                    <input type="text" id="check_code" name="check_code" placeholder="請輸入檢核碼" required>
                </p>

                <input type="submit" value="確定">
            </form>
        </div>

    </div>

</div>
<div id="footer"><%@include  file="/WEB-INF/footer.jsp" %>      </div>
</body>
</html>

<%//}%>