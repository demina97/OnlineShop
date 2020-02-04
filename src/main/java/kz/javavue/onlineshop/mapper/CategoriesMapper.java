package kz.javavue.onlineshop.mapper;

import kz.javavue.onlineshop.model.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CategoriesMapper implements RowMapper<Category> {

    public static final String BASE_SQL = "select * from categories;";

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        String category = rs.getString("category_name");
        return new Category(category);
    }

}
