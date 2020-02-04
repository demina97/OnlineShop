package kz.javavue.onlineshop.model;

public class Category {
    private String CategoryName;

    public Category(String categoryName) {
        CategoryName = categoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryName() {
        return CategoryName;
    }
}
