package com.ebookstore.customer.backingbean;

import com.ebookstore.model.Category;
import com.ebookstore.service.CategoryService;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Suha
 */
@Named(value = "customerCategoryDisplayBacking")
@ViewScoped
public class CustomerCategoryDisplayBacking {

    @EJB
    CategoryService categoryService;

    List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void readCategoryList() {
        categoryList = categoryService.getAllCategory();
    }

}
