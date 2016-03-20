/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class TestDate {

    public static void main(String[] args) {
        //有可能錯誤  因為Date有可能給null值
        System.out.println(new Date().after(new Date()));
        Date theDate = new Date();
        System.out.println(theDate);

        System.out.println(new Date(1000).after(null));

        System.out.println(new Date(0));
        System.out.println(new Date(1));//千分之一秒
    }
}
