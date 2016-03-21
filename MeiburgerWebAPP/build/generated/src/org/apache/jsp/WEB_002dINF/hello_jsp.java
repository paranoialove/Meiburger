package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class hello_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  //宣告類別屬性 
            private int i = 100000;
            private String welcome = "Hello~~~" ;

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
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=utf-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>TODO supply a title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("       \n");
      out.write("        ");
 //方法內的區域變數
            int i = 10;
        
      out.write("\n");
      out.write("        ");
 //out.println(this.i); 
      out.write("<br>        \n");
      out.write("        ");
 //out.println(i);
      out.write("\n");
      out.write("\n");
      out.write("        <h1>");
      out.print( this.welcome);
      out.write(' ');
      out.print( this.getServletName() );
      out.write(' ');
      out.print( request.getContextPath() );
      out.write("</h1>\n");
      out.write("        <p>現在時間：</p><p>  ");
      out.print(new java.util.Date());
      out.write("  </p>\n");
      out.write("        <p>Browser");
      out.print(request.getHeader("user-agent"));
      out.write("</p>\n");
      out.write("        <p>屬性i:");
      out.print( this.i);
      out.write("</p>\n");
      out.write("        <p>區域變數i:");
      out.print( i);
      out.write("   </p>\n");
      out.write("\n");
      out.write("        <p>\n");
      out.write("        </p>\n");
      out.write("\n");
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
