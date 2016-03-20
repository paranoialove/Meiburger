/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import uuu.meiburger.domain.Customer;
import uuu.meiburger.domain.MeiException;

/**
 *
 * @author Administrator
 */
public class TestCustomerCheckId {
    public static void main(String[] args) {
        final Customer c ;
        try{
            c =  new Customer("A123456787","John", "123456");
            c.setId("A123456787");     
            System.out.println(c.checkId("A123456789"));
        }catch(MeiException ex){
            System.out.println(ex);
        }
        
    }
}
