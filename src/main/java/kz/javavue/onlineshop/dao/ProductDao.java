package kz.javavue.onlineshop.dao;

import kz.javavue.onlineshop.mapper.ProductsMapper;
import kz.javavue.onlineshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class ProductDao extends JdbcDaoSupport {

    @Autowired
    public ProductDao(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    public List<Product> getProducts(){
        String sql = ProductsMapper.BASE_SQL;
        ProductsMapper mapper = new ProductsMapper();
        assert this.getJdbcTemplate() != null;
        List<Product> list = this.getJdbcTemplate().query(sql, mapper);
        return list;
    }

    public List<Product> getProducts(String category) throws SQLException {
        String sql = "select * from products where category_name=?";
        ProductsMapper mapper = new ProductsMapper();
        assert this.getJdbcTemplate() != null;
        List<Product> list = this.getJdbcTemplate().query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, category);
            }
        }, mapper);
        return list;
    }
}
