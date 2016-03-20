/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.meiburger.domain.Customer;
import uuu.meiburger.model.CustomerService;


/**
 *
 * @author Administrator
 */
public class TestRDBCustomersDAO {

    public static void main(String[] args) {
        try {
            CustomerService dao = new CustomerService();
            
            //新增客戶
//            Customer c1 = new Customer();
//            c1.setId("");
//            c1.setName("");
//            c1.setGender(Customer.MALE);
//            c1.setPassword("");
//            c1.setEmail("");
//            dao.register(c1);
            

            //修改更新客戶
//            Customer c1 = dao.get("A123456789");
//            c1.setAddress("台中市");
//            dao.update(c1);
//           
            //刪除客戶
            Customer c2 = dao.get("A181368579");
            dao.delete(c2);
            
            Customer c3 = dao.get("A181368579");
            System.out.println(c3);
            
//            
//            CustomerService service = new CustomerService();
//            /**查詢單筆資料*/
//            Customer c = service.get("A123456789");            
//            System.out.println("id查詢結果：" +c);
//            
//            /**查詢全部結果*/
//            List<Customer> list = service.getAll();
//            //每筆換行印出
//            for(int i = 0; i < list.size() ; i++){
//                System.out.println(list.get(i));
//            }

        } catch (Exception ex) {
            System.out.println("測試失敗"+ ex);
            if(ex.getCause()!=null)
            {
                System.out.println("原因：" + ex.getCause());
            }
            //Logger.getLogger(TestRDBCustomersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
