/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.meiburger.domain.BloodType;
import uuu.meiburger.domain.Customer;
import uuu.meiburger.domain.MeiException;

/**
 *
 * @author Administrator
 */
public class TestMySQLJDBC {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/meiburger?zeroDateTimeBehavior=convertToNull";
    private static final String userid = "root";
    private static final String password = "123456789";
    private static final String sql
            = "select * "
            + "from customers ";
            //+ "where id = 'A123456789' And password = '123456'";

    public static void main(String[] args) {

        try {
            //1.import JDBC driver class definition            
            Class.forName(driver);

            try (
                    //2.build DB Connection
                    Connection c = DriverManager.getConnection(url, userid, password);
                    //3.建立指定物件
                    Statement stmt = c.createStatement();
                    //4.執行指令
                    ResultSet rs = stmt.executeQuery(sql);) {  //7.0版本開始支援，如果沒辦法跑就是關閉

                System.out.println(c.getCatalog());

                //5.處理ResultSet
                while(rs.next()){   //從起點(ResultSet)的下一筆就是第一筆資料
                    try {
                        Customer cust  = new Customer();
                        cust.setId(rs.getString("id"));  //也可以用索引值**不建議
                        cust.setName(rs.getString("name"));
                        cust.setPassword(rs.getString("password"));
                        cust.setGender(rs.getString("gender").charAt(0));
                        cust.setEmail(rs.getString("email"));
                        cust.setBirthday(rs.getDate("birthday"));
                        cust.setPhone(rs.getInt("phone"));
                        cust.setAddress(rs.getString("address"));
//                        cust.setMarried(rs.getBoolean("married"));
                        
//                        String bType = rs.getString("blood_type");
//                        if(bType!=null && (bType = bType.trim()).length()>0){   //非null或空字串
//                            cust.setBloodType(BloodType.valueOf(bType));   //valueOf()無法接受null資料，須判斷後再丟進去
//                        }
                        System.out.println(cust.toString());
                        
                    } catch (MeiException ex) {
                        System.out.println(ex);
                    }
                    
                }
                
                //c.close();
            } catch (SQLException ex) {
                Logger.getLogger(TestMySQLJDBC.class.getName()).log(Level.SEVERE, "連線必要資訊錯誤", ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestMySQLJDBC.class.getName()).log(Level.SEVERE, "無法載入JDBC Driver：" + driver, ex);
        }

    }
}
