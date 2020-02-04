package kz.javavue.onlineshop.dao;

import kz.javavue.onlineshop.mapper.CategoriesMapper;
import kz.javavue.onlineshop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CategoryDao extends JdbcDaoSupport {

    @Autowired
    public CategoryDao(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    public List<String> getCategories(){
        String sql = CategoriesMapper.BASE_SQL;
        Object[] params = new Object[]{};
        CategoriesMapper mapper = new CategoriesMapper();
        assert this.getJdbcTemplate() != null;
        List<Category> list = this.getJdbcTemplate().query(sql, params, mapper);
        List<String> category_names = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            category_names.add(list.get(i).getCategoryName());
        }
        return category_names;
    }
}
