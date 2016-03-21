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
 * 物件建立與記憶體之範例
 *
 * @author Administrator
 */
public class TestCustomer2 {

    public static void main(String[] args) {
        try {
            int i = 1;
            int j = i;
            i = i + 1;
            System.out.println("i = " + i);
            System.out.println("j = " + j);
            
            System.out.println(i == j);
            
            Customer c1 = new Customer();
            c1.setGender('M');
            
            Customer c2 = c1;
            c2.setGender('F');
            
            System.out.println("c1.getGender() = " + c1.getGender());
            System.out.println("c2.getGender() = " + c2.getGender());
            
            Customer c3 = new Customer("A123456789", "張三", "123456", "233@uuu.com.tw");
            Customer c4 = new Customer("A123456770", c3.getName(), c3.getPassword(), c3.getEmail());
            
            System.out.println("c3.getName() = " + c3.getName());//張三
            System.out.println("c4.getName() = " + c4.getName());//張三
            
            System.out.println(c3 == c4);  //false 因為是在不同的記憶體(不同物件)
            
            c4.setName("李四");
            
            System.out.println("c3.getName() = " + c3.getName());//張三
            System.out.println("c4.getName() = " + c4.getName());//李四
            
            c4 = c3;   //原本c4的資料都沒有了
            
            System.out.println("c3.getName() = " + c3.getName());//張三
            System.out.println("c4.getName() = " + c4.getName());//張三
            System.out.println(c3 == c4);//檢查是否為同一物件
            
            c3.setName("團團源源");
            System.out.println("c3.getName() = " + c3.getName());
            System.out.println("c4.getName() = " + c4.getName());
            System.out.println(c3 == c4);//檢查是否為同一物件
        } catch (MeiException ex) {
            Logger.getLogger(TestCustomer2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
