<%-- 
    Document   : 99
    Created on : 2016/3/21, 上午 11:25:55
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>九九乘法表</title>
    </head>
    <body>
        <h1>九九乘法表</h1>
        
<table border="1">
<script>

for(var i=0;i<3;i++)
{
    document.write("<tr>");
    for(var j=1;j<10;j++)
    {
        
        for(var k=3*i+1;k<=3*i+3;k++)
        {        
        document.write("<td>"+k+"*"+j+"="+k*j+"</td>");
        }
        document.write("<tr>");
    
    }
    document.write("<tr>");
}
</script>
</table>
        
        
    </body>
</html>
