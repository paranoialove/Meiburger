/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.meiburger.domain.Customer;
import uuu.meiburger.domain.MeiException;
import uuu.meiburger.domain.VIP;

/**
 *
 * @author MeiMei
 */
public class TestPolymorphism {

    public static void main(String[] args) {
        try {
            Object o = "Hello"; //polymorphism
            System.out.println(o.toString());

            //從頭到尾只有一個物件生成，可用兩個型別去表示:
            //1.object
            //2.String
//        String s = "Hello";//一般宣告
//        System.out.println(s.getClass().getName());
//        System.out.println(s.toString());
            if (o instanceof String) {
                String s = (String) o;//一般宣告
                System.out.println(s.toString());
                System.out.println(s.length());

            }

            o = new Date();//polymorphism
            System.out.println(o.toString());

            o = new Customer("A123456789", "John", "123456");
            System.out.println(o.getClass().getName());

            Customer c = new VIP("A223456781", "MARY", "123456");
            System.out.println(c.getId());
//System.out.println(c.getDiscount());  上層型別call不到下層型別的方法
            System.out.println(c.toString());
        } catch (MeiException ex) {
            Logger.getLogger(TestPolymorphism.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
