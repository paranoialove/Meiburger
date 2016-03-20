package uuu.meiburger.test;

import uuu.meiburger.domain.Customer;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.meiburger.domain.MeiException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class TestCustomer {

    public static void main(String[] args) {
        try {
            Customer c = new Customer("A123456789", "張三", 'M', "123456", "three.chang@gmail.com");
            /* class作為參考型別，以及其成員變數，
            * 都須新建物件new ***()  //建構子// 出來才能使用。
            * 此為區域變數(於方法內)
             */

//        //if(c.checkId("A123456A89")){
//        c.setId("A123456789");
//        //} //看到雙引號，就是new String()
//        
//        c.setName("張三");

//        c.setGender('M'); //指派值需符合成員變數之型別
            c.setGender(Customer.MALE);

//        c.setPassword("123456");
//        c.setEmail("three.chang@gmail.com");
//
            /**
             * 抓取萬年曆GregorianCalendar(年,月,日).抓取生日那天getTime()
             */
//        c.setBirthday(new GregorianCalendar(1989,8,2).getTime());
//            c.setBirthday(1989, 8, 2);  //新增setBirthday(int year,iny month, int date)多載
            c.setBirthday("2016/2/17");
//        c.setPhone("25149491");
//        c.setAddress("台北市復興北路99號");
//        c.setMarried(true);        
//        c.setStatus(0);

            System.out.println("c.id = " + c.getId());
            System.out.println("c.name = " + c.getName());
            System.out.println("c.gender = " + (c.getGender() == Customer.MALE ? "MALE" : "FEMALE"));//得出結果用判斷式輸出男或女
            System.out.println("c.password = " + c.getPassword());
            System.out.println("c.email = " + c.getEmail());
            System.out.println("c.birthday = " + c.getBirthday());
            System.out.println("c.phone = " + c.getPhone());
            System.out.println("c.address = " + c.getAddress());
            System.out.println("c.married = " + c.isMarried());
            System.out.println("c.status = " + c.getStatus());
            System.out.println("c.getAge = " + c.getAge());
            System.out.println(c);//
        } catch (MeiException ex) {
            Logger.getLogger(TestCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
