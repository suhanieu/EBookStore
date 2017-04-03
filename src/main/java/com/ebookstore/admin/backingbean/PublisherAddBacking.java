/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebookstore.admin.backingbean;

import com.ebookstore.exception.CategoryAlreadyExist;
import com.ebookstore.exception.PublisherAlreadyExist;
import com.ebookstore.model.Category;
import com.ebookstore.model.Publisher;
import com.ebookstore.service.PublisherService;
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
@Named(value = "publisherAddBacking")
@ViewScoped
public class PublisherAddBacking {

    @EJB
    PublisherService publisherService;
    
    @Named
    @Produces
    @RequestScoped
    Publisher publisher = new Publisher();

    
     public String createPublisher() {

        try {
            publisher = publisherService.addNewCategory(publisher);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Saved Successfully"));
            clear();
            publisher = new Publisher();
        } catch (PublisherAlreadyExist pEx) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Already Exists"));
            clear();

        } catch (Exception ex) {
            //Logger.getLogger(CategoryAddBacking.class.getName()).log(Level.SEVERE, null, ex);
            publisher = new Publisher();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error Occurs"));
        }
        return null;

    }

    public void clear() {
       publisher.setPublisherName("");
       publisher.setAddress("");
       publisher.setEmail("");
       publisher.setTelNo("");
    }
}
