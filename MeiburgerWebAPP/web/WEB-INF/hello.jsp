<%@page import="java.util.Date"%>
<%@page import="java.util.Enumeration"%>
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
        <style type="text/css">
            th{
                text-align:left;
            }
        </style>
    </head>
    <body>
        <%!  //宣告類別屬性 
            private int i = 100000;
            private String welcome = "Hello~~~";

            public void jspInit() {

                System.out.println(this.getServletName() + "created...");
                String welcome = this.getInitParameter("welcome");
                if (welcome != null) {
                    this.welcome = welcome;
                }
            }

            public void jspDestroy() {
                System.out.println(this.getServletName() + " has been destroyed");
            }
        %>       
        <% //方法內的區域變數
            int i = 10;
        %>
        <% //out.println(this.i); %><br>        
        <% //out.println(i);%>

        <h1><%= this.welcome%> <%= this.getServletName()%> <%= request.getContextPath()%></h1>
        <p>現在時間：</p><p>  <%=new java.util.Date()%>  </p>
        <p>Browser：<%=request.getHeader("user-agent")%></p>
        <p>屬性i:<%= this.i%></p>
        <p>區域變數i:<%= i%>   </p>
        <p>user.agent:<%= request.getHeader("user-agent")%></p>
        <p>remote add:<%= request.getRemoteAddr()%></p>
        <hr>
        <table style="width:100%">
            <tr><th>NAME</th><th>VALUE</th></tr>
                    <% Enumeration<String> names = request.getHeaderNames();
                        while (names.hasMoreElements()) {
                            String name = names.nextElement();%>
            <tr><td><%=name%></td><td><%= request.getHeader(name)%></td><tr>
                <%
                    }
                %>            
        </table>
        <hr>
        <table style="width:60%">
            <tr><th>NAME</th><th>VALUE</th></tr>
                    <% Enumeration<String> paraNames = request.getParameterNames();
                        while (paraNames.hasMoreElements()) {
                            String paraName = paraNames.nextElement();%>
            <tr><td><%=paraName%></td><td><%= request.getParameter(paraName)%></td><tr>
                <%
                    }
                %>            
        </table>


        <!--還有response  header  body未寫-->

        <hr>
        <table style="width:60%">
            <tr><th>NAME</th><th>VALUE</th></tr>
            <tr><td>session id</td><td><%= session.getId()%></td></tr>
            <tr><td>session getCreationTime</td><td><% Date d = new Date(session.getCreationTime());%><%=d%></td></tr>
            <tr><td>session getLastAccessedTime</td><td><% Date dd = new Date(session.getLastAccessedTime());%><%=dd%></td></tr>
        </table>
        <hr>
        <table>
            <tr><th>NAME</th><th>VALUE</th></tr>
            <tr><td>ContextPath</td><td><%= application.getContextPath()%></td></tr>
            <tr><td>RealPath</td><td><%= application.getRealPath("/")%></td></tr>
        </table>
        <hr>
        <table>
            <tr><th>NAME</th><th>VALUE</th></tr>
            <tr><td>config getInitParameter</td><td><%= config.getInitParameter("welcome")%></td></tr>
            <tr><td>直接抓this</td><td><%= this.getInitParameter("welcome")%></td></tr>
        </table>

        <hr>
    </body>
</html>
