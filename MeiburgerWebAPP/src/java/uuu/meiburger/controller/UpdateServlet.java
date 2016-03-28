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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uuu.meiburger.domain.Customer;
import uuu.meiburger.model.CustomerService;

/**
 *
 * @author user
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/update.do"})
public class UpdateServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8"); //請求編碼
        ServletContext context = this.getServletContext();//讀取初始化參數
        List<String> errors = new ArrayList<>();
        String finishedEdit;

//1.接受請求
        HttpSession session = request.getSession(false);
        Customer c = (Customer) session.getAttribute("user");

        String id = c.getId();
        String name = request.getParameter("name");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String checkCode = request.getParameter("check_code");
        
        System.out.println(birthday);
        
        //給原值處理
        if (name == null || (name = name.trim()) == "") {
            name = c.getName();
        }// name 檢查 如果沒給請求值 就輸入原值
        
        if (password1 == null || password1.length() <= 0 && password2 == null || password2.length() <= 0) {
            errors.add("必須輸入密碼");
        }        
        
        if (email == null || (email = email.trim()) == "") {
            email = c.getEmail();
        }

        if (phone == null || (phone = phone.trim()) == "") {
            phone = String.valueOf(c.getPhone());
        }
        if (address == null || (address = address.trim()) == "") {
            address = c.getAddress();
        }

        //密碼相同檢查
        if (!password1.equals(password2)) {
            errors.add("會員密碼必須與確認密碼一致");
        }//else

        if (checkCode == null || checkCode.length() == 0) {
            errors.add("必須輸入驗證碼");
        } else {
            /*檢查驗證碼*/
            String oldCheckCode = (String) session.getAttribute("ImageCheckCodeServlet");
            if (!checkCode.equalsIgnoreCase(oldCheckCode)) {
                errors.add("必須輸入正確驗證碼");
            } else {
                session.removeAttribute("ImageCheckCodeServlet");
            }
        }

//2.呼叫商業邏輯
        if (errors.size() == 0) {
          
            try {
                c.setId(id);
                c.setName(name);
                c.setPassword(password1);
                c.setEmail(email);
                c.setGender(gender.charAt(0));//html送過來的是字串 所以要抓字元
                c.setBirthday(birthday);
                c.setPhone(Integer.parseInt(phone));
                c.setAddress(address);

                CustomerService service = new CustomerService();
                service.update(c);

                //3.1 產生成功回應
                finishedEdit = "修改成功。";
                request.setAttribute("finishedEdit",finishedEdit);
                request.setAttribute("customer", c);
                response.sendRedirect(request.getContextPath() + "/memberCenterEdit.do");//送出轉交回應
                return;

            } catch (Exception ex) {
                System.out.println("無法修改" + ex);
                if (ex.getCause() != null) {
                    this.log("無法修改", ex);
                    errors.add("無法修改，請聯絡系統管理員 !");
                } else {
                    errors.add(ex.getMessage());
                }
            }
        }
        //3.2失敗回應
        request.setAttribute("errors", errors);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/memberCenter_edit.jsp");
        dispatcher.forward(request, response);

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
