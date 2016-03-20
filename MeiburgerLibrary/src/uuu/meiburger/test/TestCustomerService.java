/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.meiburger.domain.Customer;
import uuu.meiburger.domain.MeiException;
import uuu.meiburger.model.CustomerService;

/**
 *
 * @author Administrator
 */
public class TestCustomerService {
    public static void main(String[] args) {
        try {
            
            CustomerService service = new CustomerService();
            
            Customer c = service.get("A123456789");
            System.out.println(c);
            
            //測好玩的，輸入帳號密碼~~~(login)
            System.out.print("請輸入c2身分證字號：");
            Scanner idin = new Scanner(System.in);
            String id = idin.next();
            System.out.print("請輸入c2密碼：");
            Scanner pwin = new Scanner(System.in);
            String pw = pwin.next();
            
            Customer c2 = service.login(id, pw);
            System.out.println(c2);
            
            
        } catch (MeiException ex) {
            Logger.getLogger(TestCustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
