/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import uuu.meiburger.domain.Product;
import uuu.meiburger.domain.Outlet;

/**
 *
 * @author Administrator
 */
public class TestIngredientClone {

    public static void main(String[] args) {
        Product p1 = new Product(1, "全麥麵包", 100);      //編號:1 名稱:全麥麵包 單價:100元 

        Product p2 = p1.clone();

        System.out.println(p1 != p2); //true
        System.out.println(p1 == p2);
        System.out.println(p1.getClass() == p2.getClass()); //true
        System.out.println(p1.equals(p2)); //true,已override equals()方法

        Outlet o1 = new Outlet();
        o1.setId(2);
        o1.setName("AAA");
        o1.setPrice(123);
        System.out.println(o1.equals(p1));
        System.out.println(p1.equals(o1));
    }

}
