package uuu.meiburger.model;

import java.util.List;
import uuu.meiburger.domain.Customer;
import uuu.meiburger.domain.MeiException;

public class CustomerService {
    private RDBCustomersDAO dao = new RDBCustomersDAO();

    public Customer login(String id, String password) throws MeiException{
        //帳號為空、帳號長度為0、密碼長度為0
        if(id  == null || ((id = id.trim()).length() == 0 || (password = password.trim()).length() == 0)){
            throw new MeiException("必須輸入帳號密碼!");
        }
        Customer c = dao.get(id);
        //id查詢結果找不到一致的、密碼不一致
        if(c!=null && password.equals(c.getPassword())){
            return c;
        }
        throw new MeiException("帳號密碼不正確，登入失敗！");
    }

    public void register(Customer c) throws MeiException {
        dao.insert(c);
    }

    public void update(Customer c) throws MeiException {
        dao.update(c);
    }

    public void delete(Customer c) throws MeiException {
        dao.delete(c);
    }

    public Customer get(String id) throws MeiException {
        return dao.get(id);
    }

    public List<Customer> getAll() throws MeiException {
        return dao.getAll();
    }
    

    

}
