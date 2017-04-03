/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebookstore.service;

import com.ebookstore.model.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Narada
 */
@Stateless
public class BookService {

    @PersistenceContext(unitName = "BookStorePU")
    EntityManager em;

    public List<Book> getAllBook() {
        Query query = em.createNamedQuery("Book.findAll", Book.class);
        List<Book> bookList = query.getResultList();
        
        return bookList;
    }

}