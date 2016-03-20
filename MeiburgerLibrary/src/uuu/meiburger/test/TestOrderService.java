/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.meiburger.domain.Customer;
import uuu.meiburger.domain.Product;
import uuu.meiburger.domain.MeiException;
import uuu.meiburger.domain.Outlet;
import uuu.meiburger.domain.VIP;
import uuu.meiburger.model.OrderService;

/**
 *
 * @author MEiMEi
 */
public class TestOrderService {

    public static void main(String[] args) {
        try {
            Customer c = new Customer("A123456789", "張三", "123456");
            VIP v = new VIP("A223456781", "Linda", "123456");
            
            Product p = new Product(1, "全麥麵包", 100);
            Product p2 = new Product(3, "蘋果", 60);
            
            Outlet o = new Outlet();
            o.setId(2);
            o.setName("特價商品");
            o.setPrice(460);
            o.setDiscount(50);
            
            OrderService service = new OrderService();
            System.out.println("一般顧客購買全麥麵包(100) *2");
            System.out.println(service.order(c, p, 2));
            System.out.println("VIP購買蘋果(60) *1");
            System.out.println(service.order(v, p2, 1));
            System.out.println("一般顧客購買特價商品(460) *1");
            System.out.println(service.order(c, o, 1));
            System.out.println("VIP購買全麥麵包(100) *2");
            System.out.println(service.order(v, p, 2));
            System.out.println("VIP購買特價商品(460) *1：");
            System.out.println(service.order(v, o, 1));
            
            System.out.println(c instanceof Object); //T
            System.out.println(c instanceof Customer);  //T
            System.out.println(c instanceof VIP); //F
            
            System.out.println(v instanceof Object);  //T
            System.out.println(v instanceof Customer); //T
            System.out.println(v instanceof VIP); //T
        } catch (MeiException ex) {
            Logger.getLogger(TestOrderService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
