package uuu.meiburger.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 使用封裝encapsulate netbeans Refactor>Encapsulate Fields
 *
 * @author Meimei
 */
public class Customer {

    public static final char MALE = 'M';
    public static final char FEMALE = 'F';
    /**
     * * id 為必要欄位，且符合ROC id規則
     */
    private String id;

    /**
     * * name 為必要欄位
     */
    private String name;

    /**
     * * gender為非必要欄位，M：Male F：Female
     */
    private char gender;

    /**
     * * 密碼為必要欄位 長度限制6~20
     */
    private String password;

    /**
     * * email為必要欄位
     */
    private String email;

    private Date birthday; //需import java.util.Date

    //public Sting phone;
    //public String address;
    //同修飾子同型可以一起宣告，但不建議。
    private int phone;
    private String address;
    private String type;
    private int status = 0;//0新客戶

    //建構子 可使用ctrl \查看型別設定
    //方便測試資料使用
    //若無撰寫，系統將會生成一個空參數之建構式
    //可用多載
    //建構式在外使用只能用來 new 新物件
    //建構式內部可以使用方法
//    public Customer() {  //提供無參數建構式於此不合理。
//    }
    public Customer(String id, String name, String password, String email) throws MeiException {
        //須檢查參數是否格式內容正確
        //使用setXX()內之檢查式檢查。
        //this.id = id; 使用ALT+insert 建立建構式之預設內容，未檢查直接指派
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
        this.setEmail(email);
    }

    public Customer(String id, String name, String password, String email, char gender, int phone) throws MeiException {
        //建構式只可以自己call自己的建構式
        //如需要必須優先敘述
        this(id, name, password, email);
        //呼叫此物件的方法
        this.setGender(gender);
        this.setPhone(phone);
    }

    /*getter讀取專用 public 相容屬性 getXX(無參數)
         * 必有return 值;
     */
    public String getId() {
        return id;
    }

