/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.model;

import uuu.meiburger.domain.Product;

/**
 * Pass-by-value 範例 method(argument參數){ parameter 參數、引數 }
 *
 * @author MeiMei
 */
public class ProductService {
//    //此為錯誤寫法，不可以直接修改得到之計算參數或物件  
//    public void addPrice10(double price){               
//        price += 10;
//    }

    public double addPrice10T(double price) {
        double rtn = price + 10;
        return rtn;
    }
//    //此為錯誤寫法，不可以直接修改得到之計算參數或物件            
//    public void addPrice10(Ingredient p) {
//        p.setPrice(p.getPrice() + 10);
//    }

    public double addPrice10T(Product p) {
        //此方法較多餘了，可參考未註解方式
        return (p.getPrice() + 10);
    }

}
