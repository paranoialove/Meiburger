/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.meiburger.domain.MeiException;

/**
 *
 * @author Administrator
 */
public class RDBConnection {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/meiburger?zeroDateTimeBehavior=convertToNull";
    private static final String userid = "root";
    private static final String password = "123456789";

    public static Connection getConnection() throws MeiException {
        Connection c = null;
        //步驟：１。載入driver     >>  ２。建立連線(帳號密碼)        
        try {
            //1載入JDBC driver
            Class.forName(driver);

            //2. 建立連線
            try {
                c = DriverManager.getConnection(url, userid, password);
                return c;
            } catch (SQLException ex) {
                System.out.println("無法建立連線");
                throw new MeiException("無法建立JDBC連線", ex);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("無法載入JDBC Driver！" + driver);
            Logger.getLogger(RDBConnection.class.getName()).log(Level.SEVERE, "無法載入JDBC Driver：", ex);
            throw new MeiException("無法載入JDBC Driver！" + driver, ex);
        }

    }
}
