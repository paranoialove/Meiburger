package uuu.meiburger.domain;

/**
 * 繼承範例 overwritting
 *
 * @author MeiMei
 */
public class VIP extends Customer {

    private int discount = 50;

    public VIP() throws MeiException{
    }

    public VIP(String id, String name, String password, String email) throws MeiException {
        //若無無參數建構式，必須依照父類別設定傳入適當的參數傳入父類別建構式。
        super(id, name, password, email);
    }

    public VIP(String id, String name, String password, String email, char gender, int phone) throws MeiException {
        //若無無參數建構式，必須依照父類別設定傳入適當的參數傳入父類別建構式。
        super(id, name, password, email);
        //呼叫此物件的方法
        super.setGender(gender);
        super.setPhone(phone);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int d) {

        if (d >= 0 && d <= 100) {
            this.discount = d;
        } else {
            System.out.println("折扣需在0~100之間");
        }
    }

    @Override
    public String toString() {
        return "VIP{" + super.toString() + "discount = " + discount;
    }

}
