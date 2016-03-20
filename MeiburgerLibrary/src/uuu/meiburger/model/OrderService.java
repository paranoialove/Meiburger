/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.model;

import uuu.meiburger.domain.Customer;
import uuu.meiburger.domain.Product;
import uuu.meiburger.domain.Outlet;
import uuu.meiburger.domain.VIP;

/**
 *
 * @author MeiMei
 */
public class OrderService {
//    public double order(ShoppingCart cart){
//
//    }

    public double order(Customer c, Product p, int quantity) {
        double rtn = 0;
        if (c != null && p != null && quantity > 0) {
            rtn = p.getPrice() * quantity;

            if (!(p instanceof Outlet) && c instanceof VIP) {
                //如產品非清倉品  且 c 是否為VIP類別  如是，可再打折。
                //VIP v = (VIP) c;
                //rtn = rtn * (100 - v.getDiscount()) /100D;
                rtn *= (100 - ((VIP) c).getDiscount()) / 100D;
            }
        } else {
            //拋出錯誤
        }

        return rtn;

    }

}
