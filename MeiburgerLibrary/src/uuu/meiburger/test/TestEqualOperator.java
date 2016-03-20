/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import uuu.meiburger.domain.Product;

/**
 * 。資料庫應用。
 *
 * @author MEIMEI
 */
public class TestEqualOperator {

    public static void main(String[] args) {
        //比較資料庫所查出資料列        
        Product p1 = new Product(1, "全麥麵包", 100);
        Product p2 = new Product(1, "全麥麵包", 100);
        System.out.println(p1 == p2); //false    不同記憶體位置

        System.out.println(p1.equals(p2));//true 資料內容(已override equals()方法)
        System.out.println(p1.equals(p2) ? p1.hashCode() == p2.hashCode() : false);
    }
}
