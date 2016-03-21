<%--   我是JSP註解  網頁上不會呈現  其他註解都會呈現
    Document   : 99
    Created on : 2016/3/21, 上午 11:25:55
    Author     : AnastasiaWu
--%>
<!--我是HTML註解 網頁上會出現 -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>九九乘法表</title>
        <style type="text/css">
            /*  CSS註解 網頁上會出現;*/
        </style>
    </head>
    <body>
        <h1>九九乘法表</h1>

        <table border="1">
            <!--<script>
                //javacript 註解 網頁上會出現
            for(var i=0;i<3;i++)
            {
                document.write("<table>");
                for(var j=1;j<10;j++) {
                    
                    for(var k=3*i+1;k<=3*i+3;k++)
                    {        
                    document.write("<td>"+k+"*"+j+"="+k*j+"</td>");
                    }
                    document.write("<tr>");    
                }
                document.write("</table>");
            }
            </script>-->
        </table>

        
        <div>
            <h1>三個一組</h1>
            <% for (int i = 0; i < 3; i++) { %>
            <table>
                <% for (int j = 1; j < 10; j++) { %>

                <% for (int k = 3 * i + 1; k <= 3 * i + 3; k++) { %>
                <td><% out.print(k); %> * <% out.print(j); %> = <% out.print(k * j); %>  </td>
                <% } %>
                <tr>
                    <% } %>
            </table>
            <% } %>
        </div>

        <div>
            <h1>九個一行</h1>
            <table>
                <% for (int j = 1; j < 10; j++) { %>

                <% for (int k = 1; k < 10; k++) { %>
                <td style="padding:0.5em"><% out.print(k); %> * <% out.print(j); %> = <% out.print(k * j); %>  </td>
                <% } %>
                <tr>
                    <% }%>
            </table>           
        </div>



    </body>
</html>
