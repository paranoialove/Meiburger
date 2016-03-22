<%-- 
    Document   : 500
    Created on : 2016/3/21, 下午 05:33:40
    Author     : Administrator
--%>

<%@page contentType="text/html" isErrorPage="true"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>錯誤訊息</title>
        <style type="text/css">
            body{
                background-color: #a3a3a3;


            }
            #aaa{
                margin:20% auto;
            }
            #content{
                text-align: center;

            }
        </style>
        <script>
            var s1 = "block";
            var s2 = "width:80%;display:blocked;font-size:60%;color:blue";
            function show_details() {
                var d = document.getElementById("details");
                try {
                    d.style.setAttribute("display", s1);
                    if (s1 == "none") {
                        s1 = "block";
                    } else {
                        s1 = "none";
                    }
                } catch (err) {
                    d.setAttribute("style", (s2 == null ? "width:80%;display:none;" : s2));
                    if (s2 == null) {
                        s2 = "width:80%;display:blocked;font-size:60%;color:blue";
                    } else {
                        s2 = null;
                    }
                }
            }
        </script>
    </head>
    <body>
        <div id="aaa">
            <div id="bg" style="text-align: center;  opacity:0.8">
                <img src="img/error.jpg" alt=""/>
            </div>
            <div id="content">
                <p style='font-size:80%'>執行<span style='color:darkred'><%= request.getRequestURI()%></span>時發生下列錯誤：<br/>
                    <% if (exception != null) {
                            out.println(exception.getClass().getName() + ":\t" + exception.getMessage());%>
                    <a href="javascript:show_details()">details...</a><br/>
                    <span id='details' style="width:60%;display:none;color:blue">
                        <%
                            this.log("網頁執行失敗", exception);
                            exception.printStackTrace(new java.io.PrintWriter(out));
                        %>
                    </span>
                    <% }%>          
                </p>
            </div>
        </div>
    </body>
</html>
