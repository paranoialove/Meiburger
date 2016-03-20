/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import uuu.meiburger.domain.BloodType;
import uuu.meiburger.domain.Customer;

/**
 *
 * @author Administrator
 */
public class TestCustomerBloodType {
    public static void main(String[] args) {
        Customer c = new Customer();
        c.setBloodType(BloodType.B);
        
        System.out.println("c.getBloodType() = " + c.getBloodType());
        System.out.println("共有" + BloodType.values().length + "個選項" );
    }
}
