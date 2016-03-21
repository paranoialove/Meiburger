/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.meiburger.domain.Customer;
import uuu.meiburger.domain.MeiException;

/**
 *
 * @author Administrator
 */
public class TestFinalCustomer {
    public static void main(String[] args) {
        try {
            final Customer c = new Customer("A123456789", "Tom", "123456", "123@uuu.com.tw");
            System.out.println("c.getId() = " + c.getId());
            
            c.setId("A123456770");
            System.out.println("c.getId() = " + c.getId());
            
            //c = new Customer("A123456770","jin","123456");  //不能修改物件了(已final)
        } catch (MeiException ex) {
            Logger.getLogger(TestFinalCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
