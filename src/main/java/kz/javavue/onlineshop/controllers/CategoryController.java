package kz.javavue.onlineshop.controllers;

import com.google.gson.Gson;
import kz.javavue.onlineshop.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @CrossOrigin
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String showCategories() {
        return new Gson().toJson(categoryDao.getCategories());
    }


}
