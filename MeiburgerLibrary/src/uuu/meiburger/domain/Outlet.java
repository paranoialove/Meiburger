/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.domain;

/**
 * 範例用：overritting 父類別子類別 super.XXX();應用
 *
 * @author MeiMei
 */
public class Outlet extends Product {

    private int discount = 50;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * @return the uniPrice
     */
    @Override   //檢查是否覆蓋方法　可使用insert code跑出模組先宣告
    public double getPrice() {
        /* uniPrice是父類別Ingredient內的屬性，
         * 開放給子類別須將權限設置為protected，
         * 以便覆蓋方法內容。
         */
        //double p = uniPrice * (100 - discount) / 100;

        double p = super.getPrice() * (100 - this.discount) / 100D;  
        if(super.getPrice() > 0 && p >= 0){
            return p;
        }else{
            throw new RuntimeException("售價不正確" + p);
        }
        
        

        //遞迴recursion/recursive call：
        //this.XXX();   方法中呼叫自己的方法。
        //super.XXX();  呼叫父類別內中，有相同名稱的方法。
        //查詢原價
    }

    public double getListPrice() {
        return super.getPrice();
    }
}
