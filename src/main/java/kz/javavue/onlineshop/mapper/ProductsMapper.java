package kz.javavue.onlineshop.mapper;

import kz.javavue.onlineshop.model.Category;
import kz.javavue.onlineshop.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductsMapper implements RowMapper<Product> {

    public static String BASE_SQL = "select * from products";

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = Integer.parseInt(rs.getString("product_id"));
        String name = rs.getString("product_name");
        String description = rs.getString("product_description");
        Category category_name = new Category(rs.getString("category_name"));
        return new Product(id, name, description, category_name);
    }
}
