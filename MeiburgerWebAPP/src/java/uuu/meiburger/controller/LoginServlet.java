/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uuu.meiburger.domain.Customer;
import uuu.meiburger.domain.MeiException;
import uuu.meiburger.model.CustomerService;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login.do"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        //0. 錯誤清單
        List<String> errorList = new ArrayList<>();
        //1.讀取請求中的表單資料
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String checkcode = request.getParameter("checkcode");

        // 1.1格式檢查
        if (id == null || id.length() <= 0 || pw == null || pw.length() <= 0) {
            errorList.add("必須輸入帳號密碼");
        }
        if (checkcode == null) {
            errorList.add("必須輸入驗證碼");
        } else {
            //檢查驗證碼
        }
        //1.1.1  格式正確
        if (errorList != null && errorList.size() == 0) {
            //2.呼叫商業邏輯
            CustomerService service = new CustomerService();
            try {
                /**              ----- * 商業邏輯內容  -----           */
                Customer c = service.login(id, pw);
                if (c != null) {
                    
                    //會員線上瀏覽人次
                    ServletContext application = this.getServletContext();
                    Integer cunt = (Integer)application.getAttribute("app.login.cunt");
                    if(cunt==null){
                        //初始值
                        cunt=1;
                    }else{                        
                        cunt++;
                    }
                    application.setAttribute("app.login.cunt", cunt);
                    
                    
                    //3.1產生回應 轉交給login_ok.jsp   -登入成功
                    //使用絕對路徑(此行為皆在server上處理)
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/login_ok.jsp");
                    request.setAttribute("user", c);
                    dispatcher.forward(request, response);
                    return;
                } 
                else {
                    errorList.add("帳號或密碼錯誤，登入失敗");
                }
            } catch (MeiException ex) {
                //Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("無法登入，請聯絡系統管理員。" + ex);
                if(ex.getCause() != null){
                    this.log("無法登入",ex);
                    errorList.add("無法登入，請聯絡系統管理員。");
                }else{
                    errorList.add(ex.getMessage());
                }
            }
        }
        //1.1.2  格式錯誤
        //3.2產生回應 -失敗   
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>無法登入</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>登入失敗！" + errorList + "</h1>");
            out.println("<input type='button' value='回上頁' onclick='history.back();' />");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
