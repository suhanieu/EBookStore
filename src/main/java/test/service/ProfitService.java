/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.service;

import com.ebookstore.model.Profit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Suha
 */
@Stateless
public class ProfitService {

    @PersistenceContext(unitName = "BookStorePU")
    EntityManager em;
   
    public void getAllMonth()
    {
    String q="select p from Profit p";
    Query query=em.createQuery(q);
    List<Profit>pList=query.getResultList();
    for(Profit p:pList){
    
        System.out.println(p.getMonth());
    }

  }
    
    
}