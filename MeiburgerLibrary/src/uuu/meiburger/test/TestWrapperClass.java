/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

/**
 * 包裝類別範例
 *
 * @author MeiMei
 */
public class TestWrapperClass {

    public static void main(String[] args) {

        int i = 1;
        Integer i1 = new Integer(i);

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        byte b = 2;
        Byte b1 = new Byte(b); //boxing

        int j = i1.intValue() + b1.byteValue(); //unboxing 兩次
        Integer j1 = new Integer(j);

        boolean isOpened = true;
        Boolean b3 = new Boolean(isOpened);

        //---------^^^jdk5以前做法，以下為之後版本之做法。---------------//
        int x = 1;
        Integer x1 = x; //auto boxing     等於   Integer i1= new Integer(i);
        System.out.println(x1.getClass().getName());

        byte y = 3; //autoboxing
        Byte y1 = y;
        
        int z = x1 + y1; //auto unboxing 兩次
        
        Integer o1 = 1;
        Integer o2 = o1;
        
        System.out.println(o1 == o2); //true
        
        o2 = o1 + 1; //o2 = new Integer(o1.invalue()+1)  系統自動unboxing又自動boxing        
        System.out.println(o1 == o2); 
        System.out.println(o2);
        System.out.println(o1);
        
        
    }
}
