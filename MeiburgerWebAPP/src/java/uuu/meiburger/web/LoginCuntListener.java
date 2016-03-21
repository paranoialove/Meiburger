/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.meiburger.web;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author Administrator
 */
public class LoginCuntListener implements ServletContextListener, HttpSessionListener {
    //※測試步驟※  
        /*Run (觸發contextInitialized) 一開始沒有properties檔案，出現檔案找不到錯誤訊息) → 
          登入(觸發counter) 此時Servlet Context並沒有app.login.count，所以在創建時，值為null→ 
          stop(觸發contextDestroyed)，此時計數人次將寫入counter.properties，路徑為build/web/WEB-INF/counter.properties →
          start(觸發contextInitialized)，此時存放於counter.properties的計數人次，將會被讀出存放於Servlet Context記憶體裡→
          登入 (觸發counter) 從Servlet Context中得到上回的計數人次*/
    //附註:
    /*
    ※藉由Output查看是否有成功被觸發
    ※Runflow(build Project→start server(optional)→undeploy old Project(optional)→deploy Project→
          Open Browser → send Home URL request)
    ※clean 會清除掉build資料夾，因此properties檔案也會被刪除掉*/
    @Override //應用程式啟動事件
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Tripfootprints app start......");
        

        //1、取得context記憶體 並建立一個properties
        ServletContext application = sce.getServletContext();
        Properties props = new Properties();

        //2、設定目標路徑並得到其真實路徑
        String path = application.getRealPath("/WEB-INF/counter.properties");

        //3、將舊有的properties 讀回來
        try (FileReader in = new FileReader(path);) {
            props.load(in);
            application.log("counters讀檔成功:" + path);
            Enumeration<?> names = props.propertyNames(); //propertyNames其回傳型別為 Enumeraion<?>
            
        //4、抓出需要的資料 
            while (names.hasMoreElements()) {
                String name = (String) names.nextElement(); 
                if (name.indexOf("app.") == 0) {   //搜尋這一筆資料有無字串"app." ，有回傳0，否則回傳-1
                    Integer value =Integer.valueOf(props.getProperty(name));
                    //getProperty回傳型別為String ,轉型為適合的型別Integer (計數人次count的型別) 否則LoginServlet將會出現(轉型Exception) 
                    System.out.println(name + ":" + value);
                    application.setAttribute(name, value); //將數值丟到servlet context記憶體裡，LoginServet將從這撈出count值
                }
            }
        } catch (FileNotFoundException ex){   //RunFile時，build資料夾被clean掉，就沒有counter.properties。會有讀檔錯誤訊息! 
            System.out.println("路徑中找不到檔案!" + path);
            application.log("路徑中找不到檔案" + path, ex);
        } catch (IOException ex) {
            System.out.println("無法讀取檔案:" + path);
            application.log("無法讀取檔案:" + path, ex);
        }
    }

    @Override //應用程式結束事件
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Tripfootprints app stop......");
        //1、取得context記憶體
        ServletContext application = sce.getServletContext();

        //2、得到context記憶體裡面所有Attribute name    ※(指標: cursor , iterator , "enumeration")
        Enumeration<String> names = application.getAttributeNames();

        //3、讀資料前建立一個空的properties
        Properties props = new Properties();

        //4、開始讀取並將目標Attribute的name & value寫入properties
        while (names.hasMoreElements()) {
            String name = names.nextElement(); 
            if (name.indexOf("app.") == 0) {   //如果裡面字串有"app."的attribute將會回傳0 否則-1
                Object value = application.getAttribute(name);   //使用名字抓到其對應的值
                System.out.println(name + ":" + value);
                props.setProperty(name, value.toString());
            }
        }

        //5、將properties 存到目標路徑
        String path = application.getRealPath("/WEB-INF/counter.properties");   //取得web_server下  /WEB-INF 的路徑 
        //FileOutputStream 位元檔    FileWriter文字檔
        //使用外部資源都要使用try catch錯 ，避免如空間太小無法存取等錯誤
        try (FileWriter out = new FileWriter(path);) {  //必須放在try with resource中 沒有關掉此行 將會clean錯誤(因為無法刪除build)
            //由於資安問題，避免不正當的set 所以servlet_context大部分只有get add ;
            props.store(out, "no commnets");
            application.log("counters存檔成功:" + path);
        } catch (IOException ex) {
            System.out.println("無法存檔" + path);
            application.log("無法存檔:" + path, ex);
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
