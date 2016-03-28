<%--
    Document   : register_ok
    Created on : 2016/3/22, 下午 04:04:14
    Author     : Administrator
--%>

<%@page import="uuu.meiburger.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8" info="註冊成功"  %>
<%-------------------------- header段落  --------------------------%>
<jsp:include  page="WEB-INF/header.jsp" >
    <jsp:param name="subtitle" value="RegisterOK" />
</jsp:include>

<%-------------------------- 中間版面  --------------------------%>
<% Customer c = (Customer) request.getAttribute("customer");%>

<div id="main">

    <div id="content">
        <h2>註冊成功</h2>
        <div id="contentText">
            <div><%= application.getInitParameter("app-name")%></div>
            <div><%= c == null ? "" : c%></div>
        </div>
    </div>
</div>
<div id="footer"><%@include  file="/WEB-INF/footer.jsp" %>      </div>
</body>
</html>
