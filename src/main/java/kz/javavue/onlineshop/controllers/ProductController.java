package kz.javavue.onlineshop.controllers;

import com.google.gson.Gson;
import kz.javavue.onlineshop.dao.ProductDao;
import kz.javavue.onlineshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductDao productDao;

    @CrossOrigin
    @RequestMapping(value = "/allproducts", method = RequestMethod.GET)
    public String showCategories() {
        return new Gson().toJson(productDao.getProducts());
    }

    @CrossOrigin
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> showCategory(@RequestParam("category_name") String category_name) throws SQLException {
        return productDao.getProducts(category_name);
    }
}
