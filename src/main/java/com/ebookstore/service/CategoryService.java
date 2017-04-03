/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebookstore.service;

import com.ebookstore.exception.CategoryAlreadyExist;
import com.ebookstore.model.Category;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Narada
 */
@Stateless
public class CategoryService {
    
    @PersistenceContext(unitName = "BookStorePU")
    EntityManager em;
    
    public Category addNewCategory(Category category) throws CategoryAlreadyExist {
        Query query = em.createQuery("select c from Category c where "
                + "c.categoryName = :categoryName");
        query.setParameter("categoryName", category.getCategoryName());
        try {
            query.getSingleResult();
            throw new CategoryAlreadyExist();
        } catch (NoResultException exception) {
            Logger.getLogger(com.ebookstore.service.CategoryService.class.getName()).log(Level.FINER, "No category found");
        }
        em.persist(category);
        em.flush();
        return category;
    }
}
