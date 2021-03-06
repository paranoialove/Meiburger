<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page errorPage="/WEB-INF/error.jsp"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Meiburger orderBurger! Bread</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!----------------------------- header style --------------------------------->
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <!----------------------------- BODY 主要style 開始---------------------------->
        <link href="css/main_body.css" rel="stylesheet" type="text/css"/>
        <!----------------------------- footer 主要style 開始---------------------------->
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
        <!---------------------- BODY 本頁特有元素 style 開始--------------------->
        <style type="text/css">
            .radiocontain{
                width: 100%;
                text-align: left;
            }
            .radio{
                vertical-align: top;
                display:inline-block;
                padding:0;
                width:200px;
                height:200px ;
                margin: 0.5em;
                border:2px solid black;
                box-shadow: 5px 5px 3px  #222;
            }
            #selectitemlist{
                text-align:left;
                margin-left:10%;
            }
            #selectitemlist li:last-child{
                font-weight:bold;
            }

        </style>
        <!--------------------- BODY 本頁特有元素 style 結束--------------------->

    </head>
    <body>
        <div id="header">
            <div><img src="img/logo.jpg" title="logo" id="logo" />            </div>
            <div id ="headertext">
                <div id ="websitename"><h1>綿堡MonsterBurger</h1></div>
                <div id ="loginblock">
                    <a href="login.html">登入</a>
                    <a href="register.html">註冊</a>
                </div>
                <div id="nav">
                    <a title="回到首頁" href="#home">首頁</a> | <a href="#aboutus">關於綿堡</a> | <a href="#order">訂製</a> | <a href="#other">其他餐點</a> | <a href="#member">食客服務</a> | <a href="#cart">餐盤</a>
                    <div id ="subNavOrder" ><a href="#ingredient">特選食材</a> | <a href="#topselect">經典組合</a> | <a href="orderNow">立刻訂製</a></div>
                </div></div>

        </div>
        <hr>

        <div id="main">
            <div id="sidebar">
                <div id="sidebarTitle"><h2>選擇漢堡的組合</h2></div>
                <ul id="sidebarlist">
                    <li><img src="#" title="1.主餐/尺寸" alt="1.主餐/尺寸" /></li>
                    <li><img src="#" title="2.麵包" alt="2.麵包" /></li>
                    <li><img src="#" title="3.配料" alt="3.配料" /></li>
                    <li><img src="#" title="4.醬料" alt="4.醬料" /></li>
                </ul>

                <div id="selectItemListTitle"><h2>已選擇項目</h2></div>
                <ul id="selectitemlist">
                    <li>尺寸：<span id="selectSizeiName">6吋</span>  </li>
                    <li>麵包：<span id="selectBreadName">全麥麵包</span> </li>
                    <li>主餐：<span id="selectFlaverName">燒烤牛肉 / ROAST BEEF</span></li>
                    <li>配料：<span id="selectVeggiesName">生菜、酸黃瓜、洋蔥、黑橄欖</span></li>
                    <li>醬料：<span id="selectSaucesName">黃芥末、甜蔥醬、美乃滋、橄欖油</span></li>
                    <li>小計：<span id="selectBurgerPrice">100元</span></li>
                </ul>
            </div>
            <div id="content">
                <div id ="article"><h2>1.主餐/尺寸</h2></div>
                <div id ="productlist">
                    <h3>選擇尺寸</h3>
                    <form>
                        <div id="sizeradio">
                            <input type="radio" id="inch6" name="burgerSize" value="6吋" checked="checked"/><label for="inch6">6吋</label>
                            <input type="radio" id="inch12" name="burgerSize" value="12吋" /><label for="inch12">12吋</label>
                            <p>價格:1221元</p>
                        </div>
                        <div class="radiocontain">
                            <div class="radio" id="breadItalian" onclick="isBreadSelected()">
                                <img src="#" alt="義大利白麵包" />
                                <div>義大利白麵包</div>
                            </div>
                            <div class="radio" id="breadWheat" onclick="isBreadSelected()">
                                <img src="#" alt="全麥麵包" />
                                <div>全麥麵包</div>
                            </div>
                            <div class="radio" id="breadParmensan" onclick="isBreadSelected()">
                                <img src="#" alt="巴馬乾酪" />
                                <div>巴馬乾酪</div>
                            </div>
                            <div class="radio" id="breadHeartyItalian" onclick="isBreadSelected()">
                                <img src="#" alt="家鄉麵包" />
                                <div>家鄉麵包</div>
                            </div>
                            <div class="radio" id="bread001" onclick="isBreadSelected()">
                                <img src="#" alt="麵包001" />
                                <div>麵包001</div>
                            </div>
                        </div>
                        <input type="submit" value="選擇"/>
                    </form>
                </div>
            </div>

        </div>
        <div id="footer"><%@include  file="/WEB-INF/footer.jsp" %>      </div>
    </body>
</html>
