package com.ebookstore.admin.backingbean;

import com.ebookstore.exception.CategoryAlreadyExist;
import com.ebookstore.model.Category;
import com.ebookstore.service.CategoryService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Narada
 */
@Named(value = "categoryAddBAcking")
@ViewScoped
public class CategoryAddBAcking implements Serializable {

    @EJB
    CategoryService categoryService;

    @Named
    @Produces
    @RequestScoped
    Category category = new Category();

    public String createCategory() {

        try {
            category = categoryService.addNewCategory(category);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Saved Successfully"));
            clear();
            category = new Category();
        } catch (CategoryAlreadyExist cAEx) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Already Exists"));
            clear();

        } catch (Exception ex) {
            //Logger.getLogger(CategoryAddBacking.class.getName()).log(Level.SEVERE, null, ex);
            category = new Category();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error Occurs"));
        }
        return null;

    }

    public void clear() {
        category.setCategoryName("");
    }
}
