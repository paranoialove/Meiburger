package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class error_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable(request);
    if (exception != null) {
      response.setStatus((Integer)request.getAttribute("javax.servlet.error.status_code"));
    }
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>錯誤訊息</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            body{\n");
      out.write("                background-color: #a3a3a3;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #aaa{\n");
      out.write("                margin: 0px auto;\n");
      out.write("            }\n");
      out.write("            #content{\n");
      out.write("                text-align: center;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            var s1 = \"block\";\n");
      out.write("            var s2 = \"width:80%;display:blocked;font-size:60%;color:blue\";\n");
      out.write("            function show_details() {\n");
      out.write("                var d = document.getElementById(\"details\");\n");
      out.write("                try {\n");
      out.write("                    d.style.setAttribute(\"display\", s1);\n");
      out.write("                    if (s1 == \"none\") {\n");
      out.write("                        s1 = \"block\";\n");
      out.write("                    } else {\n");
      out.write("                        s1 = \"none\";\n");
      out.write("                    }\n");
      out.write("                } catch (err) {\n");
      out.write("                    d.setAttribute(\"style\", (s2 == null ? \"width:80%;display:none;\" : s2));\n");
      out.write("                    if (s2 == null) {\n");
      out.write("                        s2 = \"width:80%;display:blocked;font-size:60%;color:blue\";\n");
      out.write("                    } else {\n");
      out.write("                        s2 = null;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"aaa\">\n");
      out.write("            <div id=\"bg\" style=\"text-align: center;  opacity:0.8\">\n");
      out.write("                <img src=\"img/error.jpg\" alt=\"\"/>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"content\">\n");
      out.write("                <p style='font-size:80%'>執行<span style='color:darkred'>");
      out.print( request.getRequestURI());
      out.write("</span>時發生下列錯誤：<br/>\n");
      out.write("                    ");
 if (exception != null) {
                    out.println(exception.getClass().getName() + ":\t" + exception.getMessage());
      out.write("\n");
      out.write("                    <a href=\"javascript:show_details()\">details...</a><br/>\n");
      out.write("                    <span id='details' style=\"width:60%;display:none;color:blue\">\n");
      out.write("                        ");

                            exception.printStackTrace(new java.io.PrintWriter(out));
                        
      out.write("\n");
      out.write("                    </span>\n");
      out.write("                    ");
 }
      out.write("          \n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