    /**
     * setter寫入專用 public void setXX(相容參數) 必有指派 ex. this.XX = XX ;
     *
     * @param value
     * @throws uuu.meiburger.domain.MeiException
     */
    public void setId(String value) throws MeiException {
        if (checkId(value)) {
            id = value;
        } else {
            System.out.println("id不正確");
            throw new MeiException("ID不正確");//程式中只能叫JVM拋出unchecked Exception Ch13  13-15 自己自訂一個錯誤訊息
        }
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) throws MeiException {
        if (gender == MALE || gender == FEMALE) {
            this.gender = gender;
        } else {
            System.out.println("性別資料不正確:必須" + MALE + "(男性)/" + FEMALE + "(女性)");
            throw new MeiException("性別資料不正確:必須" + MALE + "(男性)/" + FEMALE + "(女性)");
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     * @throws uuu.meiburger.domain.MeiException
     */
    public void setName(String name) throws MeiException {
        //name 不等於null 且 去完空格的name長度要大於0
        //括號很重要!!!
        if (name != null && (name = name.trim()).length() > 0) {
            this.name = name;
        } else {
            System.out.println("我很想知道你的名字呢！");
            throw new MeiException("我很想知道你的名字呢！");
        }
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     * @throws uuu.meiburger.domain.MeiException
     */
    public void setPassword(String password) throws MeiException {
        if (password != null && (password = password.trim()).length() >= 6 && password.length() <= 20) {
            this.password = password;
        } else {
            System.out.println("密碼為必要欄位，且長度應在6~20內");
            throw new MeiException("密碼為必要欄位，且長度應在6~20內");

        }
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     * @throws uuu.meiburger.domain.MeiException
     */
    public void setEmail(String email) throws MeiException {
        if (email != null && (email = email.trim()).matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            this.email = email;
        } else {
            System.out.println("email為必要欄位，且格式不正確");
            throw new MeiException("email為必要欄位，且格式不正確");
        }
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set ch.8
     */
    public void setBirthday(Date birthday) throws MeiException {
        //判斷有無空值與限制早於今天以前
        if (birthday != null && birthday.before(new Date())) {
            this.birthday = birthday;
        } else {
            if (birthday == null) {
                this.birthday = null;
            }
            System.out.println("天氣該早於今天以前");
            throw new MeiException("天氣該早於今天以前");
        }
    }

    public void setBirthday(int year, int month, int date) throws MeiException {
        //直接使用數值使用萬年曆抓取日期
        Date d = new GregorianCalendar(year, month - 1, date).getTime();
        this.setBirthday(d);
    }

    //overloading method
    //網站顯示相關，使用字串型別
    public void setBirthday(String date) throws MeiException {
        if (date == null || (date = date.trim()).length() == 0) {
            this.birthday = null;
            return;
        }
        try { //date須拋出例外狀況(函式庫內的DateFormat例外錯誤)
            //DateFormat df = DateFormat.getDateInstance();  //抓取OS時間格式

            date = date.replace('-', '/');
            DateFormat df = new SimpleDateFormat("yyyy/M/d");  //自訂日期格式 yyyy/M/d  大小寫有別，請查閱jdk javadoc
            Date d = df.parse(date);
            this.setBirthday(d);//回傳再判斷日期是否早於今天
        } catch (ParseException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, "日期格式不正確", ex);
            throw new MeiException("日期格式不正確", ex); //除了判斷例外狀況try catch，還須將錯誤拋出
        }
    }

    /**
     * @return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(int phone) {
        if (phone != 0 && phone > 0) {
            this.phone = phone;
        } else {
            this.phone = 0;
        }
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        if (address != null && (address = address.trim()).length() > 0) {
            this.address = address;
        } else {
            this.address = null;
        }
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    //自訂運算式
    public int getAge() {
        if (this.birthday == null) {
            return 0;
        }

        Calendar c = Calendar.getInstance();
        int thisYear = c.get(Calendar.YEAR);//抓今年的年分(西元)
        System.out.println("thisYear = " + thisYear);

        c.setTime(this.birthday); //抓到生日的年分
        int birthYear = c.get(Calendar.YEAR);
        System.out.println("birthYear = " + birthYear);
        return thisYear - birthYear;
    }

    public final static String idPattern = "[A-Z]{1}[1-2]{1}[0-9]{8}";

    public static boolean checkId(String idValue) {
        if (idValue == null) {
            return false;
        }
        idValue = idValue.trim();
        idValue = idValue.toUpperCase();

        /**
         * 正規演算式regular expression java認證第二階段考試範圍 ex.
         * 識別子.matches("[A-Z][1-2][0-9]{8}$") [] >一個字元 連續的範圍：[A-Z] 連需幾個字元：{n}
         * 錨點$ 到此錨點之前的規則一定要遵守
         */
        if (idValue.matches(idPattern) && idValue.length() == 10) {

            //2、3步驟交由getLastCharFormId()處理
            char lastChar = getLastCharFormId(idValue.substring(0, 9)); //使用substring(起始點 結束點) ex.前九碼 (0,9)

            //4.將總和mod 10餘數為0：正確
            //return (sum % 10 == 0);
            //System.out.println("lastChar = " + lastChar);
            return (lastChar == idValue.charAt(9));
        }
        return false;
    }

    public static char getLastCharFormId(String id9) {
        //2.將第一個英文字轉成對應數字
        char firstChar = id9.charAt(0);
        int firstNumber = 0;
        if (firstChar >= 'A' && firstChar <= 'H') {
            firstNumber = firstChar - 'A' + 10;//A~H   10~17
        } else if (firstChar >= 'J' && firstChar <= 'N') {
            firstNumber = firstChar - 'J' + 18;//J~N   18~22
        } else if (firstChar >= 'P' && firstChar <= 'V') {
            firstNumber = firstChar - 'P' + 23;//P~V   23~29
        } else {  //I=34 W=32  X=30 Y=31 Z=33
            switch (firstChar) {
                case 'I':
                    firstNumber = 34;
                    break;
                case 'W':
                    firstNumber = 32;
                    break;
                case 'X':
                    firstNumber = 30;
                    break;
                case 'Y':
                    firstNumber = 31;
                    break;
                case 'Z':
                    firstNumber = 33;
                    break;//完成後直接跳到此判斷式結尾
                default:
                    System.out.print("身分證號不正確");
                    assert false : "身分證號首碼不正確" + firstChar;  //到此為  錯誤:狀況訊息
                //直接結束程式。
                }
        }
        assert (firstNumber >= 10 && firstNumber <= 35) : "firstNumber" + firstNumber;
        //3.依據菇則加總
        int sum = (firstNumber / 10) + (firstNumber % 10) * 9;
        for (int i = 1; i <= 8; i++) {
            sum = sum + (id9.charAt(i) - '0') * (9 - i);
        }
        //sum = sum + (id9.charAt(9) - '0') * 1;
        char lastChar = (char) ((10 - (sum % 10)) % 10 + '0');
        //此字元如為 sum%10 時，就不需要-'0'   9的下一個字碼是 ':'   會有錯誤
        //10-(sum%10)  須加上%10，就不會抓到':'
        assert (lastChar >= '0' && lastChar <= '9') : "身分證末碼不正確" + "(" + lastChar + ")"; //正確情況:錯誤訊息
        return lastChar;
    }

    @Override
    //object中，toString函式的overriding非常頻繁使用
    //如 物件.toString() 將會回傳類別名稱與記憶體所在位置

    //@Override
    public String toString() {
        return "顧客資料{" + "id=" + id + "\t name=" + name + "\t gender=" + gender
                + "\t password=" + password + "\t email=" + email + "\t birthday=" + birthday
                + "\t phone=" + phone + "\t address=" + address
                + "\t status=" + status + "\t type:" + type + '}';
    }

    void test() {
        System.out.println("test");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 19 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }

}
