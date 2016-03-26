<%@page import="uuu.meiburger.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<%-------------------------- header段落  --------------------------%>
<jsp:include  page="WEB-INF/header.jsp" >
    <jsp:param name="subtitle" value="Menu" />
</jsp:include>

<%-------------------------- 中間版面  --------------------------%>
<!---------------------- BODY 本頁特有元素 style 開始--------------------->
<style type="text/css">
    .plist{
        display:inline-block;
        padding:25px;
        width:100px;
        height:150px ;
        border:2px solid black;
        margin: 10px;
        box-shadow: 5px 5px 3px  #222;
    }
</style>
<!--------------------- BODY 本頁特有元素 style 結束--------------------->


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


        <div id="selectItemListTitle"><h2>已點項目</h2></div>
        <ul id="selectitemlist">
            <li><span> 商品名稱</span> | <span>數量</span> | <span>價格</span></li>
            <li><span> 商品名稱</span> | <span>數量</span> | <span>價格</span></li>
            <li><span> 商品名稱</span> | <span>數量</span> | <span>價格</span></li>
            <li><span> 商品名稱</span> | <span>數量</span> | <span>價格</span></li>
        </ul>
    </div>
    <div id="content">
        <div id ="article"><h2>飲品&點心</h2></div>
        <div id="contentText">
            <div id ="productlist">
                <ul>
                    <li class="plist">
                        <img src="#" />
                        <h4>產品1</h4>
                        <p>價格:1221元</p>
                    </li>
                    <li class="plist">
                        <img src="#" />
                        <h4>產品2</h4>
                        <p>價格:123131</p>
                    </li>
                    <li class="plist">
                        <img src="#" />
                        <h4>產品3</h4>
                        <p>價格:132131</p>
                    </li>
                    <li class="plist">
                        <img src="#"/>
                        <h4>產品4</h4>
                        <p>價格</p>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div id="footer"><%@include  file="/WEB-INF/footer.jsp" %>      </div>
</body>
</html>
