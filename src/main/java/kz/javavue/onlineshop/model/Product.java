package kz.javavue.onlineshop.model;

public class Product {
    private int product_id;
    private String product_name;
    private String product_description;
    private Category category_name;

    public Product(int product_id, String product_name, String product_description, Category category_name) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.category_name = category_name;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public void setCategory_name(Category category_name) {
        this.category_name = category_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public Category getCategory_name() {
        return category_name;
    }
}
