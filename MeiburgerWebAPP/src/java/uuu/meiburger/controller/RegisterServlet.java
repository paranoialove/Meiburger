/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register.do"})
public class RegisterServlet extends HttpServlet {

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
        // 0. 錯誤清單
        List errorList = new ArrayList<>();
        //  1.取得並檢查register.html表單資料
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String pw = request.getParameter("pw");
        String pwck = request.getParameter("pwck");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String checkcode = request.getParameter("checkcode");

        if (id == null || (id = id.trim()).length() == 0) {
            errorList.add("必須輸入帳號");
        } else {
            //帳號格式檢察
        }

        if (username == null || (username = username.trim()).length() == 0) {
            errorList.add("必須輸入姓名");
        }

        if (pw == null || pw.length() <= 0) {
            errorList.add("必須輸入密碼");
        } else if (pwck == null || pwck.length() <= 0) {
            errorList.add("必須再輸入一次密碼");
        } else if (!pw.equals(pwck)) {
            errorList.add("兩次密碼輸入不同");
        }

        if (email == null || email.length() <= 0) {
            errorList.add("必須輸入email");
        } else {
            //email格式檢查
        }

        if (checkcode == null) {
            errorList.add("必須輸入驗證碼");
        } else {
            //檢查驗證碼
        }

        if (errorList.size()==0) {
            // 2.執行商業邏輯    
            try {
                Customer c = new Customer();
                c.setId(id);
                c.setName(username);
                c.setPassword(pw);
                c.setGender(gender.charAt(0));
                c.setEmail(email);

                CustomerService service = new CustomerService();
                service.register(c);

                //3.1輸出結果 - 成功  
                RequestDispatcher dispatcher = request.getRequestDispatcher("/register_ok.jsp");
                request.setAttribute("customer", c);
                dispatcher.forward(request, response);
                return;
       
            } catch (MeiException ex) {
                //Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("無法註冊，請聯絡系統管理員。" + ex);
                if (ex.getCause() != null) {
                    this.log("無法註冊", ex);
                    errorList.add("無法註冊，請聯絡系統管理員。");
                } else {
                    errorList.add(ex.getMessage());
                }
            }

            //3.2輸出結果 - 失敗
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            request.setAttribute("errors", errorList);
            dispatcher.forward(request, response);
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
