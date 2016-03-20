/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import uuu.meiburger.domain.Product;
import uuu.meiburger.model.ProductService;

/**
 * Pass-by-value 範例
 *
 * @author MeiMei
 */
public class TestIngredient {

    public static void main(String[] args) {
        Product B = new Product();
        B.setId(1);
        B.setName("全麥麵包");
        B.setPrice(60);
        System.out.println("B.getPrice() = " + B.getPrice());

//        double price = B.getPrice() + 10;
//        B.setPrice(price);
        ProductService service = new ProductService();

        service.addPrice10T(B.getPrice());
        System.out.println("B.getPrice() = " + B.getPrice());

        service.addPrice10T(B);
        System.out.println("B.getPrice() = " + B.getPrice());
    }
}
