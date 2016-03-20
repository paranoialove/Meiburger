/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.domain;

/**
 *
 * @author Administrator
 */
public enum BloodType {
    //列舉型別背後已建立物件  可以順便傳入參數，可以應用建構子輸入想要用的值。
    O(0), A(10), B(20), AB(30);
    
    private final int code;  //國際代碼
    private BloodType(int code){ 
        this.code= code;
    }

    @Override    
    public String toString(){
        return super.toString() + "型";
    }

    public int getCode() { 
        return code;
    }



}