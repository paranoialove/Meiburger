/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.meiburger.domain.BloodType;
import uuu.meiburger.domain.Customer;
import uuu.meiburger.domain.MeiException;
import uuu.meiburger.domain.VIP;
import uuu.meiburger.test.TestMySQLJDBC;

/**
 *
 * @author Administrator
 */
class RDBCustomersDAO {

    private static final String INSERT_SQL = "INSERT INTO customers "
            + "(id, name, gender, password, email, birthday, phone, address)  "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_SQL = "UPDATE customers "
            + "SET name=?, gender=?, password=?, email=?, birthday=?, phone=?, address=?, type=?, discount=? "
            + "WHERE id=?";

    private static final String DELETE_SQL = "DELETE FROM customers WHERE id=?";

    private static final String sqlAll
            = "select * "
            + "from customers ";
    private static final String sql
            = sqlAll + "where id = ?";    //*And password = '123456'";

    public void insert(Customer c) throws MeiException {
        if (c == null) {
            throw new MeiException("客戶資料為空，無法新增。");
        }
        //１。載入Driver並建立連線
        try (Connection connection = RDBConnection.getConnection();
                //２。準備指令
                PreparedStatement psmt = connection.prepareStatement(INSERT_SQL);) {

            //３。傳入參數
            //id, name, gender, password, email, birthday, phone, address, married, blood_type
            psmt.setString(1, c.getId());
            psmt.setString(2, c.getName());
            psmt.setString(3, String.valueOf(c.getGender()));
            psmt.setString(4, c.getPassword());
            psmt.setString(5, c.getEmail());
            psmt.setDate(6, c.getBirthday() != null ? new java.sql.Date(c.getBirthday().getTime()) : null);
            psmt.setInt(7, c.getPhone());
            psmt.setString(8, c.getAddress());

            //psmt.setString(0, c.getClass().getSimpleName()); //找VIP
            //psmt.setInt(0, c instanceof VIP?((VIP)c).getDiscount():0);  //折扣
            //４。執行指令
            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("新增客戶失敗" + c + "發生" + e);
            throw new MeiException("新增客戶失敗：" + c, e);
        }

    }

    public void update(Customer c) throws MeiException {
        if (c == null) {
            throw new MeiException("無此客戶，無法修改");
        }
        //１。載入Driver並建立連線
        try (Connection connection = RDBConnection.getConnection();
                //２。準備指令
                PreparedStatement psmt = connection.prepareStatement(UPDATE_SQL);) {

            //３。傳入參數
            //id, name, gender, password, email, birthday, phone, address, married, blood_type
            psmt.setString(1, c.getName());
            psmt.setString(2, String.valueOf(c.getGender()));
            psmt.setString(3, c.getPassword());
            psmt.setString(4, c.getEmail());
            psmt.setDate(5, c.getBirthday() != null ? new java.sql.Date(c.getBirthday().getTime()) : null);
            psmt.setInt(6, c.getPhone());
            psmt.setString(7, c.getAddress());
            psmt.setString(8, c.getClass().getSimpleName()); //找VIP
            psmt.setInt(9, c instanceof VIP ? ((VIP) c).getDiscount() : 0);  //折扣
            psmt.setString(10, c.getId());

            //４。執行指令
            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("修改客戶失敗" + c + "發生" + e);
            throw new MeiException("修改客戶失敗：" + c, e);
        }
    }

    public void delete(Customer c) throws MeiException {
        if (c == null) {
            throw new MeiException("無此客戶，無法刪除");
        }
        //１。載入Driver並建立連線
        try (Connection connection = RDBConnection.getConnection();
                //２。準備指令
                PreparedStatement psmt = connection.prepareStatement(DELETE_SQL);) {

            //３。傳入參數
            psmt.setString(1, c.getId());

            //４。執行指令
            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("刪除客戶失敗" + c + "發生" + e);
            throw new MeiException("刪除客戶失敗：" + c, e);
        }
    }

