package uuu.meiburger.domain;

/**
 * 繼承範例 overwritting
 *
 * @author MeiMei
 */
public class VIP extends Customer {

    private int discount = 50;

    public VIP() {
    }

    public VIP(String id, String name, String password) throws MeiException {
        //若無無參數建構式，必須依照父類別設定傳入適當的參數傳入父類別建構式。
        super(id, name, password);
    }

    public VIP(String id, String name, char gender, String password, String email) throws MeiException {
        //若無無參數建構式，必須依照父類別設定傳入適當的參數傳入父類別建構式。
        super(id, name, gender, password, email);
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
