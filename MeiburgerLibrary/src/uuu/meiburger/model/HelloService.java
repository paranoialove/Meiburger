package uuu.meiburger.model;//最多只能一行 一定要檔案開始就宣告

import uuu.meiburger.domain.Customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MeiMei
 */
public class HelloService {

    /**
     * 多載overloading 允許同名：對應參數個數不同/參數個數相同 資料型別不同 不允許：型別相同名稱不同 放在想要註解的方法前面
     * 可使用ctrl \ 查看
     *
     * @param name 為姓名
     * @return 哈囉 name
     */
    public String sayHello(String name) {
        //String helloMsg = "哈囉，" + name;        
        String helloMsg = sayHello() + "，" + name;
        //可以call自己本身方法執行。
        return helloMsg;
    }
    //public String sayHello(String a){
    //    return "a";
    //}

    public String sayHello(Customer c) {
        //String helloMsg = "哈囉，" + c.name;
        String helloMsg = sayHello(c.getName());
        return helloMsg;
    }

    public String sayHello() {
        return "哈囉！";

    }

}
