package uuu.meiburger.domain;

import java.util.Date;

public class Product {

    private int id;
    private String name;
    private double uniPrice;
    private boolean free;
    private int stock;
    private String description;
    private String url;
    private int status;
    private Date addedDate;
    private Category category = new Category();

    //Constructors
    public Product() {
    }

    public Product(int id, String name, double uniprice) {
        this.id = id;
        this.name = name;
        this.uniPrice = uniprice;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the uniPrice
     */
    public double getPrice() {
        return uniPrice;
    }

    /**
     * @param uniPrice the uniPrice to set
     */
    public void setPrice(int uniPrice) {
        this.uniPrice = uniPrice;
    }

    /**
     * @return the free
     */
    public boolean isFree() {
        return free;
    }

    /**
     * @param free the free to set
     */
    public void setFree(boolean free) {
        this.free = free;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
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

    /**
     * @return the addedDate
     */
    public Date getAddedDate() {
        return addedDate;
    }

    /**
     * @param addedDate the addedDate to set
     */
    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "id=" + id + ", name=" + name + ", uniPrice=" + uniPrice + ", free=" + free + ", stock=" + stock + ", description=" + description + ", url=" + url + ", status=" + status + ", addedDate=" + addedDate + ", category=" + category + '}';
    }

    @Override
    /**
     * 複製產品
     */
    public Product clone() {
        Product newThis = new Product();
        newThis.id = this.id;
        newThis.name = this.name;
        newThis.uniPrice = this.uniPrice;
        newThis.description = this.description;
        newThis.url = this.url;
        return newThis;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //to change body of generated methods, choose tools | templates.
        //System.out.println(toString() + "finalize.....");
    }

//    @Override
//    public boolean equals(Object obj){
//        if(this == obj) return true;
//        if(obj == null) return false;
//        
//        /*if (obj instanceof Ingredient){     
//         *此行與下行差別可從TestIngredientClone.java  行29：System.out.println(o1.equals(p1));看出差別。*/
//        if(this.getClass() == obj.getClass()){  
//        //取得類別名稱判別：前者之類別是否相容於後者之類別。
//            Ingredient p = (Ingredient)obj;            
//            if(p.id == this.id && p.name != null &&  p.name.equals(this.name)){
//                //
//                return true;
//            }
//        }
//        return false;
//    }
//    @Override
//    public int hashCode(){
//        int code = 0;
//        
//        code = this.id + this.name.hashCode() + (int)Math.round(uniPrice);
//        //code = this.id + this.name.hashCode() + new Double(uniPrice).hashCode);
//
//        
//        return code;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
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
        final Product other = (Product) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
 

}
