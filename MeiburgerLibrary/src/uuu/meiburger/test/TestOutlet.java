/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import uuu.meiburger.domain.Outlet;

/**
 * 範例用：overritting
 *
 * @author MeiMei
 */
public class TestOutlet {

    public static void main(String[] args) {
        Outlet o = new Outlet();

        o.setId(2);
        o.setName("特價組合A");
        o.setPrice(100);
        System.out.println("o = " + o);
        System.out.println("名稱 = " + o.getName());
        System.out.println("折扣 = " + o.getDiscount());
        System.out.println("售價" + o.getPrice());
        System.out.println("原價" + o.getListPrice());

        /**
         * 對於父類別Ingredient內的方法想要修改， 需要去覆蓋方法Overriding 1.範圍要一樣或更大
         * 2.回傳型別、方法名稱、參數型別與個數都要完全一樣。
         *
         * 這邊以售價(折扣價)與原價做範例區別
         */
        //object中，toString函式的overriding非常頻繁使用
        //如 物件.toString() 將會回傳類別名稱與記憶體所在位置
    }
}
