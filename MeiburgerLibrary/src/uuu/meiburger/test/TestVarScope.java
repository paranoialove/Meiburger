package uuu.meiburger.test;

/**
 * @author MeiMei
 */
public class TestVarScope {

    int i;

    /* 成員變數member variable(屬性Attribute、欄位field)
     * 類別中只能宣告，不可指派
     * 只需宣告必要屬性，以避免消耗多餘記憶體
     * 因為建立起此類別物件是整個包含成員變數一同建立的
     * 可於宣告時一同指派初值，不給值VM會預給一系統初值。
     * 修飾子：
     * public/protected/private
     * static
     * final
     */
    public static void main(String[] args) {
        int i;
        /* 區域變數Local Variable
         * 使用前須給初值
         * 只能在放置的方法內使用
         * 修飾子：final>>常數        
         */
        System.out.println("i = " + (i = 1)); //可於使用時給值但不建議

    }
}