    private Customer createCustomer(String id, String name, String password, String email, String t) {
        Customer cust;
        if ("VIP".equals(t)) {
            cust = new VIP();
        } else {
            try {
                cust = new Customer(id, name, password, email);
            } catch (MeiException ex) {
                Logger.getLogger(RDBCustomersDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return cust;
    }

    public Customer get(String id) throws MeiException {
        Customer cust;
        /**
         * ================【步驟1.】 ========================= ＞import JDBC driver
         * class definition ＞在RDBConnection載入driver了。 在下面~~~~
         * ====================================================*
         */
        try (
                /**
                 * ===============【步驟2.】=========================== ＞build DB
                 * Connection ＞使用自己的RDBConnection class 中的 getConnection() 建立連線
                 * =====================================================*
                 */
                Connection c = RDBConnection.getConnection();
                /**
                 * ===============【步驟3.】 =========================== ＞建立指定物件
                 * ＞1.7版本開始支援，如果沒辦法跑就是關閉
                 * =====================================================*
                 */
                PreparedStatement stmt = c.prepareStatement(sql);) {
            System.out.println(c.getCatalog());

            //===3.2 指定第一個問號的值=================================
            stmt.setString(1, id);

            //===4.執行指令  ==========================================
            try (ResultSet rs = stmt.executeQuery();) {
                //===5.處理ResultSet=======================================
                while (rs.next()) {   //從起點(ResultSet)的下一筆就是第一筆資料
                    try {
                        String t = rs.getString("type");
                        cust = this.createCustomer(t);

                        if (cust instanceof VIP) {
                            ((VIP) cust).setDiscount(rs.getInt("discount"));
                        }

                        cust.setId(rs.getString("id"));  //也可以用索引值**不建議
                        cust.setName(rs.getString("name"));
                        cust.setPassword(rs.getString("password"));
                        cust.setGender(rs.getString("gender").charAt(0));
                        cust.setEmail(rs.getString("email"));
                        cust.setBirthday(rs.getDate("birthday"));
                        cust.setPhone(rs.getInt("phone"));
                        cust.setAddress(rs.getString("address"));
                    } catch (MeiException ex) {
                        System.out.println(ex);
                        throw new MeiException("查詢客戶建立指派客戶物件資料失敗", ex);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestMySQLJDBC.class.getName()).log(Level.SEVERE, "連線必要資訊錯誤", ex);
            throw new MeiException("無法查詢客戶", ex);

        }

//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(TestMySQLJDBC.class.getName()).log(Level.SEVERE, "無法載入JDBC Driver：" + driver, ex);
//            throw new MeiException("無法載入JDBC Driver：" + driver, ex);
//        }
        return cust;
    }

    public List<Customer> getAll() throws MeiException {
        //List<> 為泛型(集合)
        List<Customer> customers = new ArrayList<>();

        //JDBC 查詢Customer的所有資料
        try (
                //2.build DB Connection
                Connection c = RDBConnection.getConnection();
                //3.建立指定物件
                PreparedStatement stmt = c.prepareStatement(sqlAll);) {  //7.0版本開始支援，如果沒辦法跑就是關閉
            //3.2 指定第一個問號的值
            //stmt.setString(1, id);
            //System.out.println(c.getCatalog());
            //4.執行指令
            try (ResultSet rs = stmt.executeQuery();) {
                //5.處理ResultSet
                while (rs.next()) {   //從起點(ResultSet)的下一筆就是第一筆資料
                    try {
                        String t = rs.getString("type");
                        Customer cust = this.createCustomer(t);
                        if (cust instanceof VIP) {
                            ((VIP) cust).setDiscount(rs.getInt("discount"));
                        }
                        cust.setId(rs.getString("id"));
                        cust.setName(rs.getString("name"));
                        cust.setPassword(rs.getString("password"));
                        cust.setGender(rs.getString("gender").charAt(0));
                        cust.setEmail(rs.getString("email"));
                        cust.setBirthday(rs.getDate("birthday"));
                        cust.setPhone(rs.getInt("phone"));
                        cust.setAddress(rs.getString("address"));

                        System.out.println("cust:" + cust);
                        customers.add(cust);
                    } catch (MeiException ex) {
                        System.out.println(ex);
                        throw new MeiException("查詢客戶建立指派客戶物件資料失敗", ex);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestMySQLJDBC.class.getName()).log(Level.SEVERE, "連線必要資訊錯誤", ex);
            throw new MeiException("無法查詢客戶", ex);
        }

        return customers;
    }
}
