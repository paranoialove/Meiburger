/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.domain;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class ShippingInfo {

    private int ShippingId;
    private Date ShippingDate;
    private Boolean ShippingAvailable;

    //建構式
    public ShippingInfo() {
    }

    public ShippingInfo(int ShippingId, Date ShippingDate, Boolean ShippingAvailable) {
        this.setShippingId(ShippingId);
        this.setShippingDate(ShippingDate);
        this.setShippingAvailable(ShippingAvailable);
    }

    public int getShippingId() {
        return ShippingId;
    }

    public void setShippingId(int ShippingId) {
        this.ShippingId = ShippingId;
    }

    public Date getShippingDate() {
        return ShippingDate;
    }

    public void setShippingDate(Date ShippingDate) {
        this.ShippingDate = ShippingDate;
    }

    public Boolean getShippingAvailable() {
        return ShippingAvailable;
    }

    public void setShippingAvailable(Boolean ShippingAvailable) {
        String table = "DateMax";
        Date date;  //選擇之日期
        int maxorder = 0;
        String maxsql = "SELECT max FROM DateMax WHERE Date = date ;";
        String INSERT_MAX_SQL = "INSERT INTO DateMax (Date,Max) VALUES(?,?) ;";

//        1.選擇日期
//        2.將選擇日期回傳查詢DateMax table
//        3.得到該日期之max欄位之值
        //-----maxorder = (int)查詢結果 ;-----------------------------
//        4.1如果回傳之max欄位值為null  
//           如果回傳之max欄位值不為null且小於10
        if (maxorder < 10 && maxorder > 0 ){
            maxorder++;
            //------insert(INSERT_MAX_SQL);--------
            //html控制項選擇顯示OK可選;
        } else {
            //html控制項選擇顯示NO不可選
        }

        this.ShippingAvailable = ShippingAvailable;
    }

}
