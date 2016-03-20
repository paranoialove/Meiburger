package uuu.meiburger.domain;

public class Category {

    private int id;

    private String name;

    private String explanation;

    //private Ingredient Ingredient;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
     * @return the explanation
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * @param explanation the explanation to set
     */
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

//    /**
//     * @return the product
//     */
//    public Ingredient getProduct() {
//        return Ingredient;
//    }
//
//    /**
//     * @param Ingredient the product to set
//     */
//    public void setProduct(Ingredient Ingredient) {
//        this.Ingredient = Ingredient;
//    }
}
