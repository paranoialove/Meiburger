<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%-------------------------- header段落  --------------------------%>
<jsp:include  page="WEB-INF/header.jsp" >
    <jsp:param name="subtitle" value="Home" />
</jsp:include>

<%-------------------------- 中間版面  --------------------------%>
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
<div id="footer"><%@include  file="/WEB-INF/footer.jsp" %>  </div>
</body>
</html>
