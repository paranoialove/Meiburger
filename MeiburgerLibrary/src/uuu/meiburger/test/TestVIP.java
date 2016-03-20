/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.meiburger.domain.MeiException;
import uuu.meiburger.domain.VIP;

/**
 * 繼承範例
 *
 * @author MeiMei
 */
public class TestVIP {

    public static void main(String[] args) {
        try {
            VIP v = new VIP();
            v.setId("A123456789");
            System.out.println("v.getId() = " + v.getId());
            
            System.out.println("v.getDiscount() = " + v.getDiscount());
        } catch (MeiException ex) {
            Logger.getLogger(TestVIP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
