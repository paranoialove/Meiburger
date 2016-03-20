/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * 
 */
package uuu.meiburger.test;

/**
 *
 * @author Administrator
 */
public class Test99 {

    public static void main(String[] args) {
        outer_loop://Lable name 
        for (int i = 1; i < 10; i++) {
            inner_loop:
            for (int j = 1; j < 10; j++) {
                System.out.print(i + "*" + j + "=" + (i * j) + ",\t");
                //如果j==i  直接換行跳出迴圈
                //效果等於for(int j = 1; j <= i ; j++)
                if (j == i) {
                    //break;
                    break inner_loop;//跳出Lable name的範圍
                }
            }
            System.out.println(" ");

        }
        System.out.println("THE END");
        M_loop:
        for (int k = 1; k < 10; k++) {
            for (int p = 1; p < 10; p++) {
                System.out.print(k + "*" + p + "=" + (k * p) + ",\t");
                //如果j==i  直接換行跳出迴圈
                //效果等於for(int j = 1; j <= i ; j++)
                if (k == p) {
                    System.out.println(" ");
                    continue M_loop;
                }
            }
        }
        System.out.println("THE END");

        //continue、while  dowhile範例
        int y = 1;
        while (y < 10) {
            if (y == 3 || y == 8 || y == 9) {
                y++;
                continue;
            }
            System.out.println("y = " + y++);
        }
        do {
            System.out.println("y = " + y++);
        } while (y < 10);

    }

}
