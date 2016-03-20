package uuu.meiburger.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.meiburger.model.HelloService;
import uuu.meiburger.domain.Customer;
import uuu.meiburger.domain.MeiException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MeiMei
 */
public class TestHelloService {

    //測試多載overloading 
    public static void main(String[] args) {
        try {
            //宣告建立物件
            HelloService service = new HelloService();
            
            System.out.println(service.sayHello());
            
            String rtn = service.sayHello("Peter");
            System.out.println(rtn);
            
            Customer c = new Customer();
            c.setName("John");
            String rtn2 = service.sayHello(c);
            System.out.println(rtn2);
            
            String rtn3 = service.sayHello();
            System.out.println(rtn3);
            
            System.out.println(service.sayHello());
            //方法的參數：可以是值，也可以是一個有回傳值的方法(同資料型別)非void。
            
            int len = service.sayHello().length() + 2;  //型別要正確
            System.out.println("len = " + len);
            
            String s = null;
            System.out.println(s);
        } catch (MeiException ex) {
            Logger.getLogger(TestHelloService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
