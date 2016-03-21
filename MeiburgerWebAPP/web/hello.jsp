<%@page pageEncoding='utf-8'  %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>TODO write content</h1>
        <p>現在時間：</p><p>  <%=new java.util.Date() %>  </p>
        <p>Browser<%= request.getHeader("user-agent") %></p>
        
        
    </body>
</html>
