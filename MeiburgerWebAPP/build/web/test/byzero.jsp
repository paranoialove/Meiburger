<%-- 
    Document   : byzero
    Created on : 2016/3/21, 下午 05:24:58
    Author     : Administrator
--%>

<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page errorPage="/WEB-INF/error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p><%= 10/1 %></p> //10/0 >> ERROR 500
        <p>生日<%=DateFormat.getDateInstance().parse("slkjf;lksdj")   %></p>  
        
    </body>
</html>
