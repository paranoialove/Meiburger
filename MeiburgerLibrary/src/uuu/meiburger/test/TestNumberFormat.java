/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Administrator
 */
public class TestNumberFormat {
    public static void main(String[] args) {
        double k = 1.24556;
        System.out.println(Math.round(k));
        
        NumberFormat nf = NumberFormat.getCurrencyInstance();  
        //NumberFormat() 為抽象類別 不可new一個物件出來。
        //(選)可使用其子類別
        nf.setMinimumFractionDigits(3);
        nf.setMaximumFractionDigits(5);
        System.out.println(k);
        System.out.println(nf.format(k));
    }
}
