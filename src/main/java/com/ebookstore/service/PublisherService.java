package com.ebookstore.service;

import com.ebookstore.exception.PublisherAlreadyExist;
import com.ebookstore.model.Publisher;
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
public class PublisherService {

    @PersistenceContext(unitName = "BookStorePU")
    EntityManager em;

    public Publisher addNewCategory(Publisher publisher) throws PublisherAlreadyExist {
        Query query = em.createQuery("select p from Publisher p where "
                + "p.publisherName = :publisherName");
        query.setParameter("publisherName", publisher.getPublisherName());
        try {
            query.getSingleResult();
            throw new PublisherAlreadyExist();
        } catch (NoResultException exception) {
            Logger.getLogger(com.ebookstore.service.PublisherService.class.getName()).log(Level.FINER, "No publisher found");
        }
        em.persist(publisher);
        em.flush();
        return publisher;
    }

}
